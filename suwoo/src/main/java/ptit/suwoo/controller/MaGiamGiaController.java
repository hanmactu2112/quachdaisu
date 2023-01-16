package ptit.suwoo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.Dto.magiamgiaDto.MaGiamGiaDto;
import ptit.suwoo.model.Category;
import ptit.suwoo.model.maGiamGia.MaGiamGia;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.service.CategoryService;
import ptit.suwoo.service.MaGiamGiaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MaGiamGiaController {
    @Autowired
    MaGiamGiaService maGiamGiaService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/admin/quanliMaGiamGia")
    public String managerMaGiamGia(Model model){
        List<MaGiamGiaDto> maGiamGiaDtos = new ArrayList<>();
        List<MaGiamGia> ds = maGiamGiaService.findAll();
        for (MaGiamGia i : ds){
            MaGiamGiaDto maGiamGiaDto = i.convertToDtoView();
            if (maGiamGiaDto.getLoaiMa().equals("0")) {
                maGiamGiaDto.setLoaiMa("Giảm theo phần trăm");
            }
            else maGiamGiaDto.setLoaiMa("Giảm theo giá trị");
            maGiamGiaDtos.add(maGiamGiaDto);
        }
        model.addAttribute("maGiamGias",maGiamGiaDtos);
        return "managerMaGiamGia";
    }
    @GetMapping("/admin/addMaGiamGia")
    public String addMaGiamGia(Model model){
       MaGiamGiaDto maGiamGiaDto = new MaGiamGiaDto();
       List<CategoryDto> categoryDtoList = new ArrayList<>();
       List<Category> ds = categoryService.findAll();
       for (Category i:ds){
           CategoryDto c = i.convertToDto();
           categoryDtoList.add(c);
       }
        CategoryDto categoryDto = new CategoryDto();
        model.addAttribute("categoryDto",categoryDto);
       model.addAttribute("categories",categoryDtoList);
       model.addAttribute("maGiamGia",maGiamGiaDto);
        return "addMaGiamGia";
    }
    @PostMapping("/admin/addMaGiamGia")
    public String addMaGiamGia(@ModelAttribute("maGiamGia") MaGiamGiaDto maGiamGiaDto,
                               @RequestParam("loaiMa")String loaiMa,
                               @RequestParam("category")String category_id){
        Category category = categoryService.findById(Long.parseLong(category_id)).get();
        MaGiamGia maGiamGia = maGiamGiaDto.convertToEntity();
        if (maGiamGiaDto.getId()!=null){
            maGiamGia.setId(maGiamGiaDto.getId());
        }
        maGiamGia.setCategory(category);
        maGiamGia.setLoaiMa(loaiMa);
        maGiamGiaService.save(maGiamGia);
        return "redirect:/admin/quanliMaGiamGia";
    }

    @GetMapping("/admin/editMaGiamGia/{id}")
    public String editMaGiamGia(@PathVariable Long id, Model model){
        Optional<MaGiamGia> maGiamGia = maGiamGiaService.findById(id);
        MaGiamGiaDto maGiamGiaDto;
        if (maGiamGia.isPresent()){
            maGiamGiaDto = maGiamGia.get().convertToDto();
        }
        else {
            maGiamGiaDto = new MaGiamGiaDto();
        }
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> ds = categoryService.findAll();
        for (Category i:ds){
            CategoryDto c = i.convertToDto();
            categoryDtoList.add(c);
        }
        CategoryDto categoryDto = maGiamGiaDto.getCategoryDto();
        model.addAttribute("categoryDto",categoryDto);
        model.addAttribute("categories",categoryDtoList);
        model.addAttribute("maGiamGia",maGiamGiaDto);
        return "addMaGiamGia";
    }
    @GetMapping("/admin/deleteMaGiamGia/{id}")
    public String deleteMaGiamGia(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            maGiamGiaService.delete(id);
            redirectAttributes.addFlashAttribute("success","Xóa mã giảm giá thành công !!!");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error","Có sản phẩm thuộc mã giảm giá!!!");
        }

        return "redirect:/admin/quanliMaGiamGia";
    }
}
