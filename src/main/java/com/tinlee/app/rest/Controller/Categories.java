package com.tinlee.app.rest.Controller;

import com.tinlee.app.rest.Models.Category;
import com.tinlee.app.rest.Repo.CategoryRepo;
import org.hibernate.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class Categories {
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping(value = "/api/v1/categories")
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }

    @PostMapping(value = "/api/v1/categories")
    public ResponseEntity saveCategory(@RequestBody Category category){
        categoryRepo.save(category);
        if(category==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    @PutMapping(value = "api/v1/category/{id}")
    public ResponseEntity updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updCat = categoryRepo.findById(id).get();
        updCat.setName(category.getName());
        updCat.setDescription(category.getDescription());
        categoryRepo.save(updCat);

        if(category == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    @GetMapping(value = "api/v1/category/{id}")
    public ResponseEntity getOneCategory(@PathVariable Long id){
         Category category = categoryRepo.findById(id).get();
         if(category==null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok().body(category);
    }

    @DeleteMapping(value = "/api/v1/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        try{
            Category category = categoryRepo.findById(id).get();
            if(category==null){
                return ResponseEntity.notFound().build();
            }
            categoryRepo.delete(category);
            return ResponseEntity.ok().body("Category deleted successfully ......");
        }catch (Exception e){
           return ResponseEntity.ok().body(e.getMessage());
        }

    }
}
