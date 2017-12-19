package cl.ucn.disc.dam.controlaucn.activities;

import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.adapters.VehiculoAdapter;
import cl.ucn.disc.dam.controlaucn.model.Persona;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;

public class MainActivity extends AppCompatActivity  {
    /**
     * Adapter de {@link cl.ucn.disc.dam.controlaucn.model.Vehiculo}
     */
    private VehiculoAdapter vehiculoAdapter;

    /**
     * Lista de vehiculos
     */
    private ListView listViewVehiculo;

    /**
     * TextBox donde la cual se hara filtro en listViewVehiculo
     */
    private EditText eText_box;

    /**
     * Controla el cambio de texto de eText_box
     */
    private TextWatcher txtWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Vehiculo> listVehiculo = generarVehiculos();
        eText_box = (EditText) findViewById(R.id.editText_box);

        this.vehiculoAdapter = new VehiculoAdapter(this, listVehiculo);
        this.listViewVehiculo = (ListView) findViewById(R.id.listView);
        listViewVehiculo.setAdapter(vehiculoAdapter);

        // listener que realizara ciertas acciones si encuentra un cambio en el editText

        if(eText_box == null){
            Log.d("ETE","EditText esta vacio");
        }
        eText_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                vehiculoAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }



    private static ArrayList<Vehiculo> generarVehiculos(){
        ArrayList<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();

        /**Persona p1 = Persona.builder().nombre("GERMAN").build();
        Persona p2 = Persona.builder().nombre("DIEGO").build();
        Persona p3 = Persona.builder().nombre("ANDRES").build();
        Persona p4 = Persona.builder().nombre("IGNACIO").build();

        Vehiculo v = Vehiculo.builder().patente("BBXN65").marca("toyota").color("negro").modelo("nose").year("2020").owner(p1).build();
        Vehiculo v1 = Vehiculo.builder().patente("CFGC90").marca("ford").color("blanco").modelo("fiesta").year("2017").owner(p2).build();
        Vehiculo v2 = Vehiculo.builder().patente("GBDK67").marca("hyundai").color("amarillo").modelo("santa fe").year("2019").owner(p3).build();
        Vehiculo v3 = Vehiculo.builder().patente("JKLT34").marca("suzuki").color("azul").modelo("swift").year("2011").owner(p4).build();

        listVehiculo.add(v);
        listVehiculo.add(v1);
        listVehiculo.add(v2);
        listVehiculo.add(v3);
         **/
        return listVehiculo;

    }
}
