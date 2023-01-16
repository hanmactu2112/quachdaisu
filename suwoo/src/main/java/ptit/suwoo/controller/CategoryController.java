package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ptit.suwoo.model.Category;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/admin/addCategory")
    public String addCategory(Model model){
        model.addAttribute("category", new CategoryDto());
        return "addCategory";
    }
    @PostMapping("/admin/addCategory")
    public String addCategory(@ModelAttribute("category")CategoryDto categoryDto,
                              @RequestParam("loai") String loai){
        System.err.println(loai+" Loai category");
        Category category = new Category();
        System.err.println(categoryDto.getId());
        if (categoryDto.getId()!=null){
            category.setId(categoryDto.getId());
        }
        category.setTen(categoryDto.getTen());
        category.setLoai(loai);
        category.setMoTa(categoryDto.getMoTa());
        categoryService.saveCategory(category);
        return "redirect:/admin/managerCategory";
    }
    @GetMapping("/admin/managerCategory")
    public String managerStaff(Model model){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (Category category : list) {
            CategoryDto c = new CategoryDto();
            c.setId(category.getId());
            c.setTen(category.getTen());
            if (category.getLoai()!=null){
                if (category.getLoai().equals("dienthoai")) {
                    c.setLoai("Điện thoại");
                } else if (category.getLoai().equals("laptop")) {
                    c.setLoai("Laptop");
                } else if (category.getLoai().equals("phukien")) {
                    c.setLoai("Phụ kiện");
                }
            }
            c.setMoTa(category.getMoTa());
            categoryDtos.add(c);
        }
        model.addAttribute("categories",categoryDtos);
        return "managerCategory";
    }
    @GetMapping("/admin/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            categoryService.deleteCategoryById(id);
            redirectAttributes.addFlashAttribute("success","Xóa danh mục thành công !!!");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error","Có sản phẩm thuộc danh mục này!!!");
        }

        return "redirect:/admin/managerCategory";
    }
    @GetMapping("/admin/editCategory/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        Category category = categoryService.findById(id).get();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTen(category.getTen());
        categoryDto.setLoai(category.getLoai());
        categoryDto.setMoTa(category.getMoTa());
        model.addAttribute("category",categoryDto);
        return "addCategory";
    }
}
