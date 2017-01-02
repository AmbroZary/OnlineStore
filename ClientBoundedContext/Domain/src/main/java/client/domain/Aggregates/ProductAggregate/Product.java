package client.domain.Aggregates.ProductAggregate;


import common.Interfaces.Entity;

public class Product extends Entity{
    private Model model;
    private Size size;

    public Product(int id, Model model, Size size) {
      super(id);
        this.model = model;
        this.size = size;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice(){
        return model.getPrice();
    }
}
