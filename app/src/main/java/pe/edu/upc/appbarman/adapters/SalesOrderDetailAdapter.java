package pe.edu.upc.appbarman.adapters;

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
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.widget.ANImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pe.edu.upc.appbarman.R;
import pe.edu.upc.appbarman.models.Product;
import pe.edu.upc.appbarman.models.SalesOrderDetail;
import pe.edu.upc.appbarman.models.User;
import pe.edu.upc.appbarman.network.NewsApiService;

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

        ObtenerProducto(salesOrderDetail.getProductId(), holder);
        //holder.productoTextView.setText(salesOrderDetail.getProductId());
        holder.priceTextView.setText((" Precio: "+salesOrderDetail.getUnitPrice()));
        holder.qualityTextView.setText((" Cantidad: "+salesOrderDetail.getQuantity()));
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
        TextView productoDescriptionTextView;
        ANImageView pictureANImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            salesorderdetailCardView = (CardView) itemView.findViewById(R.id.salesorderdetailCardView);
            pictureANImageView = (ANImageView) itemView.findViewById(R.id.pictureImageView);
            productoTextView = (TextView) itemView.findViewById(R.id.productoTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
            qualityTextView = (TextView) itemView.findViewById(R.id.qualityTextView);
            productoDescriptionTextView = (TextView) itemView.findViewById(R.id.productoDescriptionTextView);

        }
    }

    public void ObtenerProducto(String idproducto, final ViewHolder holder) {

        AndroidNetworking.get(NewsApiService.PRODUCTO_URL + "?ProductId={idproduct}")
                .addPathParameter("idproduct", idproducto)
                .setPriority(Priority.LOW)
                .setTag(R.string.app_name)
                .build()
                .getAsObjectList(Product.class,new ParsedRequestListener<List<Product>>()  {
                    @Override
                    public void onResponse(List<Product> product) {
                        holder.productoTextView.setText((" Nombre: " + product.get(0).getName()));
                        holder.productoDescriptionTextView.setText((" Descripcion: " + product.get(0).getDescription()));
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(String.valueOf(R.string.app_name), anError.getLocalizedMessage());

                    }
                });

    }
}
