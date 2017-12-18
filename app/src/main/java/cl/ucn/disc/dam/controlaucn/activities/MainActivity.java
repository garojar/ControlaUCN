package cl.ucn.disc.dam.controlaucn.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

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

        this.eText_box = (EditText) findViewById(R.id.editText_box);

        this.vehiculoAdapter = new VehiculoAdapter(this, generarVehiculos());
        this.listViewVehiculo = (ListView) findViewById(R.id.listView);
        this.listViewVehiculo.setAdapter(vehiculoAdapter);

        // listener que realizara ciertas acciones si encuentra un cambio en el editText
        this.eText_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {




            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text =  editable.toString();
                vehiculoAdapter.Filter(text);
            }
        });

        listViewVehiculo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Vehiculo item = vehiculoAdapter.getItem(i);
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.item_vehiculo_detail,null);
                TextView tv_patente = (TextView) mView.findViewById(R.id.text_patente_detail);
                TextView tv_marcaModelo = (TextView) mView.findViewById(R.id.text_marca_model);
                TextView tv_nombre = (TextView) mView.findViewById(R.id.text_nombre_detail);
                TextView tv_rut = (TextView) mView.findViewById(R.id.text_rut_detail);
                TextView tv_year = (TextView) mView.findViewById(R.id.text_year_detail);
                TextView tv_tipo = (TextView) mView.findViewById(R.id.text_tipo_detail);
                TextView tv_celular =(TextView) mView.findViewById(R.id.text_celular_detail);
                TextView tv_correo = (TextView) mView.findViewById(R.id.text_correo_detail);

                tv_patente.setText(item.getPatente());
                tv_nombre.setText(item.getOwner().getNombre());
                tv_marcaModelo.setText(item.getMarca()+" "+item.getModelo());
                tv_rut.setText(item.getOwner().getRut());
                tv_year.setText(item.getYear());
                tv_celular.setText(item.getOwner().getNumCelular());
                tv_correo.setText(item.getOwner().getCorreo());


                Typeface typeface = Typeface.createFromAsset(getAssets(),"LicensePlate.ttf");
                tv_patente.setTypeface(typeface);
                Button bt_in = (Button) mView.findViewById(R.id.btn_out);
                Button bt_out =(Button) mView.findViewById(R.id.btn_in);

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();



            }

        });

    }



    private static ArrayList<Vehiculo> generarVehiculos(){
        ArrayList<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();

        Persona p1 = Persona.builder().nombre("German Rojo").rut("19.446.088-0").correo("garojar@hotmail.com").numCelular("963473122").build();
        Persona p2 = Persona.builder().nombre("Diego Saavedra").build();
        Persona p3 = Persona.builder().nombre("Andres Arce").build();
        Persona p4 = Persona.builder().nombre("Ignacio Bravo").build();
        Persona p5 = Persona.builder().nombre("Manuel Urrutia").build();
        Persona p6 = Persona.builder().nombre("Carlos Leiva").build();
        Persona p7 = Persona.builder().nombre("Jose Luis").build();


        Vehiculo v = Vehiculo.builder().patente("BBXN65").marca("Toyota").color("Negro").modelo("Next").year("2020").owner(p1).build();
        Vehiculo v1 = Vehiculo.builder().patente("CFGC90").marca("Ford").color("Blanco").modelo("Fiesta").year("2017").owner(p2).build();
        Vehiculo v2 = Vehiculo.builder().patente("GBDK67").marca("Hyundai").color("Amarillo").modelo("Santa Fe").year("2019").owner(p3).build();
        Vehiculo v3 = Vehiculo.builder().patente("JKLT34").marca("Suzuki").color("Azul").modelo("Swift").year("2011").owner(p4).build();
        Vehiculo v4 = Vehiculo.builder().patente("KGNM45").marca("Subaru").color("Azul").modelo("GO").year("2011").owner(p5).build();
        Vehiculo v5 = Vehiculo.builder().patente("XCBR53").marca("AlfaRomeo").color("Verde").modelo("Sirvi").year("2011").owner(p6).build();
        Vehiculo v6 = Vehiculo.builder().patente("GBDK63").marca("Chevrolet").color("Rojo").modelo("Corsa").year("2011").owner(p7).build();


        listVehiculo.add(v);
        listVehiculo.add(v1);
        listVehiculo.add(v2);
        listVehiculo.add(v3);
        listVehiculo.add(v4);
        listVehiculo.add(v5);
        listVehiculo.add(v6);




        return listVehiculo;
    }
}
