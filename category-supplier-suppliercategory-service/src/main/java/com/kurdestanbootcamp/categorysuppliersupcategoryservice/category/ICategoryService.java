package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    Category getById(Long id);
    List<Category> getAll();


}
