package com.kurdestanbootcamp.userservice.user;

import com.kurdestanbootcamp.userservice.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private  final UserRepository repository;


    @Override
    public User save(User user) {

        return repository.save(user);
    }

    @Override
    public User update(User user) {

        User lastUser = getById(user.getId());

        lastUser.setFirstName(user.getFirstName());
        lastUser.setLastName(user.getLastName());
        lastUser.setPhoneNumber(user.getPhoneNumber());
        return repository.save(lastUser);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optionalUser=repository.findById(id);

        if (!optionalUser.isPresent()){

            throw new NotFoundException("User Not Found");
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {

        return (List<User>) repository.findAll();
    }

    @Override
    public Page<User> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
