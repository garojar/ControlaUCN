package cl.ucn.disc.dam.controlaucn.activities;

import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.adapters.VehiculoAdapter;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;

public class MainActivity extends AppCompatActivity  {
    /**
     * Adapter de {@link cl.ucn.disc.dam.controlaucn.model.Vehiculo}
     */
    private BaseAdapter vehiculoAdapter;

    /**
     * Lista de vehiculos
     */
    private ListView listViewVehiculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();

        Vehiculo v = Vehiculo.builder().marca("toyota").color("negro").modelo("nose").year("2020").build();
        Vehiculo v1 = Vehiculo.builder().marca("ford").color("blanco").modelo("fiesta").year("2017").build();
        Vehiculo v2 = Vehiculo.builder().marca("hyundai").color("amarillo").modelo("santa fe").year("2019").build();
        Vehiculo v3 = Vehiculo.builder().marca("suzuki").color("azul").modelo("swift").year("2011").build();

        listVehiculo.add(v);
        listVehiculo.add(v1);
        listVehiculo.add(v2);
        listVehiculo.add(v3);


        this.listViewVehiculo = findViewById(R.id.listView);

        this.vehiculoAdapter =  new ArrayAdapter<Vehiculo>(this,R.layout.item_vehiculo,R.id.text_owner,listVehiculo);
        listViewVehiculo.setAdapter(vehiculoAdapter);

    }
}
