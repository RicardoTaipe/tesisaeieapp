package com.example.tesisaeie.courses;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
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
import com.example.tesisaeie.products.Product;
import com.example.tesisaeie.products.ProductFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CourseFragment extends Fragment {
    private static final String TAG = ProductFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<Course> coursesList;
    private ProgressBar loader;
    public CourseFragment() {
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
        View root = inflater.inflate(R.layout.fragment_course, container, false);
        recyclerView = root.findViewById(R.id.recycler_course);
        loader = root.findViewById(R.id.progressBarCourse);
        coursesList = new ArrayList<>();
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);
        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new CourseAdapter(coursesList,getActivity()));
        recyclerView.setNestedScrollingEnabled(false);
        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Course>> call = apiInterface.getCourse();
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                loader.setVisibility(View.GONE);
                coursesList.clear();
                coursesList= response.body();
                recyclerView.setAdapter(new CourseAdapter(coursesList,getActivity()));
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                loader.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(),"Se produjo un error", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });

        return root;

    }

}
