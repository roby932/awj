package hello;

public class User {

    private final long id;
    private String name;
    private int stock;

    public User(long id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getstock() {
        return stock;
    }

    public void setname(String param) {
        this.name = param;
    }

    public void setstock(int param) {
        this.stock = param;
    }
}
