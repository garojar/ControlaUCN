package cl.ucn.disc.dam.controlaucn.dao;

import android.content.Context;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Germán Rojo on 27-12-2017.
 */

@com.raizlabs.android.dbflow.annotation.Database(name = AppDataBase.NAME, version = AppDataBase.VERSION)
public final class AppDataBase {
    /**
     * Key de la base de datos
     */
    public static final String NAME = "Database";

    /**
     * Version de la BD
     */
    public static final int VERSION = 2;

    /**
     * Tamanio del cache
     */
    public static final int CACHE_SIZE = 100;


    /**
     * Initialize DB flow
     */
    public static void initialize(final Context context) {

        // Initialize DBFLow
        FlowManager.init(FlowConfig
                .builder(context)
                .addDatabaseConfig(DatabaseConfig
                        .builder(AppDataBase.class)
                        .databaseName("database")
                        .build())
                // .openDatabasesOnInit(true)
                .build()
        );

    }
}
