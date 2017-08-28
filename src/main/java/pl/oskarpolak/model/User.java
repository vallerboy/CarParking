package pl.oskarpolak.model;

/**
 * Created by Lenovo on 28.08.2017.
 */
public class User {
    private String name;
    private String password;
    private String lastname;
    private String number;
    private String email;

    public User(String name, String password, String lastname, String number, String email) {
        this.name = name;
        this.password = password;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
