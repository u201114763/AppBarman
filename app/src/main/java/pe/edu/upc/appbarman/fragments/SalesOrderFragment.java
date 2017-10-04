package pe.edu.upc.appbarman.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.adapters.SalesOrderAdapter;
import pe.edu.upc.appbarman.models.SalesOrder;
import pe.edu.upc.appbarman.network.NewsApiService;

/**
 * Created by Manuel on 4/10/2017.
 */

public class SalesOrderFragment extends Fragment {
    RecyclerView salesorderRecyclerView;
    RecyclerView.LayoutManager salesorderLayoutManager;
    SalesOrderAdapter salesorderAdapter;
    List<SalesOrder> salesOrders;



    public SalesOrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        salesorderRecyclerView = (RecyclerView) view.findViewById(R.id.salesorderRecyclerView);
        salesOrders = new ArrayList<>();
        salesorderAdapter = new SalesOrderAdapter(salesOrders);
        salesorderLayoutManager = new GridLayoutManager(view.getContext(), 2);
        salesorderRecyclerView.setAdapter(salesorderAdapter);
        salesorderRecyclerView.setLayoutManager(salesorderLayoutManager);
        updateSources();
        return view;
    }


    private void updateSources() {
        Log.d("SEGUIMIENTO","ENTRO AL NETWORKINGGGGGGGGGG");
        AndroidNetworking.get(NewsApiService.SOLESORDER_URL+"?Gbusqueda=1&Gvalor=&Gfecha=20171003&Glocal=1")
                //.addQueryParameter("language", "en")
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("SEGUIMIENTO","ENTRO AL RESPONSE");
                            if ("error".equalsIgnoreCase(response.getString("status"))) {
                                Log.d(getString(R.string.app_name), response.getString("message"));
                                return;
                            }

                            salesOrders = SalesOrder.from(response.getJSONArray(""));
                            salesorderAdapter.setSalesOrder(salesOrders);
                            salesorderAdapter.notifyDataSetChanged();
                        }
                        catch (JSONException e) {
                            Log.d(getString(R.string.app_name), e.getMessage());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(getString(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }

}
