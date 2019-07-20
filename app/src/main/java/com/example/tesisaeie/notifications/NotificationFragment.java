package com.example.tesisaeie.notifications;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.example.tesisaeie.R;
import com.example.tesisaeie.api.ApiClient;
import com.example.tesisaeie.api.ApiInterface;
import com.example.tesisaeie.courses.Course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationFragment extends Fragment{
    private static final String TAG = NotificationFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private AnuncioAdapter anuncioAdapter;
    private List<Anuncio> anunciosList;

    public NotificationFragment() {
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
        View root = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = root.findViewById(R.id.recycler_notification);
        anunciosList = new ArrayList<>();
        anuncioAdapter= new AnuncioAdapter(anunciosList,getActivity());
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(anuncioAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        anuncioAdapter.setListener(new AnuncioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(),NotificationActivity.class);
                intent.putExtra("ad", anunciosList.get(position));
                startActivity(intent);
            }
        });

        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<List<Anuncio>> call = apiInterface.getAds();
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                anunciosList= response.body();
                anuncioAdapter.changeData(anunciosList);
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
        return root;
    }
}
