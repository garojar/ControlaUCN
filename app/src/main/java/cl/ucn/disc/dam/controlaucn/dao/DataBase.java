package cl.ucn.disc.dam.controlaucn.dao;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Diego Saavedra and German Rojo on 07-12-2017.
 */

@Database(name = DataBase.NAME, version = DataBase.VERSION)
public class DataBase {


    /**
     * VERSION
     */
    public static final String NAME= "MyDataBase";
    public static final int VERSION=1;
}