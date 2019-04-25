package com.google.sample.cloudvision.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "bottles")
public class Bottle {

    @PrimaryKey
    @NonNull
    private Long id;

    private String name;
    private String logo;
    private String labelNames;
    private String labelScores;

    @NonNull
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getLabelNames() {
        return labelNames;
    }

    public String getLabelScores() {
        return labelScores;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setLabelNames(String labelNames) {
        this.labelNames = labelNames;
    }

    public void setLabelScores(String labelScores) {
        this.labelScores = labelScores;
    }
}
