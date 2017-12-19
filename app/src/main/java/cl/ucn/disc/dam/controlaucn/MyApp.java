package cl.ucn.disc.dam.controlaucn;

import android.app.Application;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import cl.ucn.disc.dam.controlaucn.dao.DataBase;
import org.apache.commons.lang3.time.StopWatch;
import lombok.extern.slf4j.Slf4j;
import android.util.Log;
/**
 * Created by Diego Saavedra on 09-12-2017.
 */

@Slf4j
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Timer
        final StopWatch stopWatch = StopWatch.createStarted();

        // DBFLow
        {
            // Initialize DBFLow
            FlowManager.init(FlowConfig.builder(this)
                    .addDatabaseConfig(DatabaseConfig.builder(DataBase.class).databaseName("vehiclestore").build())
                    // .openDatabasesOnInit(true)
                    .build()
            );
        }

        // Timming
        Log.d("Initialization in: {}", stopWatch.toString());



    }
}

