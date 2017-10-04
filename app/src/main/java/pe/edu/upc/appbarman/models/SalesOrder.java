package pe.edu.upc.appbarman.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Manuel on 4/10/2017.
 */

public class SalesOrder {

    private String id;
    private String userId;
    private String pubId;
    private String orderDate;
    private String status;
    private String waitTime;
    private String attentionTime;

    public SalesOrder() {
    }

    public SalesOrder(String id, String userId, String pubId, String orderDate, String status, String waitTime, String attentionTime) {
        this.id = id;
        this.userId = userId;
        this.pubId = pubId;
        this.orderDate = orderDate;
        this.status = status;
        this.waitTime = waitTime;
        this.attentionTime = attentionTime;
    }

    public String getId() {
        return id;
    }

    public SalesOrder setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public SalesOrder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getPubId() {
        return pubId;

    }

    public SalesOrder setPubId(String pubId) {
        this.pubId = pubId;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public SalesOrder setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SalesOrder setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public SalesOrder setWaitTime(String waitTime) {
        this.waitTime = waitTime;
        return this;
    }

    public String getAttentionTime() {
        return attentionTime;
    }

    public SalesOrder setAttentionTime(String attentionTime) {
        this.attentionTime = attentionTime;
        return this;
    }
/*
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("userId", userId);
        bundle.putString("pubId", pubId);
        bundle.putString("orderDate", orderDate);
        bundle.putString("status", status);
        bundle.putString("waitTime", waitTime);
        bundle.putString("attentionTime", attentionTime);
        return bundle;
    }

    public static SalesOrder from(Bundle bundle) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setId(bundle.getString("id"))
                .setUserId(bundle.getString("userId"))
                .setPubId(bundle.getString("pubId"))
                .setOrderDate(bundle.getString("orderDate"))
                .setStatus(bundle.getString("status"))
                .setWaitTime(bundle.getString("waitTime"))
                .setAttentionTime(bundle.getString("attentionTime"))
        return salesOrder;
    }*/

    public static SalesOrder from(JSONObject jsonSource) {
        SalesOrder salesOrder = new SalesOrder();
        try {
            salesOrder.setId(jsonSource.getString("id"))
                    .setUserId(jsonSource.getString("userId"))
                    .setPubId(jsonSource.getString("pubId"))
                    .setOrderDate(jsonSource.getString("orderDate"))
                    .setStatus(jsonSource.getString("status"))
                    .setWaitTime(jsonSource.getString("waitTime"))
                    .setAttentionTime(jsonSource.getString("attentionTime"));
            return salesOrder;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return salesOrder;
    }

    public static List<SalesOrder> from(JSONArray jsonSalesOrder) {
        List<SalesOrder> salesOrders = new ArrayList<>();
        for(int i = 0; i < jsonSalesOrder.length(); i++)
            try {
                salesOrders.add(SalesOrder.from(jsonSalesOrder.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return salesOrders;
    }
}
