package ptit.suwoo.controller;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.SanPhamService.DienThoaiService;
import ptit.suwoo.model.*;
import ptit.suwoo.sanphamdto.*;
import ptit.suwoo.service.CategoryService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
public class DienThoaiController {
    private static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/dtImages";
    private static String imgDir = "/dtImages/";
    @Autowired
    DienThoaiService dienThoaiService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/addProductDT")
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
        for (int i = 0; i < list.size(); i++) {
            CategoryDto cto = new CategoryDto();
            cto.setId(list.get(i).getId());
            cto.setTen(list.get(i).getTen());
            cto.setMoTa(list.get(i).getMoTa());
            categoryDtos.add(cto);
        }
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("dienthoai",dienThoaiDto);
        return "addProductDT";

    }
    @PostMapping("/addProductDT")
    public String addProductDT(@ModelAttribute("dienthoai") DienThoaiDto dienThoai,
                               @RequestParam("listimages") List<MultipartFile> images,
                               @RequestParam("category") String category,
    @RequestParam("mtanh") String mtanh) throws IOException {

        DienThoai dt = new DienThoai();
        dt.setMasp(dienThoai.getMaSp());
        dt.setTenSp(dienThoai.getTen());
        dt.setGia(Double.parseDouble(dienThoai.getGia()));
        dt.setSoLuong(Integer.parseInt(dienThoai.getSoLuong()));
        dt.setColor(dienThoai.getColor());
        dt.setHang(dienThoai.getHang());
        dt.setNgayRaMat(dienThoai.getNgayRaMat());
        dt.setNgayDangSP(Date.valueOf(LocalDate.now()));
        dt.setChatLieu(dienThoai.getChatLieu());
        dt.setThietKe(dienThoai.getThietKe());
        dt.setMoTa(dienThoai.getMoTa());

        DTHeDieuHanhCPU dtHeDieuHanhCpu = new DTHeDieuHanhCPU();
        dtHeDieuHanhCpu.setCpu(dienThoai.getDtHeDieuHanhCpuDto().getCpu());
        dtHeDieuHanhCpu.setHeDieuHanh(dienThoai.getDtHeDieuHanhCpuDto().getHeDieuHanh());
        dtHeDieuHanhCpu.setTocDoCpu(dienThoai.getDtHeDieuHanhCpuDto().getTocDoCpu());
        dtHeDieuHanhCpu.setGpu(dienThoai.getDtHeDieuHanhCpuDto().getGpu());
        dt.setDtHeDieuHanhCPU(dtHeDieuHanhCpu);

        ManHinh manHinh = new ManHinh();
        manHinh.setCongNgheManHinh(dienThoai.getManHinhDto().getCongNgheManHinh());
        manHinh.setDoPhanGiai(dienThoai.getManHinhDto().getDoPhanGiai());
        manHinh.setDoSangToiDa(Double.parseDouble(dienThoai.getManHinhDto().getDoSangToiDa()));
        manHinh.setKichThuoc(Double.parseDouble(dienThoai.getManHinhDto().getKichThuoc()));
        manHinh.setMatKinhCamUng(dienThoai.getManHinhDto().getMatKinhCamUng());
        manHinh.setTanSoQuet(Double.parseDouble(dienThoai.getManHinhDto().getTanSoQuet()));
        dt.setManHinh(manHinh);

        DTBoNho dtBoNho = new DTBoNho();
        dtBoNho.setRam(Integer.parseInt(dienThoai.getDtBoNhoDto().getRam()));
        dtBoNho.setRom(Integer.parseInt(dienThoai.getDtBoNhoDto().getRom()));
        dt.setDtBoNho(dtBoNho);

        TienIch tienIch = new TienIch();
        tienIch.setBaoMat(dienThoai.getTienIchDto().getBaoMat());
        tienIch.setTinhNangDacBiet(dienThoai.getTienIchDto().getTinhNangDacBiet());
        dt.setTienIch(tienIch);

        Pin pin = new Pin();
        pin.setLoaiPin(dienThoai.getPinDto().getLoaiPin());
        pin.setCongNghe(dienThoai.getPinDto().getCongNghe());
        pin.setDungLuong(Integer.parseInt(dienThoai.getPinDto().getDungLuong()));
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
        kichThuocTrongLuong.setDoDai(Double.parseDouble(dienThoai.getKichThuocTrongLuongDto().getDoDai()));
        kichThuocTrongLuong.setDoMong(Double.parseDouble(dienThoai.getKichThuocTrongLuongDto().getDoMong()));
        kichThuocTrongLuong.setDoRong(Double.parseDouble(dienThoai.getKichThuocTrongLuongDto().getDoRong()));
        kichThuocTrongLuong.setTrongLuong(Double.parseDouble(dienThoai.getKichThuocTrongLuongDto().getTrongLuong()));
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
                image.setMota(mtanh);
                System.err.println("imageUUID: "+ nameFile);
                Files.write(fileNameAndPath, images.get(i).getBytes());
                imageList.add(image);
            }
        }
        ArrayList<Camera> cameras = new ArrayList<>();
        List<CameraDto> cameraDtos = dienThoai.getCameraDtoList();
        for (int i = 0; i < cameraDtos.size(); i++) {
            Camera c = new Camera();
            if (i==1) c.setLoai("Camera trước");
            else c.setLoai("Camera sau");
            c.setDoPhanGiaiCamera(cameraDtos.get(i).getDoPhanGiaiCamera());
            c.setTinhNang(cameraDtos.get(i).getTinhNang());
            cameras.add(c);
        }
        dt.setActive(dienThoai.isAcitve());
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
        return "redirect:/managerProductDT";
    }
    @GetMapping("/managerProductDT")
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
            a.setSoLuong(String.valueOf(dienThoai.getSoLuong()));
            List<ImageDto> imglist = new ArrayList<>();
            if (dienThoai.getImages().size() > 0) {
                ImageDto imageDto = new ImageDto();
                imageDto.setId(dienThoai.getImages().get(0).getId());
                imageDto.setMoTa(dienThoai.getImages().get(0).getMota());
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
    @GetMapping("/deleteProductDT/{id}")
    public String deleteProductDT(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            dienThoaiService.deleteDTById(id);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute("error","Sản phẩm không còn tồn tại !!!");
        }
        redirectAttributes.addFlashAttribute("success","Xóa sản phẩm thành công !!!");
        return "redirect:/managerProductDT";
    }
    @GetMapping("/editProductDT/{id}")
    public String editProduct(@PathVariable Long id,Model model){
        DienThoai dienThoai = dienThoaiService.findDtById(id).get();
        DienThoaiDto dt = new DienThoaiDto();
        dt.setId(dienThoai.getId());
        dt.setMaSp(dienThoai.getMasp());
        dt.setTen(dienThoai.getTenSp());
        dt.setGia(String.format("%.0f",dienThoai.getGia()));
        dt.setSoLuong(String.valueOf(dienThoai.getSoLuong()));
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
        List<MultipartFile> files = new ArrayList<>();
        for (Image i: dienThoai.getImages()) {

            ImageDto img = new ImageDto();
            img.setId(i.getId());
            img.setUrlImg(imgDir+i.getUrlImg());
            img.setMoTa(i.getMota());
//            Path p = Paths.get(uploadDir,i.getUrlImg());
//            File file = new File("src/test/resources/input.txt");
//            FileInputStream input = new FileInputStream(file);
//            MultipartFile multipartFile = new MockMultipartFile("file",
//                    file.getName(), "text/plain", IOUtils.toByteArray(input));
//            MultipartFile f = new Mul;
//            files.add(f);
            imageDtos.add(img);
        }
        dt.setImageDto(imageDtos);
        dt.setAcitve(dienThoai.isActive());

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
        model.addAttribute("files",files);
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("dienthoai",dt);
        return "addProductDT";
    }
}
