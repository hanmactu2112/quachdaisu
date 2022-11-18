package ptit.suwoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptit.suwoo.model.Category;
import ptit.suwoo.sanphamdto.CategoryDto;
import ptit.suwoo.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/addCategory")
    public String addCategory(Model model){
        model.addAttribute("category", new CategoryDto());
        return "addCategory";
    }
    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category")CategoryDto categoryDto){
        Category category = new Category();
        System.err.println(categoryDto.getId());
        if (categoryDto.getId()!=null){
            category.setId(categoryDto.getId());
        }
        category.setTen(categoryDto.getTen());
        category.setMoTa(categoryDto.getMoTa());
        categoryService.saveCategory(category);
        return "redirect:/managerCategory";
    }
    @GetMapping("/managerCategory")
    public String managerStaff(Model model){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> list = categoryService.findAll();
        for (int i = 0; i < list.size(); i++) {
            CategoryDto c = new CategoryDto();
            c.setId(list.get(i).getId());
            c.setTen(list.get(i).getTen());
            c.setMoTa(list.get(i).getMoTa());
            categoryDtos.add(c);
        }
        model.addAttribute("categories",categoryDtos);
        return "managerCategory";
    }
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return "redirect:/managerCategory";
    }
    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        Category category = categoryService.findById(id).get();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTen(category.getTen());
        categoryDto.setMoTa(category.getMoTa());
        model.addAttribute("category",categoryDto);
        return "addCategory";
    }
}
