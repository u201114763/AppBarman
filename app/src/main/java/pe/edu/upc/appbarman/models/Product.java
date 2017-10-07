package pe.edu.upc.appbarman.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 4/10/2017.
 */

public class Product {
    private String id;
    private String name;
    private String description;
    private String price;
    private String type;
    private String image;
    private String overallTime;
    private Pub pub;

    public void setPub(Pub pub) {
        this.pub = pub;
    }


    public Product() {
    }

    public Product(String id, String name, String description, String price, String type, String image, String overallTime, Pub pub) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.image = image;
        this.overallTime = overallTime;
        this.pub = pub;
    }


    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Product setImage(String image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getOverallTime() {
        return overallTime;
    }

    public Product setOverallTime(String overallTime) {
        this.overallTime = overallTime;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Product setPrice(String price) {
        this.price = price;
        return this;
    }

    public Pub getPub() {
        return pub;
    }



    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }
    public String getType() {
        return type;
    }

    public Product setType(String type) {
        this.type = type;
        return this;
    }



}
