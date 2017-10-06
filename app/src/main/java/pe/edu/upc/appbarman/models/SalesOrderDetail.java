package pe.edu.upc.appbarman.models;

/**
 * Created by Manuel on 6/10/2017.
 */

public class SalesOrderDetail {
    private String id;
    private String orderId;
    private String productId;
    private String unitPrice;
    private String quantity;


    public SalesOrderDetail() {
    }

    public SalesOrderDetail(String id, String orderId, String productid, String quantity, String unitPrice) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productid;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
