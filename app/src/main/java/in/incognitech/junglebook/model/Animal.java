package in.incognitech.junglebook.model;

/**
 * Created by udit on 30/01/16.
 */
public class Animal {

    private String name;
    private String desc;
    private String imageURL;

    public Animal(String name, String desc, String imageURL) {
        this.name = name;
        this.desc = desc;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String toString() {
        return this.getName()+this.getDesc()+this.getImageURL();
    }
}
