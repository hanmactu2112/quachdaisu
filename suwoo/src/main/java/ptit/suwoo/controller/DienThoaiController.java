package ptit.suwoo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Repository.KhuyenMaiRepository;
import ptit.suwoo.SanPhamService.DienThoaiService;
import ptit.suwoo.SanPhamService.ImageService;
import ptit.suwoo.SanPhamService.KhuyenMaiService;
import ptit.suwoo.model.*;
import ptit.suwoo.sanphamRepository.SanPhamRepository;
import ptit.suwoo.sanphamdto.*;
import ptit.suwoo.service.CategoryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class DienThoaiController {
    private static final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/dtImages";
    private static final String imgDir = "/dtImages/";
    private static final String deleteDir = System.getProperty("user.dir") + "/src/main/resources/static";
    @Autowired
    DienThoaiService dienThoaiService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ImageService imageService;


    @GetMapping("/admin/addProductDT")
    public String addProDuctDT(Model model){
        DienThoaiDto dienThoaiDto = new DienThoaiDto();
        List<CameraDto> ds = new ArrayList<>();
        CameraDto c1 = new CameraDto();
        c1.setLoai("Camera trước");
        CameraDto c2 = new CameraDto();
        c2.setLoai("Camera sau");
        ds.add(c1);
        ds.add(c2);
        dienThoaiDto.setCameraDtoList(ds);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (Category category : list) {
            if (category.getLoai().equals("dienthoai")){
                CategoryDto cto = new CategoryDto();
                cto.setId(category.getId());
                cto.setTen(category.getTen());
                cto.setMoTa(category.getMoTa());
                categoryDtos.add(cto);
            }
        }

        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("tittle","Thêm sản phẩm");
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("dienthoai",dienThoaiDto);
        return "addProductDT";

    }
    @PostMapping("/admin/addProductDT")
    public String addProductDT(@ModelAttribute("dienthoai") DienThoaiDto dienThoai,
                               @RequestParam("listimages") List<MultipartFile> images,
                               @RequestParam("category") String category) throws IOException {

        DienThoai dt = new DienThoai();
        if(dienThoai.getId()!=null) {
            dt.setId(dienThoai.getId());
            Optional<DienThoai> dt2 = dienThoaiService.findDtById(dienThoai.getId());
            if (dt2.isPresent()){
                KhuyenMai km = dt2.get().getKhuyenMai();
                dt.setKhuyenMai(km);
            }
        }
        dt.setMasp(dienThoai.getMaSp());
        dt.setTenSp(dienThoai.getTen());
        dt.setGia(Double.parseDouble(dienThoai.getGia()));
        dt.setSoLuong(dienThoai.getSoLuong());
        dt.setColor(dienThoai.getColor());
        dt.setHang(dienThoai.getHang());
        dt.setNgayRaMat(dienThoai.getNgayRaMat());
        dt.setNgayDangSP(Date.valueOf(LocalDate.now()));
        dt.setChatLieu(dienThoai.getChatLieu());
        dt.setThietKe(dienThoai.getThietKe());
        dt.setMoTa(dienThoai.getMoTa());
        System.err.println("mota:"+dienThoai.getMoTa());
        DTHeDieuHanhCPU dtHeDieuHanhCpu = new DTHeDieuHanhCPU();
        dtHeDieuHanhCpu.setCpu(dienThoai.getDtHeDieuHanhCpuDto().getCpu());
        dtHeDieuHanhCpu.setHeDieuHanh(dienThoai.getDtHeDieuHanhCpuDto().getHeDieuHanh());
        dtHeDieuHanhCpu.setTocDoCpu(dienThoai.getDtHeDieuHanhCpuDto().getTocDoCpu());
        dtHeDieuHanhCpu.setGpu(dienThoai.getDtHeDieuHanhCpuDto().getGpu());
        dt.setDtHeDieuHanhCPU(dtHeDieuHanhCpu);

        ManHinh manHinh = new ManHinh();
        manHinh.setCongNgheManHinh(dienThoai.getManHinhDto().getCongNgheManHinh());
        manHinh.setDoPhanGiai(dienThoai.getManHinhDto().getDoPhanGiai());
        manHinh.setDoSangToiDa(dienThoai.getManHinhDto().getDoSangToiDa());
        manHinh.setKichThuoc(dienThoai.getManHinhDto().getKichThuoc());
        manHinh.setMatKinhCamUng(dienThoai.getManHinhDto().getMatKinhCamUng());
        manHinh.setTanSoQuet(dienThoai.getManHinhDto().getTanSoQuet());
        dt.setManHinh(manHinh);

        DTBoNho dtBoNho = new DTBoNho();
        dtBoNho.setRam(dienThoai.getDtBoNhoDto().getRam());
        dtBoNho.setRom(dienThoai.getDtBoNhoDto().getRom());
        dt.setDtBoNho(dtBoNho);

        TienIch tienIch = new TienIch();
        tienIch.setBaoMat(dienThoai.getTienIchDto().getBaoMat());
        tienIch.setTinhNangDacBiet(dienThoai.getTienIchDto().getTinhNangDacBiet());
        dt.setTienIch(tienIch);

        Pin pin = new Pin();
        pin.setLoaiPin(dienThoai.getPinDto().getLoaiPin());
        pin.setCongNghe(dienThoai.getPinDto().getCongNghe());
        pin.setDungLuong(dienThoai.getPinDto().getDungLuong());
        dt.setPin(pin);

        DTKetNoi dtKetNoi = new DTKetNoi();
        dtKetNoi.setBluetooth(dienThoai.getDtKetNoiDto().getBluetooth());
        dtKetNoi.setMangDiDong(dienThoai.getDtKetNoiDto().getMangDiDong());
        dtKetNoi.setGps(dienThoai.getDtKetNoiDto().getGps());
        dtKetNoi.setWifi(dienThoai.getDtKetNoiDto().getWifi());
        dtKetNoi.setCongSac(dienThoai.getDtKetNoiDto().getCongSac());
        dtKetNoi.setTaiNghe(dienThoai.getDtKetNoiDto().getTaiNghe());
        dtKetNoi.setKetNoiKhac(dienThoai.getDtKetNoiDto().getKetNoiKhac());
        dt.setDtKetNoi(dtKetNoi);

        KichThuocTrongLuong kichThuocTrongLuong = new KichThuocTrongLuong();
        kichThuocTrongLuong.setDoDai(dienThoai.getKichThuocTrongLuongDto().getDoDai());
        kichThuocTrongLuong.setDoMong(dienThoai.getKichThuocTrongLuongDto().getDoMong());
        kichThuocTrongLuong.setDoRong(dienThoai.getKichThuocTrongLuongDto().getDoRong());
        kichThuocTrongLuong.setTrongLuong(dienThoai.getKichThuocTrongLuongDto().getTrongLuong());
        dt.setKichThuocTrongLuong(kichThuocTrongLuong);
        List<Image> imageList = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            String imageUUID;
            String nameFile=images.get(i).getOriginalFilename();
            if(!images.get(i).isEmpty()) {
                imageUUID = images.get(i).getOriginalFilename();
                System.err.println("imageUUID: "+ imageUUID);
                Random random=new Random();
                String ext="";
                for (int j = imageUUID.length()-1; j >=0 ; j--) {
                    if (imageUUID.charAt(j)=='.'){
                        ext = imageUUID.substring(j,imageUUID.length());
                    }
                }
                Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
                int t = 1;
                while (t==1){
                    nameFile = String.format("%s%s",System.currentTimeMillis(),random.nextInt(100000)+ext);
                    fileNameAndPath = Paths.get(uploadDir,nameFile);
                    boolean exists = Files.exists(fileNameAndPath);
                    if (!exists) t=0;
                }
                Image image = new Image();
                image.setUrlImg(nameFile);
                System.err.println("imageUUID: "+ nameFile);
                Files.write(fileNameAndPath, images.get(i).getBytes());
                imageList.add(image);
            }
        }
        ArrayList<Long> imgDelete = new ArrayList<>();
        if (dienThoai.getId()!=null){
            DienThoai dt1 = dienThoaiService.findDtById(dienThoai.getId()).get();
            List<Image> imgDb = dt1.getImages();
            //O(nlog(n))
            Collections.sort(imgDb, new Comparator<Image>() {
                @Override
                public int compare(Image o1, Image o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            List<ImageDto> imageDtoList1 = dienThoai.getImageDto();
            //O(m)
            imageDtoList1.removeIf(imageDto -> imageDto.getId() == null);
            //O(mlog(m))
            imageDtoList1.sort(new Comparator<ImageDto>() {
                @Override
                public int compare(ImageDto o1, ImageDto o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            if(imageDtoList1!=null){
                for (ImageDto i :imageDtoList1) {
                    System.out.println(i);
                    System.out.println("url old: "+i.getUrlImg());
                    System.out.println("id old: "+i.getId());
                }
            }
            //O(mlog(n))
            imgDelete = findNotExitImg(imageDtoList1,imgDb);
            //nlog(n)+m+mlog(m)+mlog(n) < m*n
            if (!imgDelete.isEmpty()){
                for (Long i : imgDelete) {
                    Optional<Image> img = imageService.findById(i);
                    if (img.isPresent()){
                        Path fileNameAndPathOld = Paths.get(uploadDir,img.get().getUrlImg());
                        String f = fileNameAndPathOld.toString();
                        File fl = new File(f);
                        if (!fl.isDirectory()){
                            try {
                                Files.deleteIfExists(fileNameAndPathOld);
                            } catch (IOException e) {
                                System.err.println("ERROR DELETE FILE IMG!!!");
                            }
                        }
                        System.err.println("xoas!!!!!!!!!!!!!!");
                        imageService.delete(img.get());
                    }

                }
                Iterator<Image> itrI = imgDb.listIterator();
                while(itrI.hasNext()){
                    if (imgDelete.contains(itrI.next().getId())){
                        itrI.remove();
                    }
                }
            }
            imageList.addAll(imgDb);
        }
        ArrayList<Camera> cameras = new ArrayList<>();
        List<CameraDto> cameraDtos = dienThoai.getCameraDtoList();
        for (CameraDto cameraDto : cameraDtos) {
            Camera c = new Camera();
            c.setLoai(cameraDto.getLoai());
            c.setDoPhanGiaiCamera(cameraDto.getDoPhanGiaiCamera());
            c.setTinhNang(cameraDto.getTinhNang());
            cameras.add(c);
        }
        dt.setActive(dienThoai.isActive());
        dt.setCameras(cameras);

        dt.setImages(imageList);
        System.err.println("Dien thoai id caeog: "+category);
        Category c = categoryService.findById(Long.parseLong(category)).get();
        dt.setCategory(c);
        try {
            dienThoaiService.save(dt);
        }
        catch (Exception e){
            return "addProductDT";
        }
        return "redirect:/admin/managerProductDT";
    }
    @GetMapping("/admin/managerProductDT")
    public String managerProductDT(Model model){
        List<DienThoai> listdt = dienThoaiService.findAll();
        List<DienThoaiDto> dtoList = new ArrayList<>();
        for (DienThoai dienThoai : listdt) {
            DienThoaiDto a = new DienThoaiDto();
            a.setId(dienThoai.getId());
            a.setMaSp(dienThoai.getMasp());
            a.setTen(dienThoai.getTenSp());
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str1 = currencyVN.format(dienThoai.getGia());
            a.setGia(str1);
            a.setColor(dienThoai.getColor());
            a.setSoLuong(dienThoai.getSoLuong());
            List<ImageDto> imglist = new ArrayList<>();
            if (dienThoai.getImages().size() > 0) {
                ImageDto imageDto = new ImageDto();
                imageDto.setId(dienThoai.getImages().get(0).getId());
                if(dienThoai.getImages().get(0).getUrlImg()!=null){
                    imageDto.setUrlImg(imgDir+dienThoai.getImages().get(0).getUrlImg());
                };
                imglist.add(imageDto);
            }
            a.setImageDto(imglist);
            dtoList.add(a);
        }

        model.addAttribute("dienthoais",dtoList);
        return "managerProductDT";
    }
    @GetMapping("/admin/deleteProductDT/{id}")
    public String deleteProductDT(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            dienThoaiService.deleteDTById(id);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute("error","Sản phẩm không còn tồn tại !!!");
        }
        redirectAttributes.addFlashAttribute("success","Xóa sản phẩm thành công !!!");
        return "redirect:/admin/managerProductDT";
    }
    @GetMapping("/admin/editProductDT/{id}")
    public String editProduct(@PathVariable Long id,Model model){
        DienThoai dienThoai = dienThoaiService.findDtById(id).get();
        DienThoaiDto dt = new DienThoaiDto();
        dt.setId(dienThoai.getId());
        dt.setMaSp(dienThoai.getMasp());
        dt.setTen(dienThoai.getTenSp());
        dt.setGia(String.format("%.0f",dienThoai.getGia()));
        dt.setSoLuong(dienThoai.getSoLuong());
        dt.setColor(dienThoai.getColor());
        dt.setHang(dienThoai.getHang());
        dt.setNgayRaMat(dienThoai.getNgayRaMat());
        dt.setChatLieu(dienThoai.getChatLieu());
        dt.setThietKe(dienThoai.getThietKe());
        dt.setMoTa(dienThoai.getMoTa());

        DTHeDieuHanhCpuDto dtHeDieuHanhCpu = new DTHeDieuHanhCpuDto();
        dtHeDieuHanhCpu.setCpu(dienThoai.getDtHeDieuHanhCPU().getCpu());
        dtHeDieuHanhCpu.setHeDieuHanh(dienThoai.getDtHeDieuHanhCPU().getHeDieuHanh());
        dtHeDieuHanhCpu.setTocDoCpu(dienThoai.getDtHeDieuHanhCPU().getTocDoCpu());
        dtHeDieuHanhCpu.setGpu(dienThoai.getDtHeDieuHanhCPU().getGpu());
        dt.setDtHeDieuHanhCpuDto(dtHeDieuHanhCpu);

        ManHinhDto manHinh = new ManHinhDto();
        manHinh.setCongNgheManHinh(dienThoai.getManHinh().getCongNgheManHinh());
        manHinh.setDoPhanGiai(dienThoai.getManHinh().getDoPhanGiai());
        manHinh.setDoSangToiDa(String.valueOf(dienThoai.getManHinh().getDoSangToiDa()));
        manHinh.setKichThuoc(String.valueOf(dienThoai.getManHinh().getKichThuoc()));
        manHinh.setMatKinhCamUng(dienThoai.getManHinh().getMatKinhCamUng());
        manHinh.setTanSoQuet(String.valueOf(dienThoai.getManHinh().getTanSoQuet()));
        dt.setManHinhDto(manHinh);

        DTBoNhoDto dtBoNho = new DTBoNhoDto();
        dtBoNho.setRam(String.valueOf(dienThoai.getDtBoNho().getRam()));
        dtBoNho.setRom(String.valueOf(dienThoai.getDtBoNho().getRom()));
        dt.setDtBoNhoDto(dtBoNho);

        TienIchDto tienIch = new TienIchDto();
        tienIch.setBaoMat(dienThoai.getTienIch().getBaoMat());
        tienIch.setTinhNangDacBiet(dienThoai.getTienIch().getTinhNangDacBiet());
        dt.setTienIchDto(tienIch);

        PinDto pin = new PinDto();
        pin.setLoaiPin(dienThoai.getPin().getLoaiPin());
        pin.setCongNghe(dienThoai.getPin().getCongNghe());
        pin.setDungLuong(String.valueOf(dienThoai.getPin().getDungLuong()));
        dt.setPinDto(pin);

        DTKetNoiDto dtKetNoi = new DTKetNoiDto();
        dtKetNoi.setBluetooth(dienThoai.getDtKetNoi().getBluetooth());
        dtKetNoi.setMangDiDong(dienThoai.getDtKetNoi().getMangDiDong());
        dtKetNoi.setGps(dienThoai.getDtKetNoi().getGps());
        dtKetNoi.setWifi(dienThoai.getDtKetNoi().getWifi());
        dtKetNoi.setCongSac(dienThoai.getDtKetNoi().getCongSac());
        dtKetNoi.setTaiNghe(dienThoai.getDtKetNoi().getTaiNghe());
        dtKetNoi.setKetNoiKhac(dienThoai.getDtKetNoi().getKetNoiKhac());
        dt.setDtKetNoiDto(dtKetNoi);

        KichThuocTrongLuongDto kichThuocTrongLuong = new KichThuocTrongLuongDto();
        kichThuocTrongLuong.setDoDai(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoDai()));
        kichThuocTrongLuong.setDoMong(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoMong()));
        kichThuocTrongLuong.setDoRong(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoRong()));
        kichThuocTrongLuong.setTrongLuong(String.valueOf(dienThoai.getKichThuocTrongLuong().getTrongLuong()));
        dt.setKichThuocTrongLuongDto(kichThuocTrongLuong);
        List<ImageDto> imageDtos = new ArrayList<>();
        for (Image i: dienThoai.getImages()) {
            ImageDto img = new ImageDto();
            img.setId(i.getId());
            img.setUrlImg(imgDir+i.getUrlImg());
            imageDtos.add(img);
        }
        dt.setImageDto(imageDtos);
        dt.setActive(dienThoai.isActive());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(dienThoai.getCategory().getId());
        categoryDto.setTen(dienThoai.getCategory().getTen());
        categoryDto.setMoTa(dienThoai.getCategory().getMoTa());
        dt.setCategoryDto(categoryDto);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLoai().equals("dienthoai")){
                CategoryDto cto = new CategoryDto();
                cto.setId(list.get(i).getId());
                cto.setTen(list.get(i).getTen());
                cto.setMoTa(list.get(i).getMoTa());
                categoryDtos.add(cto);
            }
        }
        List<CameraDto> cameraDtos = new ArrayList<>();
        for (Camera i: dienThoai.getCameras()) {
            CameraDto c = new CameraDto();
            c.setId(i.getId());
            c.setLoai(i.getLoai());
            c.setDoPhanGiaiCamera(i.getDoPhanGiaiCamera());
            c.setTinhNang(i.getTinhNang());
            cameraDtos.add(c);
        }
        dt.setCameraDtoList(cameraDtos);
        model.addAttribute("tittle","Sửa sản phẩm");
        model.addAttribute("fileImg",imageDtos);
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("dienthoai",dt);
        return "addProductDT";
    }
    @PostMapping("/admin/editProductDT")
    public String editProductDT(@ModelAttribute("dienthoai") DienThoaiDto dienThoaiDto,Model model
            ,@RequestParam("listimages") List<MultipartFile> listimages){
        List<ImageDto> imageDtoList = dienThoaiDto.getImageDto();

        ArrayList<Long> imgDelete = new ArrayList<>();
        if (dienThoaiDto.getId()!=null){
            DienThoai dt1 = dienThoaiService.findDtById(dienThoaiDto.getId()).get();
            List<Image> imgDb = dt1.getImages();
            //O(nlog(n))
            Collections.sort(imgDb, new Comparator<Image>() {
                @Override
                public int compare(Image o1, Image o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            List<ImageDto> imageDtoList1 = dienThoaiDto.getImageDto();
            //O(m)
            Iterator<ImageDto> itr = imageDtoList1.listIterator();
            while (itr.hasNext()){
                if (itr.next().getId()==null){
                    itr.remove();
                }
            }
            //O(mlog(m))
            Collections.sort(imageDtoList1, new Comparator<ImageDto>() {
                @Override
                public int compare(ImageDto o1, ImageDto o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            if(imageDtoList1!=null){
                for (ImageDto i :imageDtoList1) {
                    System.out.println(i);
                    System.out.println("url old: "+i.getUrlImg());
                    System.out.println("id old: "+i.getId());
                }
            }
            //O(mlog(n))
            imgDelete = findNotExitImg(imageDtoList1,imgDb);
            //nlog(n)+m+mlog(m)+mlog(n) < m*n
        }
        System.out.println(imgDelete);
        for (MultipartFile i : listimages) {
            System.out.println("new filr: "+i.getOriginalFilename());
            System.out.println("id: "+i.getOriginalFilename());
        }
        if(true) return this.editProduct(dienThoaiDto.getId(),model);
        return "home_admin";
    }
    private static ArrayList<Long>  findNotExitImg(List<ImageDto> imgDtos, List<Image> d){
        ArrayList<Long> a = new ArrayList<>();
        for (Image img : d) {
            if (searchNP(imgDtos, 0, imgDtos.size() - 1, img.getId()) == -1) {
                a.add(img.getId());
            };
        }
        return a;
    }
    private static Integer searchNP(List<ImageDto> img,int dau, int cuoi, long so){
        if (dau<=cuoi) {
            int mid = (dau+cuoi)/2;
            if (so == img.get(mid).getId()) return mid;
            if (so>img.get(mid).getId()) return searchNP(img,mid+1,cuoi,so);
            else return searchNP(img,dau,mid-1,so);
        }
        else return -1;
    }
    @GetMapping(value = "/admin/detailsProductDT/{id}")
    public String detailsProDuctDT(@PathVariable Long id,Model model){
        DienThoai dienThoai = dienThoaiService.findDtById(id).get();
        DienThoaiDto dt = new DienThoaiDto();
        dt.setId(dienThoai.getId());
        dt.setMaSp(dienThoai.getMasp());
        dt.setTen(dienThoai.getTenSp());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(dienThoai.getGia());
        dt.setGia(str1);
        dt.setSoLuong(dienThoai.getSoLuong());
        dt.setColor(dienThoai.getColor());
        dt.setHang(dienThoai.getHang());
        dt.setNgayRaMat(dienThoai.getNgayRaMat());
        dt.setChatLieu(dienThoai.getChatLieu());
        dt.setThietKe(dienThoai.getThietKe());
        dt.setMoTa(dienThoai.getMoTa());

        DTHeDieuHanhCpuDto dtHeDieuHanhCpu = new DTHeDieuHanhCpuDto();
        dtHeDieuHanhCpu.setCpu(dienThoai.getDtHeDieuHanhCPU().getCpu());
        dtHeDieuHanhCpu.setHeDieuHanh(dienThoai.getDtHeDieuHanhCPU().getHeDieuHanh());
        dtHeDieuHanhCpu.setTocDoCpu(dienThoai.getDtHeDieuHanhCPU().getTocDoCpu());
        dtHeDieuHanhCpu.setGpu(dienThoai.getDtHeDieuHanhCPU().getGpu());
        dt.setDtHeDieuHanhCpuDto(dtHeDieuHanhCpu);

        ManHinhDto manHinh = new ManHinhDto();
        manHinh.setCongNgheManHinh(dienThoai.getManHinh().getCongNgheManHinh());
        manHinh.setDoPhanGiai(dienThoai.getManHinh().getDoPhanGiai());
        manHinh.setDoSangToiDa(String.valueOf(dienThoai.getManHinh().getDoSangToiDa()));
        manHinh.setKichThuoc(String.valueOf(dienThoai.getManHinh().getKichThuoc()));
        manHinh.setMatKinhCamUng(dienThoai.getManHinh().getMatKinhCamUng());
        manHinh.setTanSoQuet(String.valueOf(dienThoai.getManHinh().getTanSoQuet()));
        dt.setManHinhDto(manHinh);

        DTBoNhoDto dtBoNho = new DTBoNhoDto();
        dtBoNho.setRam(String.valueOf(dienThoai.getDtBoNho().getRam()));
        dtBoNho.setRom(String.valueOf(dienThoai.getDtBoNho().getRom()));
        dt.setDtBoNhoDto(dtBoNho);

        TienIchDto tienIch = new TienIchDto();
        tienIch.setBaoMat(dienThoai.getTienIch().getBaoMat());
        tienIch.setTinhNangDacBiet(dienThoai.getTienIch().getTinhNangDacBiet());
        dt.setTienIchDto(tienIch);

        PinDto pin = new PinDto();
        pin.setLoaiPin(dienThoai.getPin().getLoaiPin());
        pin.setCongNghe(dienThoai.getPin().getCongNghe());
        pin.setDungLuong(String.valueOf(dienThoai.getPin().getDungLuong()));
        dt.setPinDto(pin);

        DTKetNoiDto dtKetNoi = new DTKetNoiDto();
        dtKetNoi.setBluetooth(dienThoai.getDtKetNoi().getBluetooth());
        dtKetNoi.setMangDiDong(dienThoai.getDtKetNoi().getMangDiDong());
        dtKetNoi.setGps(dienThoai.getDtKetNoi().getGps());
        dtKetNoi.setWifi(dienThoai.getDtKetNoi().getWifi());
        dtKetNoi.setCongSac(dienThoai.getDtKetNoi().getCongSac());
        dtKetNoi.setTaiNghe(dienThoai.getDtKetNoi().getTaiNghe());
        dtKetNoi.setKetNoiKhac(dienThoai.getDtKetNoi().getKetNoiKhac());
        dt.setDtKetNoiDto(dtKetNoi);

        KichThuocTrongLuongDto kichThuocTrongLuong = new KichThuocTrongLuongDto();
        kichThuocTrongLuong.setDoDai(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoDai()));
        kichThuocTrongLuong.setDoMong(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoMong()));
        kichThuocTrongLuong.setDoRong(String.valueOf(dienThoai.getKichThuocTrongLuong().getDoRong()));
        kichThuocTrongLuong.setTrongLuong(String.valueOf(dienThoai.getKichThuocTrongLuong().getTrongLuong()));
        dt.setKichThuocTrongLuongDto(kichThuocTrongLuong);
        List<ImageDto> imageDtos = new ArrayList<>();
        for (Image i: dienThoai.getImages()) {
            ImageDto img = new ImageDto();
            img.setId(i.getId());
            img.setUrlImg(imgDir+i.getUrlImg());
            imageDtos.add(img);
        }
        dt.setImageDto(imageDtos);
        dt.setActive(dienThoai.isActive());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(dienThoai.getCategory().getId());
        categoryDto.setTen(dienThoai.getCategory().getTen());
        categoryDto.setMoTa(dienThoai.getCategory().getMoTa());
        dt.setCategoryDto(categoryDto);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (int i = 0; i < list.size(); i++) {
            CategoryDto cto = new CategoryDto();
            cto.setId(list.get(i).getId());
            cto.setTen(list.get(i).getTen());
            cto.setMoTa(list.get(i).getMoTa());
            categoryDtos.add(cto);
        }
        List<CameraDto> cameraDtos = new ArrayList<>();
        for (Camera i: dienThoai.getCameras()) {
            CameraDto c = new CameraDto();
            c.setId(i.getId());
            c.setLoai(i.getLoai());
            c.setDoPhanGiaiCamera(i.getDoPhanGiaiCamera());
            c.setTinhNang(i.getTinhNang());
            cameraDtos.add(c);
        }
        dt.setCameraDtoList(cameraDtos);
        model.addAttribute("fileImg",imageDtos);
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("dienthoai",dt);
        return "productDtDetails";
    }
    @Autowired
    KhuyenMaiService khuyenMaiService;
    @GetMapping("/admin/quanliKhuyenMai")
    public String quanliKM(Model model){
        List<KhuyenMaiDto> khuyenMaiDtoList = new ArrayList<>();
        List<KhuyenMai> list = khuyenMaiService.findAll();
        for (KhuyenMai i:list){
            KhuyenMaiDto kmdto = i.convertToDto();
            khuyenMaiDtoList.add(kmdto);
        }
        model.addAttribute("khuyenmais",khuyenMaiDtoList);
        return "quanlikhuyenmai";
    }
    @GetMapping("/admin/addKhuyenMai")
    public String addKhuyenMai(Model model){
        KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto();
        model.addAttribute("khuyenMai",khuyenMaiDto);
        return "addKhuyenMai";
    }
    @PostMapping("/admin/addKhuyenMai")
    public String addKhuyenMaidt(@ModelAttribute("khuyenMai") KhuyenMaiDto khuyenMaiDto){
            KhuyenMai khuyenMai = khuyenMaiDto.convertToEntity();
            try {
                khuyenMaiService.addKm(khuyenMai);
            }
            catch (Exception e){
                return "addKhuyenMai";
            }
            return "redirect:/admin/quanliKhuyenMai";
    }
    @GetMapping("/admin/editKhuyenMai/{id}")
    public String editKhuyenMaidt(@PathVariable Long id, Model model){
        Optional<KhuyenMai> khuyenMai = khuyenMaiService.findKMById(id);
        if (khuyenMai.isPresent()){
            KhuyenMaiDto khuyenMaiDto = khuyenMai.get().convertToDto();
            khuyenMaiDto.setTiLe(String.valueOf(khuyenMai.get().getTiLe()));
            model.addAttribute("khuyenMai",khuyenMaiDto);
        }
        else return "redirect:/admin/quanliKhuyenMai";
        return "addKhuyenMai";
    }
    @GetMapping("/admin/deleteKhuyenMai/{id}")
    public String deleteKm(@PathVariable Long id){
        try{
            khuyenMaiService.deleteKMById(id);
            return "redirect:/admin/quanliKhuyenMai";
        }
        catch (Exception e){
            return "redirect:/admin/quanliKhuyenMai";
        }
    }
    @GetMapping("/admin/addKmSpDt/{id}")
    public String addKhuyenMaiSp(@PathVariable Long id,Model model){
        Optional<KhuyenMai> khuyenMai = khuyenMaiService.findKMById(id);
        KhuyenMaiDto khuyenMaiDto = new KhuyenMaiDto();
        if (khuyenMai.isPresent()){
            khuyenMaiDto = khuyenMai.get().convertToDto();
        }
        List<DienThoai> dienThoais = dienThoaiService.findAll();
        List<DienThoaiDto> dtoList = new ArrayList<>();
        List<Long> dsCu = new ArrayList<>();
        for (DienThoai dienThoai : dienThoais) {
            DienThoaiDto a = new DienThoaiDto();
            a.setId(dienThoai.getId());
            a.setMaSp(dienThoai.getMasp());
            a.setTen(dienThoai.getTenSp());
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String str1 = currencyVN.format(dienThoai.getGia());
            a.setGia(str1);
            a.setColor(dienThoai.getColor());
            a.setSoLuong(dienThoai.getSoLuong());
            if (dienThoai.getKhuyenMai()!=null){
                a.setKhuyenMaiDto(dienThoai.getKhuyenMai().convertToDto());
                if(dienThoai.getKhuyenMai().getId()==id){
                    dsCu.add(dienThoai.getId());
                }

            }
            dtoList.add(a);
        }
        List<Long> dsAdd = new ArrayList<>();
        model.addAttribute("dienthoais",dtoList);
        model.addAttribute("khuyenmai",khuyenMaiDto);
        model.addAttribute("dsCu",dsCu);
        return "addKmSp";
    }
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @PostMapping("/admin/addKmSpDt/{id}")
    public String addKmSp(@PathVariable Long id,
                          @RequestParam(required=false,name = "dsadd")List<Long> listadd){
        System.err.println("id: "+id);
        System.out.println(listadd);
        List<DienThoai> dienThoais = dienThoaiService.findAll();
        List<Long> dsCu = new ArrayList<>();
        for (DienThoai dienThoai : dienThoais) {
            if (dienThoai.getKhuyenMai()!=null && dienThoai.getKhuyenMai().getId().equals(id)){
                dsCu.add(dienThoai.getId());
            }
        }
        if (dsCu!= null){
            Collections.sort(dsCu);
        }
        if (listadd != null){
            Collections.sort(listadd);
            System.err.println("dscu: "+dsCu);
            System.err.println("dsadd: "+listadd);
            List<Long> xoa = new ArrayList<>();
            List<Long> them = new ArrayList<>();
            xoa = searchNPLong(dsCu,listadd);
            them = searchNPLong(listadd,dsCu);
            System.err.println("xoas: "+xoa);
            System.err.println("them: "+them);
            if (!xoa.isEmpty()){
                for (Long item:xoa){
                    SanPham s = sanPhamRepository.findById(item).get();
                    s.setKhuyenMai(null);
                    sanPhamRepository.save(s);
//                khuyenMaiService.updateKMSP(null,item);
                }
            }
            if (!them.isEmpty()){
                for (Long item:them){
                    SanPham s = sanPhamRepository.findById(item).get();
                    KhuyenMai km = khuyenMaiRepository.findById(id).get();
                    s.setKhuyenMai(km);
                    sanPhamRepository.save(s);
                }
            }
        }
        else {
            for (Long item : dsCu){
                SanPham s = sanPhamRepository.findById(item).get();
                s.setKhuyenMai(null);
                sanPhamRepository.save(s);
            }
        }

        return "redirect:/admin/quanliKhuyenMai";
    }
    private static List<Long> searchNPLong(List<Long> ds1,List<Long> ds2){
        List<Long> ds3 = new ArrayList<>();
        for (int i = 0; i < ds1.size(); i++) {
            if (searchNP1(ds2,0,ds2.size()-1,ds1.get(i))==-1){
                ds3.add(ds1.get(i));
            }
        }
        return ds3;
    }
    private static Integer searchNP1(List<Long> list,int dau, int cuoi, long so){
        if (dau<=cuoi) {
            int mid = (dau+cuoi)/2;
            if (so == list.get(mid)) return mid;
            if (so>list.get(mid)) return searchNP1(list,mid+1,cuoi,so);
            else return searchNP1(list,dau,mid-1,so);
        }
        else return -1;
    }

}
