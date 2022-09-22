package com.kurdestanbootcamp.itemservice.item;


import com.kurdestanbootcamp.itemservice.common.PagingData;
import com.kurdestanbootcamp.itemservice.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item/")
@AllArgsConstructor
public class ItemController {

    private final IItemService itemService;
    private ItemMapper itemMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ItemDTO itemDTO){
        Item item =itemMapper.toItem(itemDTO);
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ItemDTO itemDTO){
        Item item =itemMapper.toItem(itemDTO);
        itemService.update(item);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable Long id ){
        Item item = itemService.getById(id);
        ItemDTO itemDTO =itemMapper.toItemDTO(item);
        return ResponseEntity.ok(itemDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<ItemDTO>> getAll(){
        List<Item> items= itemService.getAll();
        List<ItemDTO> itemDTOS = itemMapper.toItemDTOS(items);

        return ResponseEntity.ok(itemDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        itemService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-supplier-category/{supplierCategoryId}")
    public ResponseEntity<List<ItemDTO>> getAllBySupplierCategory(@PathVariable Long supplierCategoryId){
        List<Item> items= itemService.getAllBySupplierCategory(supplierCategoryId);
        List<ItemDTO> itemDTOS = itemMapper.toItemDTOS(items);

        return ResponseEntity.ok(itemDTOS);
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<ItemDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<Item> itemPage = itemService.paging(page,size);

        int totalPage = itemPage.getTotalPages();
        List<Item> data = itemPage.getContent();
        List<ItemDTO> itemDTOS = itemMapper.toItemDTOS(data);
        PagingData<ItemDTO> pagingData = new PagingData<>(totalPage,page,itemDTOS);

        return ResponseEntity.ok(pagingData);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<ItemDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<Item> items = itemService.search(searchCriteria);
        List<ItemDTO> itemDTOS = itemMapper.toItemDTOS(items);
        return ResponseEntity.ok(itemDTOS);
    }




}
