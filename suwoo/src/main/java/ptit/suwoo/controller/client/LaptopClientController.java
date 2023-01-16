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
import ptit.suwoo.Dto.laptopDto.LaptopDTO;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.SanPhamService.LaptopService;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamRepository.LaptopRepository;
import ptit.suwoo.sanphamdto.CameraDto;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.sanphamdto.DienThoaiDto;
import ptit.suwoo.sanphamdto.SanPhamDto;
import ptit.suwoo.service.CategoryService;

import java.util.*;


@Controller
public class LaptopClientController {

    @Autowired
    LaptopService laptopService;
    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    CategoryService categoryService;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    NguoiDungRepository nguoiDungRepository;

    @GetMapping("/viewListProductLt")
    public String findAllDtClient(@RequestParam(name = "sorting", required = false) String sort, Model model) {
        return pageProductLt(1, sort, model);
    }

    @GetMapping("/viewListProductLt/{page}")
    public String pageProductLt(@PathVariable Integer page, @RequestParam(name = "sorting", required = false) String sort, Model model) {
        Page<Laptop> laptops = laptopService.findAllLaptop(page, 20, sort);
        laptops.getTotalPages();
        System.err.println("Page: " + page);
        List<LaptopDTO> laptopDTOS = new ArrayList<>();
        laptops.getContent().forEach((d) -> {
            LaptopDTO lt = d.convertToLtDTOClient();
            laptopDTOS.add(lt);
        });
        List<String> hangSX = laptopRepository.findAllHangLt();
        List<String> cpu = laptopRepository.findAllTenCPULt();
        TreeSet<String> hs = new TreeSet<>();
        if (cpu != null) {
            cpu.forEach((e) -> {
                int indx = -1;
                for (int i = 0; i < e.length(); i++) {
                    if (e.charAt(i) == '-' || e.charAt(i) == '(') {
                        indx = i;
                        break;
                    }
                }
                if (indx > 0) hs.add(e.substring(0, indx));
                else hs.add(e);
            });
        }
        if (cpu != null) cpu.clear();
        cpu = new ArrayList<>(hs);

        List<String> rams = laptopRepository.findAllRamLt();
        rams.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        List<String> roms = laptopRepository.findAllRomLt();

        List<String> kichThuocMH = laptopRepository.findAllKichThuoc();
        List<String> dophangiai = laptopRepository.findAllDoPhanGiai();
        List<String> tansoquet = laptopRepository.findAllTanSoQuet();
        tansoquet.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        if (sort != null) {
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
        } else model.addAttribute("sort", sort);
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
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", laptops.getTotalPages());
        model.addAttribute("totalItems", laptops.getTotalElements());
        model.addAttribute("hangs", hangSX);
        model.addAttribute("cpus", cpu);
        model.addAttribute("rams", rams);
        model.addAttribute("roms", roms);
        model.addAttribute("laptops", laptopDTOS);
        model.addAttribute("kichthuocs", kichThuocMH);
        model.addAttribute("dophangiais", dophangiai);
        model.addAttribute("tansoquets", tansoquet);
        return "product-list-lt";
    }

    @GetMapping("/viewListProductLtWithFilter")
    public String findAllDtWithFilterClient(@RequestParam(name = "hang", required = false) List<String> hang,
                                            @RequestParam(name = "cpu", required = false) List<String> cpu,
                                            @RequestParam(name = "kichthuoc", required = false) List<String> kichthuoc,
                                            @RequestParam(name = "dophangiai", required = false) List<String> dophangiai,
                                            @RequestParam(name = "rom", required = false) List<String> bonho,
                                            @RequestParam(name = "ram", required = false) List<String> ram,
                                            @RequestParam(name = "vga", required = false) List<String> vga,
                                            @RequestParam(name = "tansoquet", required = false) List<String> tansoquet,
                                            @RequestParam(name = "giamin", required = false) Integer giaMin,
                                            @RequestParam(name = "giamax", required = false) Integer giaMax,
                                            @RequestParam(name = "sorting", required = false) String sort,
                                            Model model) {

        return pagefindAllLtWithFilterClient(hang, cpu, kichthuoc, dophangiai, bonho, ram, vga, tansoquet, giaMin, giaMax, sort, 1, model);
    }

