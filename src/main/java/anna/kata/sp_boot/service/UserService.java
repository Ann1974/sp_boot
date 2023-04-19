package anna.kata.sp_boot.service;

import anna.kata.sp_boot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User updateUser);

    void removeUserById(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

}
