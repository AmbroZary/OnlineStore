package warehouse.domain.ProductAggregate;


import common.Interfaces.Entity;

import java.util.List;

public class Category extends Entity{
    private String Name;

    public Category(int id, String name) {
        super(id);
        Name = name;
    }

    public Category(String name) {
        Name = name;
    }

    public Category() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}
