package ptit.suwoo.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Dto.hoadondto.HoaDonDTO;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.Repository.KhachHangRepository;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.hoadon.HoaDon;
import ptit.suwoo.model.hoadon.SanPhamHoaDon;
import ptit.suwoo.sanphamRepository.HoaDonRepository;
import ptit.suwoo.sanphamRepository.SanPhamHoaDonRepository;
import ptit.suwoo.service.HoaDonService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class UserProfileController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    SanPhamHoaDonRepository sanPhamHoaDonRepository;
    @GetMapping("/user-profile")
    public String loadProfile(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            Integer quantityCart = gioHangSanPhamRepository.countProduct(khachHang.get().getId());
            model.addAttribute("quantityCart", quantityCart);
            model.addAttribute("khachhang",khachHang.get());
            return "user-profile";
        }
        else {
            return "redirect:/login";
        }

    }
    @PostMapping("/user-profile")
    public String updateProfile(@ModelAttribute("khachhang") KhachHang kh, @RequestParam("gioitinh")boolean gt,
                                @RequestParam(value = "avatar") MultipartFile file, Model model) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            if (!(kh.getName().trim().equals(khachHang.get().getName())&& kh.getNgaySinh().equals(khachHang.get().getNgaySinh())
                    &&gt==khachHang.get().isGioiTinh()&&kh.getSdt()==khachHang.get().getSdt()
                    &&kh.getDiaChi().trim().equals(khachHang.get().getDiaChi())&& file.isEmpty())){
                if(!file.isEmpty()) {
                    String nameFile=file.getOriginalFilename();
                    Random random=new Random();
                    String ext="";
                    for (int i = nameFile.length()-1; i >=0 ; i--) {
                        if (nameFile.charAt(i)=='.'){
                            ext = nameFile.substring(i,nameFile.length());
                        }
                    }
                    Path fileNameAndPath = Paths.get(uploadDir,nameFile);
                    int t = 1;
                    while (t==1){
                        nameFile = String.format("%s%s",System.currentTimeMillis(),random.nextInt(100000)+ext);
                        fileNameAndPath = Paths.get(uploadDir,nameFile);
                        boolean exists = Files.exists(fileNameAndPath);
                        if (!exists) t=0;
                    }
                    Files.write(fileNameAndPath, file.getBytes());
                    khachHang.get().setUrlImg(nameFile);
                }
                khachHang.get().setName(kh.getName().trim());
                khachHang.get().setSdt(kh.getSdt());
                khachHang.get().setNgaySinh(kh.getNgaySinh());
                khachHang.get().setDiaChi(kh.getDiaChi());
                khachHang.get().setGioiTinh(gt);
                khachHangRepository.save(khachHang.get());
                return "redirect:/user-profile";
            }
            else {
                return "redirect:/user-profile";
            }
        }
        else {
            return "redirect:/login";
        }

    }
    @GetMapping("/user-resetpass")
    public String showresetpass(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            Integer quantityCart = gioHangSanPhamRepository.countProduct(khachHang.get().getId());
            model.addAttribute("quantityCart", quantityCart);
            return "user-resetpasss";

        }
        else return "redirect:/login";
    }
    @PostMapping("/user-resetpass")
    public String resetpass(@RequestParam("passOld")String passCu, @RequestParam("passNew")String passMoi
            ,@RequestParam("passNew2")String xacnhan, Model model, RedirectAttributes redirectAttributes){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            System.err.println("so sanh mat khau: "+ bCryptPasswordEncoder.matches(passCu,khachHang.get().getMatKhau()));
            if (!(passMoi.matches("^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[^a-zA-Z]).{8,40}$")&&passMoi.matches("\\S+"))){
                redirectAttributes.addFlashAttribute("error","*Mật khẩu lớn hơn 8 và nhỏ hơn 40 ký tự bao gồm chữ hoa, chữ thường và số.");
                return "redirect:/user-resetpass";
            }
            else if (bCryptPasswordEncoder.matches(passCu,khachHang.get().getMatKhau())){
                if ((passMoi.equals(xacnhan)) && passMoi.length()>=8){
                    try{
                        khachHangRepository.updatePass(bCryptPasswordEncoder.encode(passMoi),khachHang.get().getId());
                        redirectAttributes.addFlashAttribute("success","Thay đổi mật khẩu thành công!!!");
                        return "redirect:/user-profile";
                    }
                    catch (Exception e){
                        redirectAttributes.addFlashAttribute("error","Không thành công!!!");
                        return "redirect:/user-resetpass";
                    }
                }
                else {
                    redirectAttributes.addFlashAttribute("error","Mật khẩu xác nhận chưa đúng hoặc ngắn hơn 8 ký tự");
                    return "redirect:/user-resetpass";
                }
            }
            else {
                redirectAttributes.addFlashAttribute("error","Mật khẩu cũ chưa chính xác. Vui lòng nhập lại!!!");
                return "redirect:/user-resetpass";
            }
        }
        else return "redirect:/login";
    }
    @GetMapping("/user-bill")
    public String getBillUser(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            return getBillUser(1,model);
        }
        else return "redirect:/login";
    }
    @GetMapping("/user-bill/{page}")
    public String getBillUser(@PathVariable int page, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            Page<HoaDon> hoaDonPage = hoaDonService.findHDUser(page,5,khachHang.get().getId());
            List<HoaDonDTO> hoaDonDTOS = new ArrayList<>();
            for (HoaDon hd:hoaDonPage.toList()){
                hd.setSanPhamHoaDons(sanPhamHoaDonRepository.findSPHDByHD(hd.getId()));
                HoaDonDTO a = hd.convertToDTO();
                hoaDonDTOS.add(a);
            }
            Integer quantityCart = gioHangSanPhamRepository.countProduct(khachHang.get().getId());
            model.addAttribute("quantityCart", quantityCart);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", hoaDonPage.getTotalPages());
            model.addAttribute("totalItems", hoaDonPage.getTotalElements());
            model.addAttribute("hoadons",hoaDonDTOS);
            return "bill-history";
        }
        else return "redirect:/login";
    }

    @GetMapping("/bill-details/{id}")
    public String getBillDetail(@PathVariable Long id, Model model,RedirectAttributes redirectAttributes){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            Optional<HoaDon> hd = hoaDonRepository.findHD(id, khachHang.get().getId());
            if(hd.isPresent()){
                hd.get().setSanPhamHoaDons(sanPhamHoaDonRepository.findSPHDByHD(hd.get().getId()));
                HoaDonDTO a = hd.get().convertToDTO();
                model.addAttribute("hoadon", a);
                return "bill-details";
            }
            else {
                redirectAttributes.addFlashAttribute("error","Không tìm thấy hóa đơn yêu cầu!!!");
                return "redirect:/user-bill";
            }
        }
        else return "redirect:/login";
    }

    @GetMapping("/bill-cancel/{id}")
    public String huyDonHang(@PathVariable Long id, RedirectAttributes redirectAttributes){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()){
            Optional<HoaDon> hd = hoaDonRepository.findHD(id, khachHang.get().getId());
            if(hd.isPresent() && hd.get().getTinhTrang().equals("Chờ xác nhận")){
                try {
                    hoaDonRepository.updateHDTinhTrang("Đã hủy",id);
                    redirectAttributes.addFlashAttribute("success", "Hủy đơn hàng thành công");
                    return "redirect:/user-bill";
                } catch (Exception e) {
                    redirectAttributes.addFlashAttribute("error", "Hủy đơn hàng thất bại");
                    return "redirect:/user-bill";
                }
            }
            else {
                redirectAttributes.addFlashAttribute("error","Không tìm thấy hóa đơn yêu cầu!!!");
                return "redirect:/user-bill";
            }
        }
        else return "redirect:/login";
    }
}
