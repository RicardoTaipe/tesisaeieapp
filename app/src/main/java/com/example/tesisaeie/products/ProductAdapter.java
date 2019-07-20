package com.example.tesisaeie.products;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tesisaeie.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> products;
    private Context context;

    public ProductAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductAdapter.ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_item, viewGroup,false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductHolder productHolder, int i) {
        productHolder.name.setText(products.get(i).getName());
        productHolder.price.setText("$ "+products.get(i).getPrice().toString());
        productHolder.stock.setText("stock: "+products.get(i).getStock().toString());
    }

    @Override
    public int getItemCount() {
        if(products.size() != 0){
            return products.size();
        }
        return 0;
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        TextView name,price,stock;

        public ProductHolder(@NonNull View itemView) {

            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            price=(TextView) itemView.findViewById(R.id.precio);
            stock=(TextView) itemView.findViewById(R.id.stock);
        }
    }
}
