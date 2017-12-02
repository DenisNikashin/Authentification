package authentification.model;

public class User {
    private int id;
    private String login;
    private String password;
    private ROLE role;

    public User() {
    }

    public User(String login, int id, ROLE role, String password) {
        this.login = login;
        this.id = id;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum ROLE {
        USER, ADMIN, ANON
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }
}
