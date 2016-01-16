package hello;

public class User {

    private final long id;
    private String name;
    private String hobby;

    public User(long id, String name, String hobby) {
        this.id = id;
        this.name = name;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String gethobby() {
        return hobby;
    }

    public void setname(String param) {
        this.name = param;
    }

    public void sethobby(String param) {
        this.hobby = param;
    }
}
