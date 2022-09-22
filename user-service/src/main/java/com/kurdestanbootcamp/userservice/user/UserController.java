package com.kurdestanbootcamp.userservice.user;


import com.kurdestanbootcamp.userservice.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private UserMapper userMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user =userMapper.toUser(userDTO);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO){
        User user =userMapper.toUser(userDTO);
        userService.update(user);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id ){
        User user = userService.getById(id);
        UserDTO userDTO =userMapper.toUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User> users= userService.getAll();
        List<UserDTO> userDTOS = userMapper.toUserDTOS(users);

        return ResponseEntity.ok(userDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        userService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<UserDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<User> userPage= userService.paging(page,size);

        int totalPage =  userPage.getTotalPages();
        List<User> data = userPage.getContent();
        List<UserDTO> userDTOS = userMapper.toUserDTOS(data);

        PagingData<UserDTO> pagingData = new PagingData<>(totalPage,page,userDTOS);

        return ResponseEntity.ok(pagingData);
    }

}
