package com.example.tesisaeie.lockers;

import com.google.gson.annotations.SerializedName;

public class Locker {
    @SerializedName("_id")
    private String id;
    @SerializedName("description")
    private String description;
    @SerializedName("state")
    private Boolean state;

    public Locker(String id, String description, Boolean state) {
        this.id = id;
        this.description = description;
        this.state = state;
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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
