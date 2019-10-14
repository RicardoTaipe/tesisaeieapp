package com.example.tesisaeie.lockers;

import com.google.gson.annotations.SerializedName;

public class Locker {
    @SerializedName("_id")
    private String id;
    @SerializedName("description")
    private String description;
    @SerializedName("free")
    private Boolean free;

    public Locker(String id, String description, Boolean free) {
        this.id = id;
        this.description = description;
        this.free = free;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
