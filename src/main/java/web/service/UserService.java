package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserDao userDao;


    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User getUserById(String id) {
       return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
