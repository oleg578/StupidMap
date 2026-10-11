public class Entity {
    private final String key;
    private String value;

    public Entity(String name, String description) {
        this.key = name;
        this.value = description;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
