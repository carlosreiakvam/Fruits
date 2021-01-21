import java.io.Serializable;

public class Fruit implements Serializable {
    private String name;

    Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
