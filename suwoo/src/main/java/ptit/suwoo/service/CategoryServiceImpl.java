package ptit.suwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptit.suwoo.Repository.CategoryReponsitory;
import ptit.suwoo.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryReponsitory categoryReponsitory;
    @Override
    public void saveCategory(Category c) {
        categoryReponsitory.save(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryReponsitory.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
       return categoryReponsitory.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<Category> category = categoryReponsitory.findById(id);
        return category;
    }
}
