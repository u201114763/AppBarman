package pe.edu.upc.appbarman.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.models.SalesOrder;

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
    public void onBindViewHolder(SalesOrderAdapter.ViewHolder holder, int position) {
        final SalesOrder source = salesOrders.get(position);

        holder.idTextView.setText(source.getId());
        holder.userIdTextView.setText(source.getUserId());
        holder.orderdateTextView.setText(source.getOrderDate());
        holder.waittimerTextView.setText(source.getWaitTime());
        holder.aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Start About Source Activity
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
        TextView idTextView;
        TextView userIdTextView;
        TextView orderdateTextView;
        TextView waittimerTextView;
        TextView aboutTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            idTextView = (TextView) itemView.findViewById(R.id.idTextView);
            userIdTextView = (TextView) itemView.findViewById(R.id.userIdTextView);
            orderdateTextView = (TextView) itemView.findViewById(R.id.orderdateTextView);
            waittimerTextView = (TextView) itemView.findViewById(R.id.waittimerTextView);
            aboutTextView = (TextView) itemView.findViewById(R.id.aboutTextView);
        }
    }
}
