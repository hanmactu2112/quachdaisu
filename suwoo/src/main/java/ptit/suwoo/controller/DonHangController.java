package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Dto.hoadondto.HoaDonDTO;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.model.hoadon.HoaDon;
import ptit.suwoo.sanphamRepository.HoaDonRepository;
import ptit.suwoo.sanphamRepository.SanPhamHoaDonRepository;
import ptit.suwoo.service.HoaDonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DonHangController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    SanPhamHoaDonRepository sanPhamHoaDonRepository;

    @GetMapping("/admin/manage-order")
    public String searchOrder(@RequestParam(name = "key", required = false) String key
            , @RequestParam(name = "status", required = false) String status,Model model) {
        System.out.println("key: "+ key);
        System.out.println("status: "+ status);
        return findOrderPage(1,key,status,model);
    }

    @GetMapping("/admin/manage-order/{page}")
    public String findOrderPage(@PathVariable int page, String key, String status, Model model) {
        Page<HoaDon> hoaDons = hoaDonService.findHD(page,5, key, status);
        List<HoaDonDTO> hoaDonDTOList = new ArrayList<>();
        hoaDons.toList().forEach((e)->{
            hoaDonDTOList.add(e.convertToDTO());
        });
        model.addAttribute("hoadons",hoaDonDTOList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", hoaDons.getTotalPages());
        model.addAttribute("totalItems", hoaDons.getTotalElements());
        return "manage-order";
    }
    @GetMapping("/admin/manage-order-details/{id}")
    public String orderDetail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Optional<HoaDon> hd = hoaDonRepository.findHDById(id);
        if(hd.isPresent()){
            hd.get().setSanPhamHoaDons(sanPhamHoaDonRepository.findSPHDByHD(hd.get().getId()));
            HoaDonDTO a = hd.get().convertToDTO();
            model.addAttribute("hoadon", a);
            return "manage-order-details";
        }
        else {
            redirectAttributes.addFlashAttribute("error","Không tìm thấy hóa đơn");
            return "redirect:/admin/manage-order";
        }
    }
    @GetMapping("/admin/updateStatusOrder/{id}")
    public String updateStatusOrder(@PathVariable Long id,@RequestParam("status")String status, RedirectAttributes redirectAttributes){
        if (status.equals("Chờ xác nhận")||status.equals("Đã hủy")||status.equals("Đang xử lý")||status.equals("Đang giao hàng")
        ||status.equals("Giao hàng thành công")||status.equals("Giao hàng thất bại")){
            try {
                hoaDonRepository.updateHDTinhTrang(status,id);
                redirectAttributes.addFlashAttribute("success","Cập nhật thành công");
                return "redirect:/admin/manage-order";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error","Không tìm thấy hóa đơn");
                return "redirect:/admin/manage-order";
            }
        }
        else {
            redirectAttributes.addFlashAttribute("error","Không tìm thấy hóa đơn");
            return "redirect:/admin/manage-order";
        }

    }

}
