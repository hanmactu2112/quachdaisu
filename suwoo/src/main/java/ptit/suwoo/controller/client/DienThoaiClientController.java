package ptit.suwoo.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.SanPhamService.DienThoaiService;
import ptit.suwoo.SanPhamService.SanPhamService;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.sanphamRepository.DienThoaiRepository;
import ptit.suwoo.sanphamdto.CameraDto;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.sanphamdto.DienThoaiDto;
import ptit.suwoo.sanphamdto.SanPhamDto;
import ptit.suwoo.service.CategoryService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DienThoaiClientController {
    @Autowired
    DienThoaiService dienThoaiService;
    @Autowired
    DienThoaiRepository dienThoaiRepository;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @GetMapping("/productDetailsClient/{id}")
    public String getDetailsDt(@PathVariable Long id, Model model) {
        Optional<DienThoai> dienThoai = dienThoaiService.findDtAndKmById(id);
        if (dienThoai.isPresent()) {
            DienThoaiDto dienThoaiDto = dienThoai.get().convertToDtDTOClientDetails();
            model.addAttribute("dienthoai", dienThoaiDto);
            Category category = categoryService.findCategoryByDt(id);
            CategoryDto categoryDto = category.convertToDto();
            List<DienThoai> listdt = dienThoaiService.findAllDtByIdCategory(categoryDto.getId());
            List<SanPhamDto> sanPhamDtos = new ArrayList<>();
            listdt.forEach((d) -> {
                SanPhamDto s = d.convertToDtDTOClient();
                sanPhamDtos.add(s);
            });
            List<CameraDto> cameraDtos = dienThoaiDto.getCameraDtoList();
            cameraDtos.forEach((e) -> {
                System.err.println("camera: " + e);
            });
            if (sanPhamDtos.size() < 15) {
                List<SanPhamDto> listFS = new ArrayList<>();
                List<DienThoai> listSpFs = sanPhamService.searhFlashSale();
                for (DienThoai a : listSpFs) {
                    SanPhamDto s = a.convertToDTOClient();
                    listFS.add(s);
                }
                sanPhamDtos.addAll(listFS);
            }
            System.err.println("flashsales " + sanPhamDtos.size());
            List<Category> categories = categoryService.findAll();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                String email = user.getUsername();
                NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
                if (nguoiDung.getName() != null) {
                    Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
                    model.addAttribute("quantityCart",quantityCart);
                }
            }
            model.addAttribute("categories",categories);
            model.addAttribute("flashsales", sanPhamDtos);
            model.addAttribute("category", categoryDto);
            model.addAttribute("loai", "Điện thoại");
            return "product-dt-details";
        } else return "redirect:/home";
    }

    @GetMapping("/viewListProductDt")
    public String findAllDtClient(@RequestParam(name = "sorting", required = false) String sort,Model model) {
        return pageProductDt(1,sort, model);
    }

    @GetMapping("/viewListProductDt/{page}")
    public String pageProductDt(@PathVariable Integer page,@RequestParam(name = "sorting", required = false) String sort, Model model) {
        Page<DienThoai> dienThoais = dienThoaiService.findAllDtClient(page, 20,sort);
        dienThoais.getTotalPages();
        System.err.println("Page: " + page);
        List<DienThoaiDto> dienThoaiDtos = new ArrayList<>();
        dienThoais.getContent().forEach((d) -> {
            DienThoaiDto dt = d.convertToDtDTOClient();
            dienThoaiDtos.add(dt);
        });
        HashSet<String> manHinhHS = new HashSet<>();
        List<String> groupByDPG = dienThoaiService.groupByDPG();
        groupByDPG.forEach((a) -> {
            Queue<Integer> q = new PriorityQueue<>();
            q.add(-1);
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '(' || a.charAt(i) == ')') q.add(i);
            }
            String mh = "";
            if (q.size() == 1) mh = null;
            while (q.size() > 1) {
                int start = q.peek() + 1;
                q.poll();
                mh += a.substring(start, q.peek());
                q.poll();
            }
            if (mh != null) {
                mh = mh.trim().replaceAll("\\s+", " ");
                manHinhHS.add(mh);
            }
        });
        ArrayList<String> dsManhinh = new ArrayList<>();
        dsManhinh.addAll(manHinhHS);
        List<String> hang = dienThoaiService.findAllHang();
        List<String> bonhos = dienThoaiService.groupByDTBN();
        bonhos.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        List<String> rams = dienThoaiService.groupByRAM();
        rams.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> tinhnangcams = dienThoaiService.groupByTinhNangCam();
        List<String> tinhnangs = new ArrayList<>();
        tinhnangcams.forEach((t) -> {
            t = t.trim().replaceAll("\\s+", " ");
            String[] tn = t.split(",");
            tinhnangs.addAll(Arrays.asList(tn));
        });
        System.err.println(tinhnangs + "tinhnagssss");
        tinhnangs.forEach((tns) -> {
            if (map.containsKey(tns)) {
                map.replace(tns.trim(), map.get(tns) + 1);
            } else map.put(tns.trim(), 1);
        });
        ArrayList<String> tn = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
        tn.subList(6, tn.size()).clear();
        System.out.println(tn);
        System.out.println(dienThoais.getTotalPages());
        if (sort !=null){
            switch (sort) {
                case "sortNameASC":
                    model.addAttribute("sort", "Tên a -> z");
                    break;
                case "sortNameDESC":
                    model.addAttribute("sort", "Tên z -> a");
                    break;
                case "sortPriceASC":
                    model.addAttribute("sort", "Giá tăng dần");
                    break;
                default:
                    model.addAttribute("sort", "Giá giảm dần");
                    break;
            }
        }
        else model.addAttribute("sort", sort);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String email = user.getUsername();
            NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
            if (nguoiDung.getName() != null) {
                Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
                model.addAttribute("quantityCart",quantityCart);
            }
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        System.err.println("hashSet: " + dsManhinh);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dienThoais.getTotalPages());
        model.addAttribute("totalItems", dienThoais.getTotalElements());
        model.addAttribute("manhinhs", manHinhHS);
        model.addAttribute("rams", rams);
        model.addAttribute("bonhos", bonhos);
        model.addAttribute("hangs", hang);
        model.addAttribute("dienthoais", dienThoaiDtos);
        model.addAttribute("tinhnangs", tn);
        return "product-list-dt";
    }

    @GetMapping("/viewListProductDtWithFilter")
    public String findAllDtWithFilterClient(@RequestParam(name = "hang", required = false) List<String> hang,
                                            @RequestParam(name = "heDieuHanh", required = false) List<String> heDieuHanh,
                                            @RequestParam(name = "kichthuoc", required = false) List<String> kichthuoc,
                                            @RequestParam(name = "manhinh", required = false) List<String> manhinh,
                                            @RequestParam(name = "bonho", required = false) List<String> bonho,
                                            @RequestParam(name = "ram", required = false) List<String> ram,
                                            @RequestParam(name = "pin", required = false) List<String> pin,
                                            @RequestParam(name = "tinhnang", required = false) List<String> tinhnang,
                                            @RequestParam(name = "giamin", required = false) Integer giaMin,
                                            @RequestParam(name = "giamax", required = false) Integer giaMax,
                                            @RequestParam(name = "sorting", required = false) String sort,
                                            Model model) {

        return pagefindAllDtWithFilterClient(hang, heDieuHanh, kichthuoc, manhinh, bonho, ram, pin, tinhnang, giaMin, giaMax,sort,1, model);
    }

    @GetMapping("/viewListProductDtWithFilter/{page}")
    public String pagefindAllDtWithFilterClient(
                                                @RequestParam(name = "hang", required = false) List<String> hang,
                                                @RequestParam(name = "heDieuHanh", required = false) List<String> heDieuHanh,
                                                @RequestParam(name = "kichthuoc", required = false) List<String> kichthuoc,
                                                @RequestParam(name = "manhinh", required = false) List<String> manhinh,
                                                @RequestParam(name = "bonho", required = false) List<String> bonho,
                                                @RequestParam(name = "ram", required = false) List<String> ram,
                                                @RequestParam(name = "pin", required = false) List<String> pin,
                                                @RequestParam(name = "tinhnang", required = false) List<String> tinhnang,
                                                @RequestParam(name = "giamin", required = false) Integer giaMin,
                                                @RequestParam(name = "giamax", required = false) Integer giaMax,
                                                @RequestParam(name = "sorting", required = false) String sort,
                                                @PathVariable(name = "page") Integer page,
                                                Model model) {
        if (giaMin == null) giaMin = 0;
        if (giaMax == null) giaMax = 0;
        System.out.println("Khoarng gia" + giaMin + " - " + giaMax);
        System.out.println("Dung luong pin: " + pin);
        if (hang == null && heDieuHanh == null && kichthuoc == null && manhinh == null
                && bonho == null && ram == null && pin == null && tinhnang == null && (giaMin == 0 && giaMax == 0)) {
            return pageProductDt(1,sort, model);
        }

        List<String> pinFilter = new ArrayList<>();
        if (pin != null && pin.size() < 3) {
            for (int i = 0; i < pin.size(); i++) {
                if (pin.get(i).equals("1")) {
                    List<String> a = dienThoaiRepository.filterPin1();
                    pinFilter.addAll(a);
                } else if (pin.get(i).equals("2")) {
                    List<String> a = dienThoaiRepository.filterPin2();
                    pinFilter.addAll(a);
                } else {
                    List<String> a = dienThoaiRepository.filterPin3();
                    pinFilter.addAll(a);
                }
            }
        }
        List<String> filterKT = new ArrayList<>();
        if (kichthuoc != null && kichthuoc.size() < 2) {
            for (int i = 0; i < kichthuoc.size(); i++) {
                if (kichthuoc.get(i).equals(">=6")) {
                    List<String> a = dienThoaiRepository.filterKT1();
                    filterKT.addAll(a);
                } else {
                    List<String> a = dienThoaiRepository.filterKT2();
                    filterKT.addAll(a);
                }
            }
        }
        List<String> filterDPG = new ArrayList<>();
        if (manhinh != null) {
            for (int i = 0; i < manhinh.size(); i++) {
                List<String> a = dienThoaiRepository.filterDPG(manhinh.get(i));
                filterDPG.addAll(a);
            }
        }
        List<String> filterCamera = new ArrayList<>();
        if (tinhnang != null) {
            for (int i = 0; i < tinhnang.size(); i++) {
                List<String> a = dienThoaiRepository.filterCamera(tinhnang.get(i));
                filterCamera.addAll(a);
            }
        }
        List<String> filterHang = new ArrayList<>();
        if (hang != null) {
            List<String> a = dienThoaiRepository.filterHang(hang);
            filterHang.addAll(a);
        }
        List<String> filterPrice = new ArrayList<>();
        if ((giaMin < giaMax)) {
            System.out.println("gia: " + giaMin + giaMax);
            List<String> a = dienThoaiRepository.filterGia(giaMin, giaMax);
            filterPrice.addAll(a);
        }
        List<String> filterHDH = new ArrayList<>();
        if (heDieuHanh != null) {
            for (int i = 0; i <heDieuHanh.size() ; i++) {
                List<String> a = dienThoaiRepository.filterHDH(heDieuHanh.get(i));
                filterHDH.addAll(a);
            }
        }
        List<String> filterRom = new ArrayList<>();
        if (bonho != null) {
            List<String> a = dienThoaiRepository.filterROM(bonho);
            filterRom.addAll(a);
        }
        List<String> filterRam = new ArrayList<>();
        if (ram != null) {
            List<String> a = dienThoaiRepository.filterRAM(ram);
            filterRam.addAll(a);
        }
        ArrayList<String> idFilter = new ArrayList<>();
        if (hang != null) {
            idFilter.addAll(filterHang);
        } else if (giaMin < giaMax) {
            idFilter.addAll(filterPrice);
        } else if (heDieuHanh != null) {
            idFilter.addAll(filterHDH);
        } else if (kichthuoc != null) {
            idFilter.addAll(filterKT);
        } else if (manhinh != null) {
            idFilter.addAll(filterDPG);
        } else if (ram != null) {
            idFilter.addAll(filterRam);
        } else if (bonho != null) {
            idFilter.addAll(filterRom);
        } else if (pin != null) {
            idFilter.addAll(pinFilter);
        } else if (tinhnang != null) {
            idFilter.addAll(filterCamera);
        }

        if (hang != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterHang.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (giaMin < giaMax) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterPrice.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (heDieuHanh != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterHDH.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (kichthuoc != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterKT.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (manhinh != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterDPG.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (ram != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterRam.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (bonho != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterRom.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (pin != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!pinFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (tinhnang != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!filterCamera.contains(itr.next())) {
                    itr.remove();
                }
            }
        }

        Page<DienThoai> dienThoais = dienThoaiService.filterDt(idFilter, page, 20,sort);
        List<DienThoaiDto> dienThoaiDtos = new ArrayList<>();
        dienThoais.getContent().forEach((d) -> {
            DienThoaiDto dt = d.convertToDtDTOClient();
            dienThoaiDtos.add(dt);
        });
        HashSet<String> manHinhHS = new HashSet<>();
        List<String> groupByDPG = dienThoaiService.groupByDPG();
        groupByDPG.forEach((a) -> {
            Queue<Integer> q = new PriorityQueue<>();
            q.add(-1);
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '(' || a.charAt(i) == ')') q.add(i);
            }
            String mh = "";
            if (q.size() == 1) mh = null;
            while (q.size() > 1) {
                int start = q.peek() + 1;
                q.poll();
                mh += a.substring(start, q.peek());
                q.poll();
            }
            if (mh != null) {
                mh = mh.trim().replaceAll("\\s+", " ");
                manHinhHS.add(mh);
            }
        });
        ArrayList<String> dsManhinh = new ArrayList<>();
        dsManhinh.addAll(manHinhHS);
        List<String> hangFilter = dienThoaiService.findAllHang();
        List<String> bonhos = dienThoaiService.groupByDTBN();
        bonhos.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        List<String> rams = dienThoaiService.groupByRAM();
        rams.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> tinhnangcams = dienThoaiService.groupByTinhNangCam();
        List<String> tinhnangs = new ArrayList<>();
        tinhnangcams.forEach((t) -> {
            t = t.trim().replaceAll("\\s+", " ");
            String[] tn = t.split(",");
            tinhnangs.addAll(Arrays.asList(tn));
        });
        System.err.println(tinhnangs + "tinhnagssss");
        tinhnangs.forEach((tns) -> {
            if (map.containsKey(tns)) {
                map.replace(tns.trim(), map.get(tns) + 1);
            } else map.put(tns.trim(), 1);
        });
        ArrayList<String> tn = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
        tn.subList(6, tn.size()).clear();
        if (sort !=null){
            switch (sort) {
                case "sortNameASC":
                    model.addAttribute("sort", "Tên a -> z");
                    break;
                case "sortNameDESC":
                    model.addAttribute("sort", "Tên z -> a");
                    break;
                case "sortPriceASC":
                    model.addAttribute("sort", "Giá tăng dần");
                    break;
                default:
                    model.addAttribute("sort", "Giá giảm dần");
                    break;
            }
        }
        else model.addAttribute("sort", sort);

        //form filter
        model.addAttribute("manhinhFts", manhinh);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String email = user.getUsername();
            NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
            if (nguoiDung.getName() != null) {
                Integer quantityCart = gioHangSanPhamRepository.countProduct(nguoiDung.getId());
                model.addAttribute("quantityCart",quantityCart);
            }
        }
        model.addAttribute("ramFts", ram);
        model.addAttribute("bonhoFts", bonho);
        model.addAttribute("hangFts", hang);
        model.addAttribute("minPriceFts", giaMin);
        model.addAttribute("maxPriceFts", giaMax);
        model.addAttribute("hedieuhanhFts", heDieuHanh);
        model.addAttribute("dophangiaiFts", manhinh);
        model.addAttribute("kichthuocFts",kichthuoc);
        model.addAttribute("pinFts",pin);
        model.addAttribute("tinhnangFts", tinhnang);
        System.out.println(tn);
        System.err.println("hangFts: "+hang);
        System.err.println("hashSet: " + dsManhinh);
        System.err.println("Tong page: "+dienThoais.getTotalPages());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dienThoais.getTotalPages());
        model.addAttribute("totalItems", dienThoais.getTotalElements());
        model.addAttribute("manhinhs", manHinhHS);
        model.addAttribute("rams", rams);
        model.addAttribute("bonhos", bonhos);
        model.addAttribute("hangs", hangFilter);
        model.addAttribute("dienthoais", dienThoaiDtos);
        model.addAttribute("tinhnangs", tn);
        return "product-list-dt";
    }
}