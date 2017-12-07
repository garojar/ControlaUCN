package cl.ucn.disc.dam.controlaucn.activities;

import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.adapters.VehiculoAdapter;
import cl.ucn.disc.dam.controlaucn.model.Persona;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;

public class MainActivity extends ListActivity  {
    /**
     * Adapter de {@link cl.ucn.disc.dam.controlaucn.model.Vehiculo}
     */
    private BaseAdapter vehiculoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_vehiculo);

        //inicializacion de la base de datos
        {
            FlowManager.init(new FlowConfig.Builder(getApplicationContext())
                    .openDatabasesOnInit(true)
                    .build());
        }

        //Vemos si la base de datos ya tiene oraciones
        List<Vehiculo> vehiculoList = SQLite.select().from(Vehiculo.class).queryList();
        if (vehiculoList.size() == 0) {
            Persona p = Persona.builder().correo("dst005@alumnos.ucn.cl").nombre("Diego Saavedra Tapia").numCelular("962044443").rut("18.741.730-9").build();
            Vehiculo v = Vehiculo.builder().color("rojo").dueño(p).marca("Kia").modelo("Frontier").patente("HH-12-EW").year("2000").nota("camion de carga 3/4").build();
            p.save();
            v.save();
        }

        List<Vehiculo> ListaDeVehiculos = SQLite.select().from(Vehiculo.class).queryList();

        int cantidad = ListaDeVehiculos.size();



        Log.d(ListaDeVehiculos.get(0).getDueño().getNombre(),"sapbee");



            // Row division
        int[] colors = {0, 0xFFFF0000, 0};
        this.getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        this.getListView().setDividerHeight(5);

        this.vehiculoAdapter =  new VehiculoAdapter(this);
        super.setListAdapter(this.vehiculoAdapter);

    }
}
