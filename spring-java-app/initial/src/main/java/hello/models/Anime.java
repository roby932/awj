package hello;

public class Anime {

    private final long id;
    private String name;
    private int numberOfEp;

    public Anime(long id, String name, int numberOfEp) {
        this.id = id;
        this.name = name;
        this.numberOfEp = numberOfEp;
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getnumberOfEp() {
        return numberOfEp;
    }

    public void setname(String param) {
        this.name = param;
    }

    public void setnumberOfEp(int param) {
        this.numberOfEp = param;
    }
}
