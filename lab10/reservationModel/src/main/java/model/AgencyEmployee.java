package model;

public class AgencyEmployee implements HasID<String> {
    private String id;
    private String username;
    private String password;

    public AgencyEmployee(String id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }


    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String newID) {
        id=newID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
