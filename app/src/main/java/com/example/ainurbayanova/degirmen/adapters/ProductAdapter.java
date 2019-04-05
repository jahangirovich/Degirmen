package com.example.ainurbayanova.degirmen.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.models.Products;
import com.example.ainurbayanova.degirmen.views.interfaces.ClickItemInterface;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.EmployeeViewHolder> {
    ClickItemInterface clickItemInterface;
    ArrayList<Products> dataList;

    public ProductAdapter(ArrayList<Products> dataList) {
        this.dataList = dataList;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_products, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Products product = dataList.get(position);
        holder.title.setText(product.getNameOfProduct());
        Glide.with(holder.itemView)
                .load(product.getImageOfProduct())
                .into(holder.imageView);
        holder.measure.setText(product.getAmount() + " " + product.getMeasure());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView measure;
        EmployeeViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.nameOfProduct);
            measure = itemView.findViewById(R.id.measure);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItemInterface.clickItem(getAdapterPosition());
                }
            });
        }
    }

    public void setClickListener(ClickItemInterface clickItemInterface){
        this.clickItemInterface = clickItemInterface;
    }
}