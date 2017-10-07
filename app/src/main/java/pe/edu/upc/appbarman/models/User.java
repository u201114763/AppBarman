package pe.edu.upc.appbarman.models;

/**
 * Created by Manuel on 6/10/2017.
 */

public class User {
    private String documentNumber;
    private String email;
    private String firstName;
    private String fullName;
    private String id;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String postDate;
    private String type;


    public User(String documentNumber, String email, String firstName, String fullName, String id, String lastName, String password, String phoneNumber, String postDate, String type) {
        this.documentNumber = documentNumber;
        this.email = email;
        this.firstName = firstName;
        this.fullName = fullName;
        this.id = id;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.postDate = postDate;
        this.type = type;
    }

    public User() {
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public User setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getPostDate() {
        return postDate;
    }

    public User setPostDate(String postDate) {
        this.postDate = postDate;
        return this;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }
}
