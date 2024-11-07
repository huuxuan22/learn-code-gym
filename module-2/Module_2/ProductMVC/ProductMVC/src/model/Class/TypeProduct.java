package model.Class;

public class TypeProduct {
    protected int id;
    protected String name;
    protected String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeProduct(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public TypeProduct(){

    }

    @Override
    public String toString() {
        return "TypeProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}