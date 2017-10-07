package pe.edu.upc.appbarman.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.adapters.SalesOrderDetailAdapter;
import pe.edu.upc.appbarman.fragments.MainDetailActivityFragment;
import pe.edu.upc.appbarman.models.SalesOrderDetail;

public class MainDetailActivity extends AppCompatActivity {
    private String orderid;

    public String getOrderId() {
        return orderid;
    }
    public String setOrderId(String orderid) {
        this.orderid = orderid;
        return orderid;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Log.d("SEGUIMIENTO","GetStringExtra OrderId: " + intent.getStringExtra("orderId"));
        setOrderId(intent.getStringExtra("orderId"));

        setContentView(R.layout.activity_maindetail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




    }

}
