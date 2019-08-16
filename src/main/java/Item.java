public class Item {

    private String id;
    private String name;
    private String user;
    private String site;

    public Item(){}

    public Item(String id, String name, String user, String site) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.site = site;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
