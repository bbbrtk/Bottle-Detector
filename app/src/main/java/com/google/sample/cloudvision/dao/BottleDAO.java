package com.google.sample.cloudvision.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.google.sample.cloudvision.models.Bottle;

import java.util.List;

@Dao
public interface BottleDAO {
    @Insert
    public void insert(Bottle bottle);
    @Update
    public void update(Bottle bottle);
    @Delete
    public void delete(Bottle item);

    @Query("SELECT * FROM bottles")
    public List<Bottle> getBottlesAll();

    @Query("SELECT name FROM bottles")
    public String getBottleNames();

    @Query("SELECT id, name, labelNames, labelScores FROM bottles")
    public List<Bottle> getBottleNamesAndLabels();

    @Query("SELECT * FROM bottles WHERE id = :id")
    public Bottle getBottleById(Long id);
}
