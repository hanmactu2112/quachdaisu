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
import org.springframework.web.bind.annotation.RequestParam;
import ptit.suwoo.Dto.laptopDto.LaptopDTO;
import ptit.suwoo.Dto.laptopDto.SanPhamJPQL;
import ptit.suwoo.Repository.GioHangSanPhamRepository;
import ptit.suwoo.Repository.NguoiDungRepository;
import ptit.suwoo.SanPhamService.DienThoaiService;
import ptit.suwoo.SanPhamService.LaptopService;
import ptit.suwoo.SanPhamService.SanPhamService;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.DienThoai;
import ptit.suwoo.model.NguoiDung;
import ptit.suwoo.model.SanPham;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamRepository.DienThoaiRepository;
import ptit.suwoo.sanphamRepository.LaptopRepository;
import ptit.suwoo.sanphamRepository.SanphamRepository2;
import ptit.suwoo.sanphamdto.DienThoaiDto;
import ptit.suwoo.sanphamdto.SanPhamDto;
import ptit.suwoo.service.CategoryService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DienThoaiService dienThoaiService;
    @Autowired
    DienThoaiRepository dienThoaiRepository;
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    LaptopService laptopService;
    @Autowired
    SanphamRepository2 sanphamRepository2;
    @Autowired
    GioHangSanPhamRepository gioHangSanPhamRepository;
    @Autowired
    NguoiDungRepository nguoiDungRepository;
    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }
    @GetMapping({"/home","/"})
    public String index(Model model){
        List<SanPhamDto> listFS = new ArrayList<>();
        List<DienThoai> listSpFs = sanPhamService.searhFlashSale();
        for(DienThoai a:listSpFs){
            SanPhamDto s = a.convertToDTOClient();
            listFS.add(s);
        }
        List<DienThoai> dienThoais = dienThoaiService.findLimit20();
        List<DienThoaiDto> dienThoaiDtos = new ArrayList<>();
        for (DienThoai i : dienThoais){
            DienThoaiDto d = i.convertToDtDTOClient();
            dienThoaiDtos.add(d);
        }
        List<Laptop> laptops = laptopService.findLimit20();
        List<LaptopDTO> laptopDTOS = new ArrayList<>();
        for (Laptop l : laptops){
            LaptopDTO a = l.convertToLtDTOClient();
            laptopDTOS.add(a);
        }
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
        model.addAttribute("dienthoais",dienThoaiDtos);
        model.addAttribute("laptops",laptopDTOS);

        model.addAttribute("flashsales",listFS);
        return "index";
    }
    @GetMapping("/detailsProducts/{id}")
    public String detailsProducts(@PathVariable("id") Long id,Model model){
        if (dienThoaiRepository.findById(id).isPresent()) return "redirect:/productDetailsClient/"+id;
        else if (laptopRepository.findById(id).isPresent()) {
            return "redirect:/productLtDetailsClient/"+id;
        }
        else return "redirect:/home";
    }
    @GetMapping("/searchProducts")
    public String searchProducts(@RequestParam("valueSearch")String searchText,@RequestParam("category") String categoryId,Model model){
        return searchProductsFilter(1,searchText,categoryId,null,null,null,null,model);
    }
    @GetMapping("/searchProducts/{page}")
    public String searchProductsFilter(@PathVariable(name = "page",required = false) Integer page,
                                       @RequestParam("valueSearch")String searchText,
                                       @RequestParam("category") String categoryId,
                                       @RequestParam(name = "hang", required = false) List<String> hang,
                                       @RequestParam(name = "giamin", required = false) Integer giaMin,
                                       @RequestParam(name = "giamax", required = false) Integer giaMax,
                                       @RequestParam(name = "sorting", required = false) String sort,
                                       Model model){
        if (page==null) page=1;
        if (giaMin == null) giaMin = 0;
        if (giaMax == null) giaMax = 0;
        final Integer giabd = giaMin;
        final Integer giakt = giaMax;
        List<SanPhamDto> sanPhamDtos;
        if (searchText.equals("")||searchText.trim().replaceAll("\\s+"," ").equals(" ")){
            List<DienThoai> dienThoais = dienThoaiService.findAll();;
            List<Laptop> laptops = laptopService.findAllLT();
            if (!categoryId.equals("1")){
                dienThoais.removeIf((e)->e.getCategory().getId()!=Long.parseLong(categoryId));
                laptops.removeIf((e)->e.getCategory().getId()!=Long.parseLong(categoryId));
            }
            if (giabd<giakt){
                dienThoais.removeIf((e)->!(e.getGia()>=giabd && e.getGia()<=giakt));
                laptops.removeIf((e)->!(e.getGia()>=giabd && e.getGia()<=giakt));
            }
            sanPhamDtos = new ArrayList<>();
            sanPhamDtos.addAll(dienThoais.stream().map(DienThoai::convertToDtDTOClient).collect(Collectors.toCollection(ArrayList::new)));
            sanPhamDtos.addAll(laptops.stream().map(Laptop::convertToLtDTOClient).collect(Collectors.toCollection(ArrayList::new)));

        }
        else {
            List<DienThoai> dienThoais = dienThoaiService.findAll();;
            List<Laptop> laptops = laptopService.findAllLT();

            if (!categoryId.equals("1")){
                dienThoais.removeIf((e)->e.getCategory().getId()!=Long.parseLong(categoryId));
                laptops.removeIf((e)->e.getCategory().getId()!=Long.parseLong(categoryId));
            }
            if (giabd<giakt){
                dienThoais.removeIf((e)->!(e.getGia()>=giabd && e.getGia()<=giakt));
                laptops.removeIf((e)->!(e.getGia()>=giabd && e.getGia()<=giakt));
            }
            // Start khu vuc
            String[] temps = searchText.trim().split(" ");
            System.err.println("Length: "+temps.length);
            ArrayList<String> tempsArr = new ArrayList<>();
            int a[] = new int[temps.length+1];
            for (int i = 0; i < temps.length; i++) {
                a[i]=0;
            }
            ArrayList<ArrayList<Integer>> ds = new ArrayList<>();
            Try(0,temps.length,a,ds);
            for(int j = 0;j<ds.size();j++){
                System.err.println("xau nhi phan:" + ds.get(j));
                StringBuilder ll = new StringBuilder();
                System.err.print("Xau chu nhi phan: ");
                for (int i = 0; i < temps.length; i++) {
                    System.err.print(temps[i]);
                    if (ds.get(j).get(i)==0) ll.append(temps[i]).append(" ");
                }
                System.err.println();
                System.out.println("xau sau: "+ll);
                if (!ll.toString().equals(""))tempsArr.add(ll.toString().trim().replaceAll("\\s+"," ").trim());
            }
            List<List<String>> dTdocs = new ArrayList<>();
            dienThoais.forEach((e)->{
                List<String> doc = new ArrayList<>();
                doc.add(e.getTenSp());
                doc.add(e.getMasp());
                doc.add(e.getHang());
                doc.add(e.getColor());
                doc.add(e.getCategory().getTen());
                doc.add(e.getCategory().getLoai());
                doc.add(e.getChatLieu());
                doc.add(e.getDtHeDieuHanhCPU().getHeDieuHanh());
                doc.add(e.getDtHeDieuHanhCPU().getCpu());
                doc.add(e.getDtHeDieuHanhCPU().getTocDoCpu());
                doc.add(e.getDtHeDieuHanhCPU().getGpu());
                doc.add(e.getDtKetNoi().getMangDiDong());
                doc.add(e.getDtKetNoi().getWifi());
                doc.add(e.getDtKetNoi().getGps());
                doc.add(e.getDtKetNoi().getBluetooth());
                doc.add(e.getDtKetNoi().getCongSac());
                doc.add(e.getDtKetNoi().getTaiNghe());
                doc.add(e.getManHinh().getDoPhanGiai());
                doc.add(e.getManHinh().getKichThuoc());
                doc.add(e.getManHinh().getTanSoQuet());
                doc.add(e.getManHinh().getCongNgheManHinh());
                doc.add(e.getDtBoNho().getRam());
                doc.add(e.getDtBoNho().getRom());
                e.getCameras().forEach((c)->{
                    doc.add(c.getDoPhanGiaiCamera());
                    doc.add(c.getTinhNang());
                });
                doc.add(e.getPin().getDungLuong());
                doc.add(e.getTienIch().getBaoMat());
                doc.add(e.getTienIch().getTinhNangDacBiet());
                doc.add(e.getMasp());
                dTdocs.add(doc);
            });
            List<List<String>> lTdocs = new ArrayList<>();
            laptops.forEach((e)->{
                List<String> doc = new ArrayList<>();
                doc.add(e.getTenSp());
                doc.add(e.getMasp());
                doc.add(e.getHang());
                doc.add(e.getColor());
                doc.add(e.getCategory().getTen());
                doc.add(e.getCategory().getLoai());
                doc.add(e.getChatLieu());
                doc.add(e.getPin().getLoaiPin());
                doc.add(e.getPin().getDungLuong());
                doc.add(e.getTienIch().getBaoMat());
                doc.add(e.getTienIch().getTinhNangDacBiet());
                doc.add(e.getLtRamOCung().getLoaiRam());
                doc.add(e.getLtRamOCung().getDungLuongRam());
                doc.add(e.getLtRamOCung().getTocDoBus());
                doc.add(e.getLtRamOCung().getOCung());
                doc.add(e.getLtDoHoaVaAmThanh().getCardDoHoa());
                doc.add(e.getLtDoHoaVaAmThanh().getCardAmThanh());
                doc.add(e.getManHinhLT().getKichThuoc());
                doc.add(e.getManHinhLT().getTanSoQuet());
                doc.add(e.getManHinhLT().getDoPhanGiai());
                doc.add(e.getManHinhLT().getCongNgheManHinh());
                lTdocs.add(doc);
            });
            Map<Integer,Double> dtTfpoint = new LinkedHashMap<>();
            for (int i = 0; i < dTdocs.size(); i++) {
                int index = i;
                double point = 0;
                for (int j = 0; j < tempsArr.size(); j++) {
                    point += tf(dTdocs.get(index),tempsArr.get(j));
                }
                dtTfpoint.put(i,point);
            }
            double poitIdfDt = 0;
            for (int i = 0; i < tempsArr.size(); i++) {
                poitIdfDt+= idf(dTdocs,tempsArr.get(i));
            }
            if (poitIdfDt==0) poitIdfDt = 0.001;
            for (int i = 0; i < dienThoais.size(); i++) {
                if (dtTfpoint.containsKey(i)) {
                    dtTfpoint.replace(i,(Double) dtTfpoint.get(i) * (poitIdfDt));
                } else dtTfpoint.put(i, 0.0);
            }
            ArrayList<Integer> tn = dtTfpoint.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue()).filter(e -> e.getValue()!=0.0)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toCollection(ArrayList::new));

            Map<Integer,Double> ltTfpoint = new LinkedHashMap<>();
            for (int i = 0; i < lTdocs.size(); i++) {
                int index = i;
                double point = 0;
                for (int j = 0; j < tempsArr.size(); j++) {
                    point += tf(lTdocs.get(index),tempsArr.get(j));
                }
                ltTfpoint.put(i,point);
            }
            double poitIdfLt = 0;
            for (int i = 0; i < tempsArr.size(); i++) {
                poitIdfLt+= idf(lTdocs,tempsArr.get(i));
            }
            if (poitIdfLt==0) poitIdfLt = 0.001;
            for (int i = 0; i < laptops.size(); i++) {
                if (ltTfpoint.containsKey(i)) {
                    ltTfpoint.replace(i,(Double) ltTfpoint.get(i) * (poitIdfLt));
                } else ltTfpoint.put(i, 0.0);
            }
            ArrayList<Integer> tn2 = ltTfpoint.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue()).filter(e -> e.getValue()!=0.0)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toCollection(ArrayList::new));

            Map<SanPhamDto,Double> map = new LinkedHashMap<>();
            for (int i = 0; i < tn.size(); i++) {
                map.put(dienThoais.get(tn.get(i)).convertToDtDTOClientDetails(),dtTfpoint.get(tn.get(i)));
            }
            for (int i = 0; i < tn2.size(); i++) {
                map.put(laptops.get(tn2.get(i)).convertToLtDTOClient(),ltTfpoint.get(tn2.get(i)));
            }
            sanPhamDtos = map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        Set<String> hangs = sanPhamDtos.stream().map(SanPhamDto::getHang).collect(Collectors.toCollection(TreeSet::new));
        if (hang!=null){
            Iterator<SanPhamDto> itr = sanPhamDtos.iterator();
            while (itr.hasNext()){
                boolean check = false;
                SanPhamDto spa = itr.next();
                for (String s:hang){
                    if (s.equals(spa.getHang())){
                        check = true;
                        break;
                    }
                }
                if (!check) itr.remove();
            }
        }

        if (sort !=null){
            if (sort.equals("sortNameASC")) {
                sanPhamDtos.sort((Comparator.comparing(SanPhamDto::getTen)));
            }
            else if(sort.equals("sortNameDESC")){
                sanPhamDtos.sort(((o1, o2) -> {
                    return o2.getTen().compareTo(o1.getTen());
                }));
            }
            else if(sort.equals("sortPriceASC")){
                sanPhamDtos.sort(((o1, o2) -> {
                    String gia1 = o1.getGia();
                    String gia2 = o2.getGia();
                    gia1 = gia1.replaceAll("\\D","");
                    gia2 = gia2.replaceAll("\\D","");
                    int giaInt1 = Integer.parseInt(gia1);
                    int giaInt2 = Integer.parseInt(gia2);
                    return giaInt1-giaInt2;
                }));
            }
            else {
                sanPhamDtos.sort(((o1, o2) -> {
                    String gia1 = o1.getGia();
                    String gia2 = o2.getGia();
                    gia1 = gia1.replaceAll("\\D","");
                    gia2 = gia2.replaceAll("\\D","");
                    int giaInt1 = Integer.parseInt(gia1);
                    int giaInt2 = Integer.parseInt(gia2);
                    return giaInt2-giaInt1;
                }));
            }
        }
        //End khu vuc
        int totalPages = sanPhamDtos.size()/20;
        if (sanPhamDtos.size()-20*totalPages>0){
            totalPages+=1;
        }
        ArrayList<SanPhamDto> sanPhamDtosPage = new ArrayList<>();
        if ((page-1)*20<=sanPhamDtos.size()){
            if (page*20<=sanPhamDtos.size()){

                sanPhamDtosPage.addAll(sanPhamDtos.subList((page-1)*20,20*page));
            }
            else {
                sanPhamDtosPage.addAll(sanPhamDtos.subList((page-1)*20,sanPhamDtos.size()));
            }
        }

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
        model.addAttribute("minPriceFts", giaMin);
        model.addAttribute("maxPriceFts", giaMax);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("dienthoais", sanPhamDtosPage);
        model.addAttribute("hangs", hangs);
        model.addAttribute("totalItems", sanPhamDtos.size());
        model.addAttribute("hangFts", hang);
        model.addAttribute("valueSearch",searchText);
        model.addAttribute("category", categoryId);
        return "list-products-search";

    }

    // full //hd //full hd
    // full
    // full hd
    // amodled ddsh full hd+ hhddd gggggg ddddddddd
    //
    //method
    public static double tf(List<String> doc, String term) {
        double result = 0;
        double tile = 0;
        for (String word : doc) {
            if (word.toLowerCase().contains(term.toLowerCase())){
                if (word.length()>0)tile = Math.max(tile,term.length()/word.length());
                result++;
            }
        }
        if (result==0) return 0;
        else return ((result / doc.size())+tile);
    }
    public static double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (word.toLowerCase().contains(term.toLowerCase())) {
                    n++;
                    break;
                }
            }
        }
        if (n==0) return 0;
        else return Math.log(docs.size()/n);
    }
    public static void Try(int i,int n,int[] a,ArrayList<ArrayList<Integer>> ds){
        for(int j=0;j<=1;j++){
            a[i] = j;
            if(i==n-1) {
                add(n,a,ds);
            }
            else Try(i+1,n,a,ds);
        }
    }
    public static void add(int n,int[] a,ArrayList<ArrayList<Integer>> ds){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(a[i]);
        }
        ds.add(arr);
    }
}
