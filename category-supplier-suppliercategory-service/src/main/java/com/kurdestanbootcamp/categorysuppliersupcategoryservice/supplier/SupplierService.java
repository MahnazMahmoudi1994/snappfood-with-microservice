package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.Category;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.ICategoryService;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.SearchCriteria;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.SearchSpecification;
import com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService {

    private  final SupplierRepository repository;
    private  final ICategoryService categoryService;


    @Override
    public Supplier save(Supplier supplier) {
        Long categoryId = supplier.getCategory().getId();
        Category category = categoryService.getById(categoryId);
        supplier.setCategory(category);
        return repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier lastSupplier = getById(supplier.getId());

        lastSupplier.setName(supplier.getName());
        lastSupplier.setAddress(supplier.getAddress());
        lastSupplier.setLocation(supplier.getLocation());
        lastSupplier.setLogo(supplier.getLogo());

        Long categoryId = supplier.getCategory().getId();
        Category category = categoryService.getById(categoryId);
        lastSupplier.setCategory(category);

        return repository.save(lastSupplier);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Supplier getById(Long id) {

        Optional<Supplier> optionalSupplier=repository.findById(id);

        if (!optionalSupplier.isPresent()){

            throw new NotFoundException("Supplier Not Found");
        }

        return optionalSupplier.get();
    }

    @Override
    public List<Supplier> getAll() {

        return (List<Supplier>) repository.findAll();
    }

    @Override
    public List<Supplier> getAllByCategory(Long categoryId) {
        Category category = categoryService.getById(categoryId);
        return repository.findAllByCategory(category);
    }

    @Override
    public Page<Supplier> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Supplier> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<Supplier> searchSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> searchSpecification.add(criteria));

        return repository.findAll(searchSpecification);
    }

    @Override
    public List<Supplier> getAllSupplierByDistanceAndPoint(Point<G2D> refPnt, double dist) {
        return repository.findAllSupplierByDistanceAndPoint(refPnt,dist);
    }
}
