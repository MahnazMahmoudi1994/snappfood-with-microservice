package com.kurdestanbootcamp.addressservice.address;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address/")
@AllArgsConstructor
public class AddressController {

    private final IAddressService addressService;
    private AddressMapper addressMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody AddressDTO addressDTO){
        Address address =addressMapper.toAddress(addressDTO);
        addressService.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody AddressDTO addressDTO){
        Address address =addressMapper.toAddress(addressDTO);
        addressService.update(address);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<AddressDTO> getById(@PathVariable Long id ){
        Address address = addressService.getById(id);
        AddressDTO addressDTO =addressMapper.toAddressDTO(address);
        return ResponseEntity.ok(addressDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<AddressDTO>> getAll(){
        List<Address> addresses= addressService.getAll();
        List<AddressDTO> addressDTOS = addressMapper.toAddressDTOS(addresses);

        return ResponseEntity.ok(addressDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        addressService.delete(id);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/get-all-by-user/{userId}")
    public ResponseEntity<List<AddressDTO>> getAllByUser(@PathVariable Long userId){
        List<Address> addresses= addressService.getAllByUser(userId);
        List<AddressDTO> addressDTOS = addressMapper.toAddressDTOS(addresses);

        return ResponseEntity.ok(addressDTOS);
    }


}
