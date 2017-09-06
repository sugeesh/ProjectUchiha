package lk.aduwata.resource;

/**
 * @author Sugeesh Chandraweera
 */
public class AdDetailResource {
    private String key;
    private String value;

    public AdDetailResource() {
    }

    public AdDetailResource(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
