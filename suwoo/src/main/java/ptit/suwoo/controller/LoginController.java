package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ptit.suwoo.Dto.AdminDTO;
import ptit.suwoo.Repository.*;
import ptit.suwoo.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class LoginController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/adminImages";
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @GetMapping({"/","/home","/index"})
    public String index(HttpServletRequest request, HttpSession session, Principal principal){
        String user = principal.getName();
        System.err.println(user);
        NguoiDung nd = nguoiDungRepository.findByEmail(user);
        String nameUser= nd.getName();

        return "home_admin";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/addStaff")
    public String addstaff(Model model){
        model.addAttribute("title","Thêm nhân viên");
        model.addAttribute("nguoiDung", new AdminDTO());
        return "add_staff";
    }
    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("nguoiDung") NguoiDung nguoiDung, HttpServletRequest request) {
        if(nguoiDungRepository.findByEmail(nguoiDung.getEmail())!=null) return "register";
        nguoiDung.setMatKhau(bCryptPasswordEncoder.encode(nguoiDung.getMatKhau()));
        System.out.println(nguoiDung.isGioiTinh());
        KhachHang kh = new KhachHang();
        kh.setId(nguoiDung.getId());
        kh.setEmail(nguoiDung.getEmail());
        kh.setName(nguoiDung.getName());
        kh.setDiaChi(nguoiDung.getDiaChi());
        kh.setSdt(nguoiDung.getSdt());
        kh.setGioiTinh(nguoiDung.isGioiTinh());
        kh.setMatKhau(nguoiDung.getMatKhau());
        kh.setNgaySinh(nguoiDung.getNgaySinh());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        kh.setNgayDangKy(dtf.format(now));
        khachHangRepository.save(kh);
        NguoiDung nd = nguoiDungRepository.findByEmail(nguoiDung.getEmail());
        Optional<Role> r = roleRepository.findById(1);
        UserRole ur = new UserRole();
        ur.setIdRole(r.get());
        ur.setIdUser(nd);
        userRoleRepository.save(ur);
        return "login";
    }
    @PostMapping("/addStaff")
    public String addStaff(@ModelAttribute("nguoiDung") AdminDTO nguoiDung,@ModelAttribute("title") String title,
    @RequestParam("adminImage") MultipartFile file, @RequestParam("urlImg") String urlImg
            ,HttpServletRequest request) throws IOException {
            System.err.println(nguoiDung.getId());
            System.err.println(title);

        Admin a = new Admin();
        boolean kt = nguoiDung.getId().equals("");
        System.err.println("id: "+nguoiDung.getId());
            if(kt) {
                if (nguoiDungRepository.findByEmail(nguoiDung.getEmail()) != null) return "addStaff";
                a.setMatKhau(bCryptPasswordEncoder.encode("1234"));
            }
            else {
                a.setId(Long.valueOf(nguoiDung.getId()));
                a.setMatKhau(nguoiDung.getMatKhau());
            }
        System.out.println(nguoiDung.isGioiTinh());
        a.setEmail(nguoiDung.getEmail());
        a.setName(nguoiDung.getName());
        a.setDiaChi(nguoiDung.getDiaChi());
        a.setSdt(Integer.parseInt(nguoiDung.getSdt()));
        a.setGioiTinh(nguoiDung.isGioiTinh());
        a.setNgaySinh(Date.valueOf(nguoiDung.getNgaySinh()));
        System.err.println("name IMG: "+ urlImg);
        String imageUUID;
        String nameFile=file.getOriginalFilename();
        if(!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Random random=new Random();
            String ext="";
            for (int i = imageUUID.length()-1; i >=0 ; i--) {
                if (imageUUID.charAt(i)=='.'){
                    ext = imageUUID.substring(i,imageUUID.length());
                }
            }
            System.err.println("urlIMG: "+urlImg.equals(""));
            Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
            int t = 1;
            while (t==1){
                nameFile = String.format("%s%s",System.currentTimeMillis(),random.nextInt(100000)+ext);
                fileNameAndPath = Paths.get(uploadDir,nameFile);
                boolean exists = Files.exists(fileNameAndPath);
                if (!exists) t=0;
            }
            if (!urlImg.equals("")&&!kt){
                Path fileNameAndPathOld = Paths.get(uploadDir,urlImg);
                String f = fileNameAndPathOld.toString();
                File fl = new File(f);
                if (!fl.isDirectory()){
                    Files.deleteIfExists(fileNameAndPathOld);
                }

            }
            System.err.println("imageUUID: "+ nameFile);
            Files.write(fileNameAndPath, file.getBytes());
            a.setUrlImg(nameFile);
        }

        else {
            a.setUrlImg(urlImg);
        }
        adminRepository.save(a);
        NguoiDung nd = nguoiDungRepository.findByEmail(nguoiDung.getEmail());
        List<Role> list = roleRepository.findAll();
        String role = request.getParameter("role");
        System.out.println(role);
        UserRole ur = new UserRole();
        Long idR;
        for (Role rl:list) {
            if (role.equals(rl.getRole())){
                idR = rl.getId();
                ur.setIdRole(rl);
                ur.setIdUser(nd);
            }
        }
        userRoleRepository.save(ur);
        return "redirect:/managerStaff";
    }
}