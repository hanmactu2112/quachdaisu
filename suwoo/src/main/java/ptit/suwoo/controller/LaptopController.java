package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ptit.suwoo.Dto.laptopDto.LaptopDTO;
import ptit.suwoo.SanPhamService.ImageService;
import ptit.suwoo.SanPhamService.LaptopService;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.laptopmodel.Laptop;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.sanphamdto.ImageDto;
import ptit.suwoo.service.CategoryService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@Controller
public class LaptopController {
    private static final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/ltImages";
    @Autowired
    LaptopService laptopService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ImageService imageService;
    @GetMapping("/admin/managerProductLT")
    public String managerLaptop(Model model){
        List<LaptopDTO> ds = new ArrayList<>();
        List<Laptop> laptops = laptopService.findAllLT();
        for (Laptop i:laptops){
            LaptopDTO a = i.convertToDto();
            ds.add(a);
        }
        model.addAttribute("laptops",ds);
        return "managerLaptop";
    }
    @GetMapping("/admin/addProductLT")
    public String addProductLT(Model model){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (Category category : list) {
            if (category.getLoai().equals("laptop")){
                CategoryDto cto = category.convertToDto();
                categoryDtos.add(cto);
            }
        }
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("laptop",new LaptopDTO());
        return "addProductLT";
    }
    @PostMapping("/admin/addProductLT")
    public String addProductLT(@ModelAttribute("laptop") LaptopDTO laptopDTO,
                               @RequestParam("listimages") List<MultipartFile> images,
                               @RequestParam("category") String category
    ) throws IOException{
        System.err.println("category: "+laptopDTO.getCategoryDto());
        Laptop laptop = laptopDTO.ConvertToEntity();
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
        if(laptopDTO.getId()!=null){
            List<ImageDto> listDto = laptopDTO.getImageDto();
            System.err.println("listDto: "+listDto);
            if(listDto!=null){
                listDto.removeIf(imageDto -> imageDto.getId() == null);
            }
            Laptop lt1 = laptopService.findLTById(laptopDTO.getId()).get();
            List<Image> imgDb = lt1.getImages();
            imgDb.removeIf(i->i.getId()==null);
            Iterator<Image> itr1 = imgDb.listIterator();
            List<Long> imgDelete = new ArrayList<>();
            while(itr1.hasNext()){
                if (itr1.next().getId()==null){
                    itr1.remove();
                }
            }
            System.err.println("ds moi: "+listDto);

            if (listDto!=null){
                for (Image img:imgDb){
                    boolean ktra = false;
                    for (ImageDto imgDto:listDto){
                        if (img.getId().equals(imgDto.getId())) {
                            ktra = true;
                            break;
                        }
                    }
                    if (!ktra) imgDelete.add(img.getId());
                }
            }
            else {
                for (Image i:imgDb){
                    imgDelete.add(i.getId());
                }
            }
            System.err.println("img delete:"+imgDelete);

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
                        imgDb.remove(img.get());
                    }

                }
            }
            imageList.addAll(imgDb);
        }

        laptop.setImages(imageList);
        laptop.setCategory(categoryService.findById(Long.parseLong(category)).get());
        laptop.setNgayDangSP(Date.valueOf(LocalDate.now()));
        try{
            laptopService.saveLt(laptop);
        }catch (Exception ee){
            if(laptopDTO.getId()!=null)return "redirect:/admin/editProductLT/"+laptopDTO.getId();
            else return "redirect:/admin/addProductLT";
        }
        return "redirect:/admin/managerProductLT";
    }
    @GetMapping("/admin/editProductLT/{id}")
    public String editProductLT(@PathVariable Long id,Model model){
        Laptop laptop = laptopService.findLTById(id).get();
        LaptopDTO laptopDTO = laptop.convertToDtoEdit();
        System.out.println("ssss :"+laptopDTO.getGia());
        System.out.println("ssss :"+laptopDTO.getLtRamOCungDto());
        System.out.println("ssss :"+laptopDTO.getKichThuocTrongLuongDto());
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (Category category : list) {
            if (category.getLoai().equals("laptop")){
                CategoryDto cto = category.convertToDto();
                categoryDtos.add(cto);
            }
        }
        CategoryDto categoryDto = laptop.getCategory().convertToDto();
        model.addAttribute("tittle","Sửa sản phẩm");
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtos);
        model.addAttribute("laptop",laptopDTO);
        return "addProductLT";
    }
    @GetMapping("/admin/detailsProductLT/{id}")
    public String detailsProductLt(@PathVariable Long id, Model model){
        Optional<Laptop> laptop = laptopService.findLTById(id);
        LaptopDTO laptopDTO;
        if (laptop.isPresent()) {
            laptopDTO = laptop.get().convertToDto();
        }
        else return "redirect:/admin/managerProductLT";
        model.addAttribute("laptop",laptopDTO);
        return "productLtDetails";
    }
    @GetMapping("/admin/deleteProductLT/{id}")
    public String deleteProductLt(@PathVariable Long id){
        Optional<Laptop> laptop = laptopService.findLTById(id);
        if (laptop.isPresent()){
            laptopService.deleteLTById(id);
            List<Image> imageList = laptop.get().getImages();
            if (!imageList.isEmpty()){
                for (Image i : imageList) {
                    Path fileNameAndPathOld = Paths.get(uploadDir,i.getUrlImg());
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
                    imageService.delete(i);
                }
            }
        }
        else return "redirect:/admin/managerProductLT";
        return "redirect:/admin/managerProductLT";
    }
}
