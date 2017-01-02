package client.domain.Aggregates.ProductAggregate;


import common.Interfaces.Entity;

public class Model extends Entity{
    private double price;
    private Category category;
    private AdditionalInfo additionalInfo;

    public Model(int id, double price, Category category, AdditionalInfo additionalInfo) {
        super(id);
        this.price = price;
        this.category = category;
        this.additionalInfo = additionalInfo;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;

    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
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
