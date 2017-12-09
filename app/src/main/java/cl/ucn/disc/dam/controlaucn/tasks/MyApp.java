package cl.ucn.disc.dam.controlaucn.tasks;

import android.app.Application;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import cl.ucn.disc.dam.controlaucn.dao.DataBase;

/**
 * Created by Diego Saavedra on 09-12-2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // DBFLow
        {
            // Initialize DBFLow
            FlowManager.init(FlowConfig.builder(this)
                    .addDatabaseConfig(DatabaseConfig.builder(DataBase.class).databaseName("vehiclestore").build())
                    // .openDatabasesOnInit(true)
                    .build()
            );
        }
    }
}
