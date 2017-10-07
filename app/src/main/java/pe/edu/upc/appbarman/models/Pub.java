package pe.edu.upc.appbarman.models;

/**
 * Created by Manuel on 7/10/2017.
 */

public class Pub {

    private String id;
    private String name;
    private String ruc;
    private String address;
    private String phoneNumber;
    private String email;
    private String description;
    private String longitude;
    private String latitude;

    public Pub() {
    }


    public Pub(String id, String name, String ruc, String address, String phoneNumber, String email, String description, String longitude, String latitude) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public Pub setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pub setName(String name) {
        this.name = name;
        return this;
    }

    public String getRuc() {
        return ruc;
    }

    public Pub setRuc(String ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Pub setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Pub setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pub setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Pub setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public Pub setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public Pub setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }
}
