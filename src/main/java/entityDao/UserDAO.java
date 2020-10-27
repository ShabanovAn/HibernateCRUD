package entityDao;

import entity.Gadget;
import entity.User;

import java.util.List;

public interface UserDAO {
    //create
    void add(User user);

    //read
    List<User> getAll();

    User getById(int id);

    //update
    void update(User user);

    //delete
    void remove(User user);
}
