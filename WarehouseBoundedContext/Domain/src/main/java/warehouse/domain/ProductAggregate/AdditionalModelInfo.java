package warehouse.domain.ProductAggregate;

import common.Interfaces.Entity;

import java.util.HashMap;

public class AdditionalModelInfo extends Entity{
    private String attribute;
    private String value;

    public AdditionalModelInfo(int id, String attribute, String value) {
        super(id);
        this.attribute = attribute;
        this.value = value;
    }

    public AdditionalModelInfo(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public AdditionalModelInfo() {
    }

    public String getAttribute() {

        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
