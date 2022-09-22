package com.kurdestanbootcamp.categorysuppliersupcategoryservice.supplier;

import com.kurdestanbootcamp.categorysuppliersupcategoryservice.category.Category;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long>, JpaSpecificationExecutor<Supplier> {

    List<Supplier> findAllByCategory(Category category);

    Page<Supplier> findAll(Pageable pageable);

    List<Supplier> findAll(Specification<Supplier> specification);
    @Query("SELECT loc from Supplier loc where distance(loc.location, ?1) < ?2")
    List<Supplier> findAllSupplierByDistanceAndPoint(Point<G2D> refPnt, double dist);


}