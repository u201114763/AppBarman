package pe.edu.upc.appbarman.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.activities.MainDetailActivity;
import pe.edu.upc.appbarman.adapters.SalesOrderDetailAdapter;
import pe.edu.upc.appbarman.models.SalesOrderDetail;
import pe.edu.upc.appbarman.network.NewsApiService;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainDetailActivityFragment extends Fragment {

    RecyclerView salesorderDetailRecyclerView;
    RecyclerView.LayoutManager salesorderDetailLayoutManager;
    SalesOrderDetailAdapter salesorderDetailAdapter;
    List<SalesOrderDetail> salesOrderDetail;
    String orderId;

    public MainDetailActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainDetailActivity activity = (MainDetailActivity) getActivity();
        orderId = activity.getOrderId();
        Log.d("SEGUIMIENTO","Captura de OrderId: " + orderId);

        View view = inflater.inflate(R.layout.fragment_main_detail, container, false);
        salesorderDetailRecyclerView = (RecyclerView) view.findViewById(R.id.salesorderdetRecyclerView);
        salesOrderDetail = new ArrayList<>();
        salesorderDetailAdapter = new SalesOrderDetailAdapter(salesOrderDetail);
        salesorderDetailLayoutManager = new GridLayoutManager(view.getContext(), 1);
        salesorderDetailRecyclerView.setAdapter(salesorderDetailAdapter);
        salesorderDetailRecyclerView.setLayoutManager(salesorderDetailLayoutManager);
        updateSalesOrderDetail();
        return view;
    }



    private void updateSalesOrderDetail() {
        AndroidNetworking.get(NewsApiService.SALESORDERDETAILS_URL +"?orderId={orderId}")
                .addPathParameter("orderId", orderId)
                .setPriority(Priority.LOW)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsObjectList(SalesOrderDetail.class,new ParsedRequestListener<List<SalesOrderDetail>>()  {
                    @Override
                    public void onResponse(List<SalesOrderDetail> salesOrderDetail1) {

                        Log.d("SEGUIMIENTO","Numero de Detalle del Pedido: " + salesOrderDetail1.size());
                        /*for (SalesOrderDetail user : salesOrderDetail1) {
                            Log.d("SEGUIMIENTO", "producto : " + user.getProductId().toString());
                            Log.d("SEGUIMIENTO", "cantidad : " + user.getQuantity());
                        }*/

                        salesOrderDetail = salesOrderDetail1;
                        salesorderDetailAdapter.setSalesOrderDetail(salesOrderDetail);
                        salesorderDetailAdapter.notifyDataSetChanged();
                    }


                    @Override
                    public void onError(ANError anError) {
                        Log.d(getString(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }
}
