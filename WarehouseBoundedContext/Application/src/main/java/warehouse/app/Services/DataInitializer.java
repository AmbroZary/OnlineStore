package warehouse.app.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Factory.CategoryFactory;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Factory.ProductFactory;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Repository.CategoryRepository;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import warehouse.domain.ProductAggregate.Size;
import warehouse.infrastructure.Services.ImageProcessor;

import java.io.IOException;
import java.util.LinkedList;

@Component
public class DataInitializer {

    private ModelRepository modelRepository;

    private ModelFactory modelFactory;

    private CategoryRepository categoryRepository;

    private CategoryFactory categoryFactory;

    private ProductFactory productFactory;

    private ProductRepository productRepository;

    private ImageProcessor imageProcessor;

    @Autowired
    public DataInitializer(ModelRepository modelRepository, ModelFactory modelFactory, CategoryRepository categoryRepository,
                           CategoryFactory categoryFactory, ProductFactory productFactory, ProductRepository productRepository,
                           ImageProcessor imageProcessor) {
        this.modelRepository = modelRepository;
        this.modelFactory = modelFactory;
        this.categoryRepository = categoryRepository;
        this.categoryFactory = categoryFactory;
        this.productFactory = productFactory;
        this.productRepository = productRepository;
        this.imageProcessor = imageProcessor;
    }

    public void initializeData() throws IOException{
        Category tshirts = categoryFactory.createCategory("T-shirts");
        Category hoodie = categoryFactory.createCategory("Hoodies");
        Category pants = categoryFactory.createCategory("Pants");
        Category hats = categoryFactory.createCategory("Hats");
        Category jackets = categoryFactory.createCategory("Jackets");

        //Create White T-Shirt
        byte[] image = imageProcessor.loadImageFromFileToByteArray("E:\\Dokumenty\\WAŻNE\\Licencjat\\Projekt\\ClientBoundedContext\\tshirt.jpg");
        AdditionalModelInfo whiteColor = new AdditionalModelInfo("color", "white");
        AdditionalModelInfo fittedStyle = new AdditionalModelInfo("style", "fitted");
        LinkedList<AdditionalModelInfo> whiteTShirtAddInfo = new LinkedList<>();
        whiteTShirtAddInfo.add(whiteColor);
        whiteTShirtAddInfo.add(fittedStyle);
        Model whiteTShirt = modelFactory.createModel("White T-Shirt", image,10.0,tshirts, whiteTShirtAddInfo);
        productFactory.createProduct(whiteTShirt, Size.S);
        productFactory.createProduct(whiteTShirt, Size.S);
        productFactory.createProduct(whiteTShirt, Size.S);
        productFactory.createProduct(whiteTShirt, Size.L);
        productFactory.createProduct(whiteTShirt, Size.L);
        productFactory.createProduct(whiteTShirt, Size.XXl);
        productFactory.createProduct(whiteTShirt, Size.XL);
        productFactory.createProduct(whiteTShirt, Size.XL);
        productFactory.createProduct(whiteTShirt, Size.XL);
        productFactory.createProduct(whiteTShirt, Size.M);
        productFactory.createProduct(whiteTShirt, Size.M);

        //Create Black T-Shirt
        image = imageProcessor.loadImageFromFileToByteArray("E:\\Dokumenty\\WAŻNE\\Licencjat\\Projekt\\ClientBoundedContext\\tshirt.jpg");
        AdditionalModelInfo blackColor = new AdditionalModelInfo("color", "white");
        LinkedList<AdditionalModelInfo> blackTShirtAddInfo = new LinkedList<>();
        whiteTShirtAddInfo.add(blackColor);
        whiteTShirtAddInfo.add(fittedStyle);
        Model blackTShirt = modelFactory.createModel("Black T-Shirt", image,10.0,tshirts, blackTShirtAddInfo);
        productFactory.createProduct(blackTShirt, Size.S);
        productFactory.createProduct(blackTShirt, Size.S);
        productFactory.createProduct(blackTShirt, Size.S);
        productFactory.createProduct(blackTShirt, Size.L);
        productFactory.createProduct(blackTShirt, Size.L);
        productFactory.createProduct(blackTShirt, Size.XXl);
        productFactory.createProduct(blackTShirt, Size.XXXl);
        productFactory.createProduct(blackTShirt, Size.XXXXL);
        productFactory.createProduct(blackTShirt, Size.XL);
        productFactory.createProduct(blackTShirt, Size.XL);
        productFactory.createProduct(blackTShirt, Size.XL);
        productFactory.createProduct(blackTShirt, Size.M);
        productFactory.createProduct(blackTShirt, Size.M);

        //Create Red T-Shirt
        image = imageProcessor.loadImageFromFileToByteArray("E:\\Dokumenty\\WAŻNE\\Licencjat\\Projekt\\ClientBoundedContext\\tshirt.jpg");
        AdditionalModelInfo redColor = new AdditionalModelInfo("color", "red");
        AdditionalModelInfo looseStyle = new AdditionalModelInfo("style", "loose");
        LinkedList<AdditionalModelInfo> redTShirtAddInfo = new LinkedList<>();
        whiteTShirtAddInfo.add(blackColor);
        whiteTShirtAddInfo.add(fittedStyle);
        Model redTShirt = modelFactory.createModel("Red T-Shirt",image,10.0,tshirts, blackTShirtAddInfo);
        productFactory.createProduct(redTShirt, Size.S);
        productFactory.createProduct(redTShirt, Size.L);
        productFactory.createProduct(redTShirt, Size.L);
        productFactory.createProduct(redTShirt, Size.XXl);
        productFactory.createProduct(redTShirt, Size.XXXl);
        productFactory.createProduct(redTShirt, Size.XXXXL);
        productFactory.createProduct(redTShirt, Size.XL);
        productFactory.createProduct(redTShirt, Size.XL);
        productFactory.createProduct(redTShirt, Size.XL);
    }
}
