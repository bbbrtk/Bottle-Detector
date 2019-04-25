package com.google.sample.cloudvision;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.google.sample.cloudvision.dao.BottleDAO;
import com.google.sample.cloudvision.models.Bottle;

@Database(entities = {Bottle.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract BottleDAO getBottleDAO();
}
