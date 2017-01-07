package warehouse.domain.ProductAggregate;


import common.Interfaces.Entity;

import java.util.HashSet;
import java.util.Set;

public class Model extends Entity{
    private String name;
    private byte[] image;
    private double price;
    private Category category;
    private Set<AdditionalModelInfo> additionalModelInfo;

    public Model(int id, String name, byte[] image, double price, Category category, Set<AdditionalModelInfo> additionalModelInfo) {
        super(id);
        this.name = name;
        this.price = price;
        this.category = category;
        this.additionalModelInfo = additionalModelInfo;
        this.image = image;
    }

    public Model(String name, byte[] image, double price,  Category category, Set<AdditionalModelInfo> additionalModelInfo) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.additionalModelInfo = additionalModelInfo;
        this.image = image;
    }

    public Model(int id,String name, byte[] image,  double price, Category category) {
        super(id);
        this.name = name;
        this.price = price;
        this.category = category;
        this.additionalModelInfo = new HashSet<>();
        this.image = image;
    }

    public Model(String name, byte[] image, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.additionalModelInfo = new HashSet<>();
        this.image = image;
    }

    public Model() {
    }

    public Set<AdditionalModelInfo> getAdditionalModelInfo() {
        return additionalModelInfo;

    }

    public void setAdditionalModelInfo(Set<AdditionalModelInfo> additionalModelInfo) {
        this.additionalModelInfo = additionalModelInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
