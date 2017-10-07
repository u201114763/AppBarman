package pe.edu.upc.appbarman.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.activities.MainDetailActivity;
import pe.edu.upc.appbarman.models.SalesOrder;
import pe.edu.upc.appbarman.models.SalesOrderDetail;
import pe.edu.upc.appbarman.network.NewsApiService;

/**
 * Created by Manuel on 4/10/2017.
 */

public class SalesOrderAdapter extends RecyclerView.Adapter<SalesOrderAdapter.ViewHolder>{
    private List<SalesOrder> salesOrders;
    public SalesOrderAdapter(List<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    public SalesOrderAdapter() {
    }

    @Override
    public SalesOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.card_salesorder, parent, false));
    }

    @Override
    public void onBindViewHolder(SalesOrderAdapter.ViewHolder holder, final int position) {
        final SalesOrder source = salesOrders.get(position);

        holder.idTextView.setText(source.getId());
        holder.userIdTextView.setText(source.getUserId());
        holder.orderdateTextView.setText(source.getOrderDate());
        holder.waittimerTextView.setText(source.getWaitTime());
        holder.salesorderCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", source.getId());
                Intent detailIntent = new Intent(view.getContext(),MainDetailActivity.class);
                detailIntent.putExtras(bundle);
                view.getContext().startActivity(detailIntent);
            }
        });
        holder.anularTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Start Anular Activity
                AnularSalesOrder(source.getId());
            }
        });

        holder.atendidoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Start Atendido Articles Activity
                AtendidoSalesOrder(source);
            }
        });


    }

    @Override
    public int getItemCount() {
        return salesOrders.size();
    }


    public List<SalesOrder> getSalesOrder() {
        return salesOrders;
    }

    public SalesOrderAdapter setSalesOrder(List<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView salesorderCardView;
        TextView idTextView;
        TextView userIdTextView;
        TextView orderdateTextView;
        TextView waittimerTextView;
        TextView anularTextView;
        TextView atendidoTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            salesorderCardView = (CardView) itemView.findViewById(R.id.salesorderCardView);
            idTextView = (TextView) itemView.findViewById(R.id.idTextView);
            userIdTextView = (TextView) itemView.findViewById(R.id.userIdTextView);
            orderdateTextView = (TextView) itemView.findViewById(R.id.orderdateTextView);
            waittimerTextView = (TextView) itemView.findViewById(R.id.waittimerTextView);
            anularTextView = (TextView) itemView.findViewById(R.id.anularTextView);
            atendidoTextView = (TextView) itemView.findViewById(R.id.atendidoTextView);
        }
    }


    private void AnularSalesOrder(final String orderid) {
        Log.d("SEGUIMIENTO","Se Anulara Pedido: " + orderid);

        AndroidNetworking.delete(NewsApiService.ANULARSALESORDERURL +"/{orderId}")
                .addPathParameter("orderId", orderid)
                .setPriority(Priority.LOW)
                .setTag(R.string.app_name)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener()  {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("SEGUIMIENTO","Se ANULO Pedido: " + orderid);
                    }


                    @Override
                    public void onError(ANError anError) {
                        Log.d(String.valueOf(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }

    private void AtendidoSalesOrder(final SalesOrder salesOrder) {
        salesOrder.setAttentionTime("15:00");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", salesOrder.getId());
            jsonObject.put("pubId", salesOrder.getPubId());
            jsonObject.put("userId", salesOrder.getUserId());
            jsonObject.put("OrderDate", salesOrder.getOrderDate());
            jsonObject.put("status", salesOrder.getStatus());
            jsonObject.put("waitTime", salesOrder.getWaitTime());
            jsonObject.put("attentionTime", "20:00");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("SEGUIMIENTO","Se Atendera Pedido: " + salesOrder.getId());

        AndroidNetworking.put(NewsApiService.SALESORDER_URL)
                .addJSONObjectBody(jsonObject)
                .setPriority(Priority.LOW)
                .setTag(R.string.app_name)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener()  {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("SEGUIMIENTO","Se Atendio Pedido: " + salesOrder.getId());
                    }


                    @Override
                    public void onError(ANError anError) {
                        Log.d(String.valueOf(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }

}
