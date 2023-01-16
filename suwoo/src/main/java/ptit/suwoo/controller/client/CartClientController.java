package ptit.suwoo.controller.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ptit.suwoo.Dto.gioHangDTO.GioHangSanPhamDTO;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.giohang.GioHang;
import ptit.suwoo.model.giohang.GioHangSanPham;
import ptit.suwoo.sanphamRepository.SanPhamRepository;
import ptit.suwoo.service.CategoryService;
import ptit.suwoo.service.GioHangSanPhamService;
import ptit.suwoo.service.GioHangService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CartClientController {
    @Autowired
    GioHangService gioHangService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @Autowired
    GioHangSanPhamService gioHangSanPhamService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung.getName() != null) {
            GioHang gioHangs = gioHangService.findAllGioHangActive(nguoiDung.getId());
            System.err.println("Gio hang id" + gioHangs.getId());
            Optional<SanPham> sanPham = sanPhamRepository.findById(id);

//            List<GioHangSanPham> gioHangSanPhams2 = new ArrayList<>();
            if (sanPham.isPresent()) {
                Optional<GioHangSanPham> ghsp = gioHangSanPhamRepository.findSpInGioHangId(id,gioHangs.getId());
                if (ghsp.isPresent()) {
                    ghsp.get().setSoLuong(ghsp.get().getSoLuong() + 1);
                    gioHangSanPhamRepository.save(ghsp.get());
                } else {
                    GioHangSanPham g = new GioHangSanPham();
                    g.setGioHang(gioHangs);
                    g.setSanPham(sanPham.get());
                    g.setSoLuong(1);
                    g.setActive(true);
                    gioHangSanPhamRepository.save(g);
                }

            }

            return "redirect:/Cart";
        } else return "loginClient";
    }

    @GetMapping("/Cart")
    public String findCart(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung.getName() != null) {
            GioHang gioHangs = gioHangService.findAllGioHangActive(nguoiDung.getId());
            System.err.println("gio hang:" + gioHangs.getId());
            List<GioHangSanPham> gioHangSanPhams = gioHangSanPhamRepository.findAllByGioHangId(gioHangs.getId());
            List<GioHangSanPhamDTO> gioHangSanPhamDTOS = new ArrayList<>();
            if (gioHangSanPhams != null) {
                gioHangSanPhams.forEach((e) -> {
                    gioHangSanPhamDTOS.add(e.convertToDto());
                });
                model.addAttribute("giohangsps", gioHangSanPhamDTOS);
            } else model.addAttribute("giohangsps", gioHangSanPhams);
            Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
            model.addAttribute("quantityCart", quantityCart);
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "cartClient";
        } else return "loginClient";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String email = user.getUsername();
            NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
            if (nguoiDung.getName() != null) {

                    gioHangSanPhamService.deleteProduct(id);
            }
            return "redirect:/Cart";
        }
        else return "loginClient";

    }
}
