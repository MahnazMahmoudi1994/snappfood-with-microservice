package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category/")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;
    private CategoryMapper categoryMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO){
        Category category =categoryMapper.toCategory(categoryDTO);
        categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CategoryDTO categoryDTO){
        Category category =categoryMapper.toCategory(categoryDTO);
        categoryService.update(category);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id ){
        Category category = categoryService.getById(id);
        CategoryDTO categoryDTO =categoryMapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<Category> categories= categoryService.getAll();
        List<CategoryDTO> categoryDTOS = categoryMapper.toCategoryDTOS(categories);

        return ResponseEntity.ok(categoryDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        categoryService.delete(id);
        return ResponseEntity.ok().build();

    }
}
