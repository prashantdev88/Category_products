package com.javamachine.service;




import com.javamachine.entity.Category;
import com.javamachine.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    
    public Page<Category> findProductsWithPagination(int offset,int pageSize){
        Page<Category> categories = categoryRepository.findAll(PageRequest.of(offset, pageSize));
        return  categories;
    }
    
    public Category getCategory(int id){
        Optional<Category> category = categoryRepository.findById(id);

        return category.get();
    }
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(int id,Category category){
    	category.setCategoryId(id);
        return categoryRepository.save(category);
    }
    public void deleteCategory(int id){
    	categoryRepository.deleteById(id);
    }
}