    @GetMapping("/viewListProductLtWithFilter/{page}")
    public String pagefindAllLtWithFilterClient(@RequestParam(name = "hang", required = false) List<String> hang,
                                                @RequestParam(name = "cpu", required = false) List<String> cpu,
                                                @RequestParam(name = "kichthuoc", required = false) List<String> kichthuoc,
                                                @RequestParam(name = "dophangiai", required = false) List<String> dophangiai,
                                                @RequestParam(name = "rom", required = false) List<String> bonho,
                                                @RequestParam(name = "ram", required = false) List<String> ram,
                                                @RequestParam(name = "vga", required = false) List<String> vga,
                                                @RequestParam(name = "tansoquet", required = false) List<String> tansoquet,
                                                @RequestParam(name = "giamin", required = false) Integer giaMin,
                                                @RequestParam(name = "giamax", required = false) Integer giaMax,
                                                @RequestParam(name = "sorting", required = false) String sort,
                                                @PathVariable(name = "page", required = false) int page,
                                                Model model) {
        if (giaMin == null) giaMin = 0;
        if (giaMax == null) giaMax = 0;
        if (hang == null && cpu == null && kichthuoc == null && dophangiai == null
                && bonho == null && ram == null && vga == null && tansoquet == null && (giaMin == 0 && giaMax == 0)) {
            return pageProductLt(1, sort, model);
        }

        List<String> hangFilter = new ArrayList<>();
        if (hang != null) {
            hangFilter.addAll(laptopRepository.findFilterHang(hang));
        }
        List<String> cpuFilter = new ArrayList<>();
        if (cpu != null) {
            for (int i = 0; i < cpu.size(); i++) {
                cpuFilter.addAll(laptopRepository.findFilterCPU(cpu.get(i)));
            }
        }
        List<String> kichThuocFilter = new ArrayList<>();
        if (kichthuoc != null) {
            kichThuocFilter.addAll(laptopRepository.findFilterKT(kichthuoc));
        }
        List<String> doPGFilter = new ArrayList<>();
        if (dophangiai != null) {
            doPGFilter.addAll(laptopRepository.findFilterDPG(dophangiai));
        }
        List<String> boNhoFilter = new ArrayList<>();
        if (bonho != null) {
            boNhoFilter.addAll(laptopRepository.findFilterBN(bonho));
        }
        List<String> ramFilter = new ArrayList<>();
        if (ram != null) {
            ramFilter.addAll(laptopRepository.findFilterRam(ram));
        }
        List<String> vgaFilter = new ArrayList<>();
        if (vga != null) {
            vgaFilter.addAll(laptopService.findLTByCard(vga));
        }
        List<String> tansoFilter = new ArrayList<>();
        if (tansoquet != null) {
            tansoFilter.addAll(laptopRepository.findFilterTanSoQuet(tansoquet));
        }
        List<String> filterPrice = new ArrayList<>();
        if ((giaMin < giaMax)) {
            filterPrice.addAll(laptopRepository.findFilterGia(giaMin, giaMax));
        }
        ArrayList<String> idFilter = new ArrayList<>();
        if (hang != null) {
            idFilter.addAll(hangFilter);
        } else if (giaMin < giaMax) {
            idFilter.addAll(filterPrice);
        } else if (cpu != null) {
            idFilter.addAll(cpuFilter);
        } else if (kichthuoc != null) {
            idFilter.addAll(kichThuocFilter);
        } else if (dophangiai != null) {
            idFilter.addAll(doPGFilter);
        } else if (ram != null) {
            idFilter.addAll(ramFilter);
        } else if (bonho != null) {
            idFilter.addAll(boNhoFilter);
        } else if (vga != null) {
            idFilter.addAll(vgaFilter);
        } else if (tansoquet != null) {
            idFilter.addAll(tansoFilter);
        }

        if (hang != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!hangFilter.contains(itr.next())) {
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
        if (cpu != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!cpuFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (kichthuoc != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!kichThuocFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (dophangiai != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!doPGFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (ram != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!ramFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (bonho != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!boNhoFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (vga != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!vgaFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }
        if (tansoquet != null) {
            Iterator<String> itr = idFilter.iterator();
            while (itr.hasNext()) {
                if (!tansoFilter.contains(itr.next())) {
                    itr.remove();
                }
            }
        }

        Page<Laptop> laptops = laptopService.findFilterLT(idFilter, page, 20, sort);
        List<LaptopDTO> laptopDTOS = new ArrayList<>();
        laptops.getContent().forEach((d) -> {
            LaptopDTO dt = d.convertToLtDTOClient();
            laptopDTOS.add(dt);
        });
        List<String> hangSXFTs = laptopRepository.findAllHangLt();
        List<String> cpuFTs = laptopRepository.findAllTenCPULt();
        TreeSet<String> hs = new TreeSet<>();
        if (cpuFTs != null) {
            cpuFTs.forEach((e) -> {
                int indx = -1;
                for (int i = 0; i < e.length(); i++) {
                    if (e.charAt(i) == '-' || e.charAt(i) == '(') {
                        indx = i;
                        break;
                    }
                }
                if (indx > 0) hs.add(e.substring(0, indx));
                else hs.add(e);
            });
        }
        if (cpuFTs != null) cpuFTs.clear();
        cpuFTs = new ArrayList<>(hs);

        List<String> ramFTs = laptopRepository.findAllRamLt();
        ramFTs.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        List<String> romFTs = laptopRepository.findAllRomLt();

        List<String> kichThuocFTs = laptopRepository.findAllKichThuoc();
        List<String> dophangiaiFTs = laptopRepository.findAllDoPhanGiai();
        List<String> tansoquetFTs = laptopRepository.findAllTanSoQuet();
        tansoquetFTs.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.replaceAll("\\D+", ""));
            int t2 = Integer.parseInt(o2.replaceAll("\\D+", ""));
            if (t1 < t2) return -1;
            else return 1;
        });
        if (sort != null) {
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
        } else model.addAttribute("sort", sort);

        System.err.println("hangSXFTs: "+hangSXFTs);
        //form filter
        model.addAttribute("hangs", hangSXFTs);
        model.addAttribute("cpus", cpuFTs);
        model.addAttribute("rams", ramFTs);
        model.addAttribute("roms", romFTs);
        model.addAttribute("kichthuocs", kichThuocFTs);
        model.addAttribute("dophangiais", dophangiaiFTs);
        model.addAttribute("tansoquets", tansoquetFTs);
        // new filter

        //old filter
        model.addAttribute("hangFts", hang);
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
        model.addAttribute("kichthuocFts", kichthuoc);
        model.addAttribute("cpuFts", cpu);
        model.addAttribute("dophangiaiFts", dophangiai);
        model.addAttribute("bonhoFts", bonho);
        model.addAttribute("ramFts", ram);
        model.addAttribute("tansoquetFts", tansoquet);
        model.addAttribute("vgaFts", vga);
        model.addAttribute("giaMinFts", giaMin);
        model.addAttribute("giaMaxFts", giaMax);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", laptops.getTotalPages());
        model.addAttribute("totalItems", laptops.getTotalElements());
        model.addAttribute("laptops", laptopDTOS);
        return "product-list-lt";
    }

    @GetMapping("/productLtDetailsClient/{id}")
    public String getDetailsLt(@PathVariable Long id, Model model) {
        Optional<Laptop> laptop = laptopService.findLtAndKmById(id);
        if (laptop.isPresent()) {
            LaptopDTO laptopDTO = laptop.get().convertToLtDTOClient();
            System.out.println("laptopDTO: "+ laptopDTO.getLtRamOCungDto().getDungLuongRam());
            model.addAttribute("laptop", laptopDTO);
            Category category = categoryService.findCategoryByLt(id);
            CategoryDto categoryDto = category.convertToDto();
            List<Laptop> listlt = laptopRepository.findAllLtByIdCategory(categoryDto.getId());
            List<SanPhamDto> sanPhamDtos = new ArrayList<>();
            listlt.forEach((d) -> {
                SanPhamDto s = d.convertToLtDTOClient();
                sanPhamDtos.add(s);
            });
            if (sanPhamDtos.size() < 15) {
                List<Laptop> listGoiY = laptopService.findLimit20();
                for (Laptop a : listGoiY) {
                    SanPhamDto s = a.convertToLtDTOClient();
                    if (!sanPhamDtos.contains(s)&& sanPhamDtos.size()<=15){
                        sanPhamDtos.add(s);
                    }
                }
            }
            System.err.println("flashsales " + sanPhamDtos.size());
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
            model.addAttribute("flashsales", sanPhamDtos);
            model.addAttribute("category", categoryDto);
            model.addAttribute("loai", "Laptop");
            return "product-lt-details";
        } else return "redirect:/home";
    }
}
