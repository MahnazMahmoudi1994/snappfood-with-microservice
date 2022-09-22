package com.kurdestanbootcamp.categorysuppliersupcategoryservice.category;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception.ConflictException;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{

    private  final CategoryRepository repository;

    @Caching(evict = {
            @CacheEvict(value = "category", allEntries = true),
            @CacheEvict(value = "category2", allEntries = true)
    })
    @Override
    public Category save(Category category) {

        List<Category> categories = getAll();
        for (Category category1:categories){
            if (category1.getTitle().equals(category.getTitle())){
                throw new ConflictException("This category has already been registered");
            }
        }

       return repository.save(category);
    }

    @Caching(evict = {
            @CacheEvict(value = "category", allEntries = true),
            @CacheEvict(value = "category2", allEntries = true)
    })
    @Override
    public Category update(Category category) {
        Category lastCategory = getById(category.getId());

        List<Category> categories = getAll();
        for (Category category1:categories){
            if (category1.getTitle().equals(category.getTitle())){
                if(category1.getId() == category.getId()){
                    continue;
                }
                throw new ConflictException("This category has already been registered");
            }
        }
        lastCategory.setTitle(category.getTitle());
        lastCategory.setLogo(category.getLogo());
        return repository.save(lastCategory);
    }

    @Caching(evict = {
            @CacheEvict(value = "category", allEntries = true),
            @CacheEvict(value = "category2", allEntries = true)
    })
    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Cacheable(value = "category2",key = "#id")
    @Override
    public Category getById(Long id) {
        Optional<Category> optionalCategory=repository.findById(id);

        if (!optionalCategory.isPresent()){

            throw new NotFoundException("Category Not Found");
        }

        return optionalCategory.get();
    }

    @Cacheable(value = "category")
    @Override
    public List<Category> getAll() {

        return (List<Category>) repository.findAll();
    }
}
