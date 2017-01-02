package client.domain.Aggregates.ProductAggregate;

import java.util.HashMap;

public class AdditionalInfo {
    HashMap<String, String> attributes;

    public AdditionalInfo(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public void AddAttribute(String key, String value)
    {
        attributes.put(key, value);
    }
}
