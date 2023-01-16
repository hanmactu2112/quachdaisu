package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.SanPhamService.ImageService;
import ptit.suwoo.SanPhamService.PhuKienService;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.Image;
import ptit.suwoo.model.PhuKien;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.service.CategoryService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;


@Controller
public class PhuKienController {
    private static final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/pkImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    PhuKienService phuKienService;
    @Autowired
    ImageService imageService;
    @GetMapping("/admin/managerProductPK")
    public String managerPhuKien(Model model){
        model.addAttribute("phukiens",phuKienService.findAll());
        return "managerPhuKien";
    }
    @GetMapping("/admin/addProductPK")
    public String addPhuKien(Model model){
        PhuKien phuKien = new PhuKien();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (Category category : list) {
            if (category.getLoai().equals("phukien")){
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
        model.addAttribute("phukien",phuKien);
        return "addPhuKien";
    }

    @PostMapping("/admin/addProductPK")
    public String addPhuKien(@ModelAttribute("phukien") PhuKien phuKien,
                             @RequestParam("listimages") List<MultipartFile> images,
                             @RequestParam("category") String category) throws IOException{
        Category c = categoryService.findById(Long.parseLong(category)).get();
        phuKien.setCategory(c);
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile file : images) {
            String imageUUID;
            String nameFile = file.getOriginalFilename();
            if (!file.isEmpty()) {
                imageUUID = file.getOriginalFilename();
                System.err.println("imageUUID: " + imageUUID);
                Random random = new Random();
                String ext = "";
                for (int j = imageUUID.length() - 1; j >= 0; j--) {
                    if (imageUUID.charAt(j) == '.') {
                        ext = imageUUID.substring(j, imageUUID.length());
                    }
                }
                Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
                int t = 1;
                while (t == 1) {
                    nameFile = String.format("%s%s", System.currentTimeMillis(), random.nextInt(100000) + ext);
                    fileNameAndPath = Paths.get(uploadDir, nameFile);
                    boolean exists = Files.exists(fileNameAndPath);
                    if (!exists) t = 0;
                }
                Image image = new Image();
                image.setUrlImg(nameFile);
                System.err.println("imageUUID: " + nameFile);
                Files.write(fileNameAndPath, file.getBytes());
                imageList.add(image);
            }
        }
        if (phuKien.getId()!=0){
            List<Image> imgNew = phuKien.getImages();
            if (imgNew != null){
                imgNew.removeIf(i -> i==null);
                imageList.addAll(imgNew);
            }
        }
        phuKien.setImages(imageList);
        phuKienService.save(phuKien);
        return "redirect:/admin/managerProductPK";
    }


    @GetMapping("/admin/deleteProductPK/{id}")
    public String deleteProductPK(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            phuKienService.deletePKById(id);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute("error","Sản phẩm không còn tồn tại !!!");
        }
        redirectAttributes.addFlashAttribute("success","Xóa sản phẩm thành công !!!");
        return "redirect:/admin/managerProductPK";
    }

    @GetMapping("/admin/editProductPK/{id}")
    public String editProductPK(@PathVariable Long id, Model model){
        PhuKien pk = phuKienService.findPkById(id).get();
        System.err.println(pk.getId()+"ffffffffffff");
        List<Category> categories = categoryService.findAll();
        categories.removeIf(i ->!i.getLoai().equals("phukien"));
        List<Image> images = pk.getImages();
        Category categoryDto = pk.getCategory();
        model.addAttribute("title","Sửa sản phẩm");
        model.addAttribute("phukien", pk);
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories", categories);
        model.addAttribute("images", images);

        return "addPhuKien";
    }
}
