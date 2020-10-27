package entity;

import javax.persistence.*;

@Entity
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int phone;
    private int laptop;
    private int tablet;
    private int headphones;

    public Gadget() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getLaptop() {
        return laptop;
    }

    public void setLaptop(int laptop) {
        this.laptop = laptop;
    }

    public int getTablet() {
        return tablet;
    }

    public void setTablet(int tablet) {
        this.tablet = tablet;
    }

    public int getHeadphones() {
        return headphones;
    }

    public void setHeadphones(int headphones) {
        this.headphones = headphones;
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "id=" + id +
                ", phone=" + phone +
                ", laptop=" + laptop +
                ", tablet=" + tablet +
                ", headphones=" + headphones +
                '}';
    }
}
