package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTO(Category category);

    List<CategoryDTO> toCategoryDTOS(List<Category> categories);

    List<Category> toCategories(List<CategoryDTO> categoryDTOS);

}
