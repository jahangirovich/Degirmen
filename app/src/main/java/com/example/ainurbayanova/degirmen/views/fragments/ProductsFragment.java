package com.example.ainurbayanova.degirmen.views.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ainurbayanova.degirmen.R;
import com.example.ainurbayanova.degirmen.adapters.ProductAdapter;
import com.example.ainurbayanova.degirmen.models.Products;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProductsFragment extends Fragment {
    View view;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;
    ProductAdapter productAdapter;
    ArrayList<Products> listOfProducts = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.products_fragment,container,false);
        unbinder = ButterKnife.bind(this,view);
        generateListOfProducts();
        integrateAdapter();
        return view;
    }
    public void generateListOfProducts(){
        listOfProducts.add(new Products("Картошка","https://med.vesti.ru/wp-content/uploads/2017/09/potatoes-411975_1920-1.jpg",15,"кг"));
        listOfProducts.add(new Products("Перец","https://images.aif.ru/013/386/cdb577cef3ad71f46181b6afbdbaad29.jpg",20,"kg"));
        listOfProducts.add(new Products("Мясо","https://cdn.the-village.ru/the-village.ru/post-cover/FaKd40e4UuBS76d9BG_sHw-default.jpg",90,"kg"));
    }
    public void integrateAdapter(){
        productAdapter = new ProductAdapter(listOfProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
