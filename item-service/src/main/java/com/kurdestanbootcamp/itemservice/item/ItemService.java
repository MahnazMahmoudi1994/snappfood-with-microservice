package com.kurdestanbootcamp.itemservice.item;

import com.kurdestanbootcamp.itemservice.common.SearchCriteria;
import com.kurdestanbootcamp.itemservice.common.SearchSpecification;
import com.kurdestanbootcamp.itemservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService implements IItemService {

    private  final ItemRepository repository;


    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public Item update(Item item) {

        Item lastItem = getById(item.getId());

        lastItem.setName(item.getName());
        lastItem.setDescription(item.getDescription());
        lastItem.setPrice(item.getPrice());
        lastItem.setImage(item.getImage());

        return repository.save(lastItem);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Item getById(Long id) {
        Optional<Item> optionalItem = repository.findById(id);

        if (!optionalItem.isPresent()){

            throw new NotFoundException("Item Not Found");
        }

        return optionalItem.get();
    }

    @Override
    public List<Item> getAll() {

        return (List<Item>) repository.findAll();
    }

    @Override
    public List<Item> getAllBySupplierCategory(Long supplierCategoryId) {
        return repository.findAllBySupplierCategoryId(supplierCategoryId);
    }

    @Override
    public Page<Item> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Item> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Item> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);
    }


}
