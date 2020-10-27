package entityDao;

import entity.Gadget;

import java.util.List;

public interface GadgetDAO {
    //create
    void add(Gadget gadget);

    //read
    List<Gadget> getAll();

    Gadget getById(int id);

    //update
    void update(Gadget gadget);

    //delete
    void remove(Gadget gadget);
}
