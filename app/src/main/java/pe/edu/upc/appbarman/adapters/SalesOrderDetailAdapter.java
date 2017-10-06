package pe.edu.upc.appbarman.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.models.SalesOrderDetail;

/**
 * Created by Manuel on 6/10/2017.
 */

public class SalesOrderDetailAdapter extends RecyclerView.Adapter<SalesOrderDetailAdapter.ViewHolder>{
    private List<SalesOrderDetail> salesOrderDetails;


    public SalesOrderDetailAdapter(List<SalesOrderDetail> salesOrderDetails) {
        this.salesOrderDetails = salesOrderDetails;
    }

    public SalesOrderDetailAdapter() {
    }


    @Override
    public SalesOrderDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_salesorderdetail, parent, false));
    }

    @Override
    public void onBindViewHolder(SalesOrderDetailAdapter.ViewHolder holder, final int position) {
        SalesOrderDetail salesOrderDetail = salesOrderDetails.get(position);
        holder.pictureANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.pictureANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        //holder.pictureANImageView.setImageUrl(salesOrderDetail.getUrlToImage());
        holder.productoTextView.setText(salesOrderDetail.getProductId());
        holder.priceTextView.setText(salesOrderDetail.getUnitPrice());
        holder.qualityTextView.setText(salesOrderDetail.getQuantity());
    }

    @Override
    public int getItemCount() {
        return salesOrderDetails.size();
    }


    public List<SalesOrderDetail> getSalesOrderDetail() {
        return salesOrderDetails;
    }

    public SalesOrderDetailAdapter setSalesOrderDetail(List<SalesOrderDetail> salesOrderDetail) {
        this.salesOrderDetails = salesOrderDetail;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView salesorderdetailCardView;
        TextView productoTextView;
        TextView priceTextView;
        TextView qualityTextView;
        ANImageView pictureANImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            salesorderdetailCardView = (CardView) itemView.findViewById(R.id.salesorderdetailCardView);
            pictureANImageView = (ANImageView) itemView.findViewById(R.id.pictureImageView);
            productoTextView = (TextView) itemView.findViewById(R.id.productoTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
            qualityTextView = (TextView) itemView.findViewById(R.id.qualityTextView);

        }
    }
}
