package client.domain.Aggregates.ProductAggregate;


public class Category {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    private String Name;
    private AdditionalInfo additionalInfo;

    public Category(String name, AdditionalInfo additionalInfo) {
        Name = name;
        this.additionalInfo = additionalInfo;
    }
}
