package cl.ucn.disc.dam.controlaucn.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     * representacion de Puerta seleccionada por el usuario
     */
    private String gate;


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

        //listener item de la listView , realiza en layoutInflater de vehiculo_detail mostrando los datos
        listViewVehiculo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int pos = i;
                Vehiculo item = vehiculoAdapter.getItem(i);
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.item_vehiculo_detail,null);
                TextView tv_patente = (TextView) mView.findViewById(R.id.text_patente_detail);
                TextView tv_marcaModelo = (TextView) mView.findViewById(R.id.text_marca_model);
                TextView tv_nombre = (TextView) mView.findViewById(R.id.text_nombre_detail);
                TextView tv_rut = (TextView) mView.findViewById(R.id.text_rut_detail);
                TextView tv_year = (TextView) mView.findViewById(R.id.text_year_detail);
                TextView tv_tipo = (TextView) mView.findViewById(R.id.text_tipo_detail);
                TextView tv_celular =(TextView) mView.findViewById(R.id.text_celular_detail);
                TextView tv_correo = (TextView) mView.findViewById(R.id.text_correo_detail);
                TextView tv_registro = (TextView) mView.findViewById(R.id.text_situacion);

                tv_patente.setText(item.getPatente());
                tv_nombre.setText(item.getOwner().getNombre());
                tv_marcaModelo.setText(item.getMarca()+" "+item.getModelo());
                tv_rut.setText(item.getOwner().getRut());
                tv_year.setText(item.getYear());
                tv_celular.setText(item.getOwner().getNumCelular());
                tv_correo.setText(item.getOwner().getCorreo());
                tv_registro.setText(item.getSituacion());

                final String reg = tv_registro.getText().toString();

                if(!StringUtils.isEmpty(reg) && reg.equals("Registrado") ){
                    tv_registro.setTextColor(getResources().getColor(R.color.Verde));
                }


                Typeface typeface = Typeface.createFromAsset(getAssets(),"LicensePlate.ttf");
                tv_patente.setTypeface(typeface);
                Button bt_in = (Button) mView.findViewById(R.id.btn_in);
                Button bt_out =(Button) mView.findViewById(R.id.btn_out);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();

                bt_in.setOnClickListener(new View.OnClickListener(){

                    /**
                     * Cambia a situacion a registrado solo si esta en No Registrado
                     * @param view
                     */
                    @Override
                    public void onClick(View view) {
                        if(!reg.equals("Registrado")) {

                            //Se registrar y se cambia text a registrado
                            Toast.makeText(MainActivity.this, "Ingresado Correctamente", Toast.LENGTH_SHORT).show();
                            TextView reg = mView.findViewById(R.id.text_situacion);
                            vehiculoAdapter.getItem(pos).setSituacion("Registrado");
                            dialog.cancel();

                        }else{
                            Toast.makeText(MainActivity.this, "Error : Ya se encuentra Reg", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bt_out.setOnClickListener(new View.OnClickListener(){

                    /**
                     * Cambia situacion a No registrado, solo si esta registrado
                     * @param view
                     */
                    @Override
                    public void onClick(View view) {
                        if(reg.equals("Registrado")) {

                            //Se registrar y se cambia text a No registrado
                            Toast.makeText(MainActivity.this, "Salida Registrada Correctamente", Toast.LENGTH_SHORT).show();
                            vehiculoAdapter.getItem(pos).setSituacion("No Registrado");
                            dialog.cancel();

                        }else{
                            Toast.makeText(MainActivity.this, "Error: No se encuentra Registrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();








            }

        });

    }

    /**
     * Inflater del menu para la seleccion de entrada a registrar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ic_gate:
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.item_select_gate,null);
                Button button_gate_OK = (Button) mView.findViewById(R.id.button_ok_gate);
                final RadioGroup radioGroup = (RadioGroup)mView.findViewById(R.id.radioGroup);
                mBuilder.setView(mView);

                //marcamos la opcion si esque ya ha sido ingresada una
                if(!StringUtils.isEmpty(gate)){
                    switch (gate){
                        case "Norte":
                            radioGroup.check(R.id.radioButton);
                        break;
                        case "Centro":
                            radioGroup.check(R.id.radioButton2);
                        break;
                        case "Sur":
                            radioGroup.check(R.id.radioButton3);
                        break;
                    }
                }

                final AlertDialog dialog = mBuilder.create();
                dialog.show();



                button_gate_OK.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {

                        //buscamos si hay una seleccion
                        int id = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton = radioGroup.findViewById(id);
                        int idchild = radioGroup.indexOfChild(radioButton);

                        RadioButton selectedButton = (RadioButton) radioGroup.getChildAt(idchild);
                        //se guarda como referencia la gate seleccionada
                        gate = radioButton.getText().toString();

                        dialog.cancel();
                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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


        Vehiculo v = Vehiculo.builder().patente("BBXN65").marca("Toyota").color("Negro").modelo("Next").year("2020").owner(p1).situacion("No Registrado").build();
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
