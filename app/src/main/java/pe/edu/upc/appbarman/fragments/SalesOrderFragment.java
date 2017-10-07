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
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.activities.MainActivity;
import pe.edu.upc.appbarman.adapters.SalesOrderAdapter;
import pe.edu.upc.appbarman.models.SalesOrder;
import pe.edu.upc.appbarman.models.User;
import pe.edu.upc.appbarman.network.NewsApiService;

/**
 * Created by Manuel on 4/10/2017.
 */

public class SalesOrderFragment extends Fragment {
    RecyclerView salesorderRecyclerView;
    RecyclerView.LayoutManager salesorderLayoutManager;
    SalesOrderAdapter salesorderAdapter;
    List<SalesOrder> salesOrders;

    public final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();

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
        salesorderLayoutManager = new GridLayoutManager(view.getContext(), 1);
        salesorderRecyclerView.setAdapter(salesorderAdapter);
        salesorderRecyclerView.setLayoutManager(salesorderLayoutManager);
        updateSalesOrder();

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                Log.d(getString(R.string.app_name), "Mensaje");
                updateSalesOrder();
            }
        };
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(r, 10, 10, TimeUnit.SECONDS);

        return view;
    }


    private void updateSalesOrder() {

        /*SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        java.util.Date date = new java.util.Date();
        Log.d("SEGUIMIENTO","ENTRO AL NETWORKINGGGGGGGGGG "+ DATE_FORMAT.format(date).toString());*/

        String Gbusqueda = "3";
        //String Gfecha = DATE_FORMAT.format(date).toString();
        String Gfecha ="";
        String Gvalor = "1";
        String Glocal = "1";

        AndroidNetworking.get(NewsApiService.SALESORDER_URL +"?Gbusqueda="+Gbusqueda+"&Gvalor="+Gvalor+"&Gfecha="+Gfecha+"&Glocal="+Glocal)
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsObjectList(SalesOrder.class,new ParsedRequestListener<List<SalesOrder>>()  {
                    @Override
                    public void onResponse(List<SalesOrder> salesOrders1) {

                       /* Log.d("SEGUIMIENTO","Numero de Pedidos:: " + salesOrders1.size());
                        for (SalesOrder user : salesOrders1) {
                            Log.d("SEGUIMIENTO", "id : " + user.getId().toString());

                        }*/

                        salesOrders = salesOrders1;
                        salesorderAdapter.setSalesOrder(salesOrders);
                        salesorderAdapter.notifyDataSetChanged();
                    }


                    @Override
                    public void onError(ANError anError) {
                        Log.d(getString(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }



}
