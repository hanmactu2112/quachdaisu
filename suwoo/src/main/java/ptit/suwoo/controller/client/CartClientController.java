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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ptit.suwoo.Dto.gioHangDTO.GioHangDTO;
import ptit.suwoo.Dto.gioHangDTO.GioHangSanPhamDTO;
import ptit.suwoo.Repository.*;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.KhachHang;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.giohang.GioHang;
import ptit.suwoo.model.giohang.GioHangSanPham;
import ptit.suwoo.model.hoadon.HoaDon;
import ptit.suwoo.model.hoadon.SanPhamHoaDon;
import ptit.suwoo.model.maGiamGia.KhachHangMaGiamGia;
import ptit.suwoo.model.maGiamGia.MaGiamGia;
import ptit.suwoo.sanphamRepository.HoaDonRepository;
import ptit.suwoo.sanphamRepository.SanPhamRepository;
import ptit.suwoo.service.CategoryService;
import ptit.suwoo.service.GioHangSanPhamService;
import ptit.suwoo.service.GioHangService;

import java.sql.Date;
import java.time.LocalDate;
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
    MaGiamGiaRepository maGiamGiaRepository;
    @Autowired
    GioHangSanPhamService gioHangSanPhamService;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    KhachHangMaGiamGiaRepository khachHangMaGiamGiaRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;
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
    @PostMapping("/updateCart")
    public String updateCart(@RequestParam("idgiohang") List<Long> id,@RequestParam("quantity") List<Integer> quantity, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung.getName() != null && id!=null&&quantity!=null) {
            GioHang gioHangs = gioHangService.findAllGioHangActive(nguoiDung.getId());
            for(GioHangSanPham gs : gioHangs.getGioHangSanPhams()){
                System.err.println("Id gio hang:"+gs.getId()+" soluong: "+gs.getSoLuong());
                for (int i=0;i<id.size();i++){
                    System.err.println("Id: "+id.get(i)+" quantity: "+quantity.get(i));
                    if (gs.getId().equals(id.get(i)) && gs.getSoLuong() != quantity.get(i)){
                        System.err.println("Da chay den day");
                        gioHangSanPhamService.updateCart(quantity.get(i),id.get(i));
                    }
                }
            }

            return "redirect:/Cart";
        } else return "loginClient";
    }
    @PostMapping("/addToCart")
    public String addToCart2(@RequestParam("idSp") Long id,@RequestParam("quantity") Integer quantity,
                             Model model) {
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
                    ghsp.get().setSoLuong(ghsp.get().getSoLuong() + quantity);
                    gioHangSanPhamRepository.save(ghsp.get());
                } else {
                    GioHangSanPham g = new GioHangSanPham();
                    g.setGioHang(gioHangs);
                    g.setSanPham(sanPham.get());
                    g.setSoLuong(quantity);
                    g.setActive(true);
                    gioHangSanPhamRepository.save(g);
                }

            }
            return "redirect:/Cart";
        } else return "loginClient";
    }

    @GetMapping("/Cart")
    public String findCart(@RequestParam(value = "coupon",required = false) String coupon, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung.getName() != null) {
            GioHang gioHangs = gioHangService.findAllGioHangActive(nguoiDung.getId());
            System.err.println("gio hang:" + gioHangs.getId());
            GioHang gioHang = new GioHang();
            List<GioHangSanPham> gioHangSanPhams = gioHangSanPhamRepository.findAllByGioHangId(gioHangs.getId());

            gioHang.setId(gioHangs.getId());
            KhachHang kh = new KhachHang();
            kh.setId(nguoiDung.getId());
            gioHang.setKhachHang(kh);
            gioHang.setGioHangSanPhams(gioHangSanPhams);
            GioHangDTO gioHangDTOS = gioHang.convertToDto();
            List<GioHangSanPhamDTO> gioHangSanPhamDTOS = new ArrayList<>();
            if (gioHangSanPhams != null) {
                gioHangSanPhams.forEach((e) -> {
                    gioHangSanPhamDTOS.add(e.convertToDto());
                });
                model.addAttribute("giohangsps", gioHangSanPhamDTOS);
            } else model.addAttribute("giohangsps", gioHangSanPhams);
            Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
            GioHangDTO gioHangDTOList;
            if (coupon!=null){
                Optional<KhachHangMaGiamGia> khmgg = khachHangMaGiamGiaRepository.checkActiveMGG(nguoiDung.getId(),coupon);
                if (khmgg.isPresent()){

                    long millis=System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    System.out.println(date);
                    double tongTien = 0.0;
                    for (GioHangSanPham a: gioHang.getGioHangSanPhams()){
                        if (a.getSanPham().getKhuyenMai()!=null){
                            tongTien += Math.round((a.getSanPham().getGia()-a.getSanPham().getGia()*(a.getSanPham().getKhuyenMai().getTiLe()/100))*a.getSoLuong());
                        }else {
                            tongTien += Math.round(a.getSanPham().getGia()*a.getSoLuong());
                        }
                        gioHangSanPhamDTOS.add(a.convertToDto());
                    }
                    if (tongTien < khmgg.get().getMaGiamGia().getDonHangTu()){
                        gioHangDTOList = gioHang.convertToDto();
                        model.addAttribute("couponError","Giá trị đơn hàng chưa đủ!!!");
                    }
                    else if (date.compareTo(khmgg.get().getMaGiamGia().getNgayBd()) >=0 && khmgg.get().getMaGiamGia().getNgayKt().compareTo(date)>=0) {
                        gioHangDTOList = gioHang.convertToDto(khmgg.get());
                        model.addAttribute("couponSucess","Mã giảm giá được áp dụng thành công");
                    }
                    else {
                        gioHangDTOList = gioHang.convertToDto();
                        model.addAttribute("couponError","Mã giảm giá quá hạn!!!");
                    }
                }
                else {
                    gioHangDTOList = gioHang.convertToDto();
                    model.addAttribute("couponError","Mã giảm giá đã được bạn sử dụng hoặc không đúng!!!");
                }
            } else gioHangDTOList = gioHang.convertToDto();
            model.addAttribute("coupon", coupon);
            model.addAttribute("quantityCart", quantityCart);
            model.addAttribute("giohangs", gioHangDTOList);
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
    @GetMapping("/addCoupon")
    public String addCoupon(@RequestParam("coupon") String coupon,Model model) {
        return findCart(coupon,model);
    }
    @GetMapping("/subCart")
    public String subCart(@RequestParam(name = "couponcart",required = false) String coupon,
                          @RequestParam(name = "shipping",required = false)String ship,
                          Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername();
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung.getName() != null) {
            GioHang gioHangs = gioHangService.findAllGioHangActive(nguoiDung.getId());
            System.err.println("gio hang:" + gioHangs.getId());
            GioHang gioHang = new GioHang();
            List<GioHangSanPham> gioHangSanPhams = gioHangSanPhamRepository.findAllByGioHangId(gioHangs.getId());

            gioHang.setId(gioHangs.getId());
            KhachHang kh = new KhachHang();
            kh.setId(nguoiDung.getId());
            gioHang.setKhachHang(kh);
            gioHang.setGioHangSanPhams(gioHangSanPhams);
            GioHangDTO gioHangDTOS = gioHang.convertToDto();
            List<GioHangSanPhamDTO> gioHangSanPhamDTOS = new ArrayList<>();
            if (gioHangSanPhams != null) {
                gioHangSanPhams.forEach((e) -> {
                    gioHangSanPhamDTOS.add(e.convertToDto());
                });
                model.addAttribute("giohangsps", gioHangSanPhamDTOS);
            } else model.addAttribute("giohangsps", gioHangSanPhams);
            Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
            GioHangDTO gioHangDTOList;
            if (coupon!=null){
                Optional<KhachHangMaGiamGia> khmgg = khachHangMaGiamGiaRepository.checkActiveMGG(nguoiDung.getId(),coupon);
                if (khmgg.isPresent()){
                    long millis=System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    System.out.println(date);
                    double tongTien = 0.0;
                    for (GioHangSanPham a: gioHang.getGioHangSanPhams()){
                        if (a.getSanPham().getKhuyenMai()!=null){
                            tongTien += Math.round((a.getSanPham().getGia()-a.getSanPham().getGia()*(a.getSanPham().getKhuyenMai().getTiLe()/100))*a.getSoLuong());
                        }else {
                            tongTien += Math.round(a.getSanPham().getGia()*a.getSoLuong());
                        }
                        gioHangSanPhamDTOS.add(a.convertToDto());
                    }
                    gioHangDTOList = gioHang.convertToDto(khmgg.get());
                }
                else {
                    gioHangDTOList = gioHang.convertToDto();
                }
            } else gioHangDTOList = gioHang.convertToDto();
            if (ship!=null){
                switch (ship) {
                    case "1":
                        model.addAttribute("shipping", "Lấy trực tiếp tại cửa hàng");
                        break;
                    case "2":
                        model.addAttribute("shipping", "Miễn phí giao hàng");
                        break;
                    case "3":
                        model.addAttribute("shipping", "Giao hàng nhanh");
                        break;
                }
            }
            model.addAttribute("coupon", coupon);
            model.addAttribute("tenkh",nguoiDung.getName());
            model.addAttribute("diachi",nguoiDung.getDiaChi());
            model.addAttribute("sdt",nguoiDung.getSdt());
            model.addAttribute("email",nguoiDung.getEmail());
            model.addAttribute("quantityCart", quantityCart);
            model.addAttribute("giohangs", gioHangDTOList);
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "payment";
        } else return "loginClient";

    }
    @PostMapping("/subOrder")
    public String subOrder(@RequestParam(name = "tenkh") String tenkh,
                           @RequestParam(name = "sdt") String sdt,
                           @RequestParam(name = "diachi") String diachi,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "ghichu",required = false) String ghichu,
                           @RequestParam(name = "magiamgia",required = false) String coupon,
                           @RequestParam(name = "shipping") String shipping,
                           Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String emailkh = user.getUsername();
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(emailkh);
        if (khachHang.isPresent()) {
            HoaDon hd = new HoaDon();
            hd.setNguoiNhan(tenkh);
            hd.setSdt(sdt);
            hd.setDiaChi(diachi);
            hd.setEmail(email);
            hd.setGhiChu(ghichu);
            hd.setKhachHang(khachHang.get());
            hd.setShipping(shipping);
            if (coupon!=null){
                MaGiamGia maGiamGia = maGiamGiaRepository.findMGGByCode(coupon).get();
                hd.setMaGiamGia(maGiamGia);

            }
            if (ghichu!=null&&ghichu.equals("1")){
                hd.setXuatHD(true);
            }
            else hd.setXuatHD(false);
            GioHang gioHangs = gioHangService.findAllGioHangActive(khachHang.get().getId());
            List<GioHangSanPham> gioHangSanPhams = gioHangSanPhamRepository.findAllByGioHangId(gioHangs.getId());
            List<SanPhamHoaDon> list = new ArrayList<>();
            for (GioHangSanPham a:gioHangSanPhams){
                SanPhamHoaDon s = a.convertToSPHD();
                list.add(s);
                gioHangSanPhamRepository.updateActive(a.getId());
            }
            hd.setTinhTrang("Chờ xác nhận");
            LocalDate dtm = LocalDate.now();
            hd.setNgayTao(Date.valueOf(dtm));
            hd.setSanPhamHoaDons(list);
            hoaDonRepository.save(hd);
            if (coupon!=null)khachHangMaGiamGiaRepository.updateKHMGG(khachHang.get().getId(),coupon);
            return "redirect:/";
        }
        else return "loginCient";

    }

    /**
     * input? hidden? form? list?
     * function O/X     Query X]
     */
}
