package hello;

public class User {

    private final long id;
    private String name;
    private String info;

    public User(long id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getinfo() {
        return info;
    }

    public void setname(String param) {
        this.name = param;
    }

    public void setinfo(String param) {
        this.info = param;
    }
}
