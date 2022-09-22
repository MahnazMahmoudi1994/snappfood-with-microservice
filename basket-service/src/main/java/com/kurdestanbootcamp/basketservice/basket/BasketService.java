package com.kurdestanbootcamp.basketservice.basket;

import com.kurdestanbootcamp.basketservice.common.exception.ConflictException;
import com.kurdestanbootcamp.basketservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService implements IBasketService {

    private final BasketRepository repository;


    @Override
    public Basket save(Basket basket) {

        List<Basket> baskets = getAll();
        for (Basket basket1:baskets){
            if ((basket1.getAddressId().equals(basket.getAddressId())) &&
                    (basket1.getSupplierId().equals(basket.getSupplierId()))){
                throw new ConflictException("This Basket has already been registered");
            }
        }
        return repository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket lastBasket = getById(basket.getId());

        List<Basket> baskets = getAll();
        for (Basket basket1:baskets){
            if ((basket1.getAddressId().equals(basket.getAddressId())) &&
                    (basket1.getSupplierId().equals(basket.getSupplierId()))){
                if(basket1.getId() == basket.getId()){
                    continue;
                }
                throw new ConflictException("This Basket has already been registered");
            }
        }
        lastBasket.setPaidPrice(basket.getPaidPrice());
        lastBasket.setStatus(basket.getStatus());

        return repository.save(lastBasket);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Basket getById(Long id) {
        Optional<Basket> optionalBasket = repository.findById(id);

        if (!optionalBasket.isPresent()){

            throw new NotFoundException("Basket Not Found");
        }

        return optionalBasket.get();
    }

    @Override
    public List<Basket> getAll() {

        return (List<Basket>) repository.findAll();
    }

    @Override
    public List<Basket> getAllByAddress(Long addressId) {
        return repository.findAllByAddressId(addressId);
    }

    @Override
    public List<Basket> getAllBySupplier(Long supplierId) {
        return repository.findAllBySupplierId(supplierId);
    }

    @Override
    public List<Basket> getAllByStatus(Boolean status) {

        return repository.findAllByStatus(status);
    }

    @Override
    public Page<Basket> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }


}
