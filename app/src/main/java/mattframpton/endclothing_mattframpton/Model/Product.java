package mattframpton.endclothing_mattframpton.Model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Product {

    @Expose
    private String id;
    @Expose
    private String image;
    @Expose
    private String name;
    @Expose
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
