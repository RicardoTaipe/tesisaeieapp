package com.example.tesisaeie.products;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tesisaeie.R;
import com.example.tesisaeie.api.ApiClient;
import com.example.tesisaeie.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {
    private static final String TAG = ProductFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Product> productsList;
    private ProgressBar loader;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView = root.findViewById(R.id.recycler_product);
        loader = root.findViewById(R.id.progressBarProduct);
        productsList = new ArrayList<>();
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);
        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ProductAdapter(productsList,getActivity()));
        recyclerView.setNestedScrollingEnabled(false);


        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Product>> call = apiInterface.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                loader.setVisibility(View.GONE);
                productsList.clear();
                productsList= response.body();
                recyclerView.setAdapter(new ProductAdapter(productsList,getActivity()));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                loader.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(),"Se produjo un error", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });
        return root;
    }

}
