package com.example.tesisaeie.api;

import com.example.tesisaeie.courses.Course;
import com.example.tesisaeie.lockers.Locker;
import com.example.tesisaeie.notifications.Anuncio;
import com.example.tesisaeie.products.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("locker")
    Call<List<Locker>> getLockers();
    @GET("product")
    Call<List<Product>> getProducts();
    @GET("course")
    Call<List<Course>> getCourse();
    @GET("ads")
    Call<List<Anuncio>> getAds();
}
