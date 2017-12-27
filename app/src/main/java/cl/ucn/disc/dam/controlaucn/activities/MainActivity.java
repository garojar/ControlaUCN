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

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.adapters.VehiculoAdapter;
import cl.ucn.disc.dam.controlaucn.controller.InsertRegistro;
import cl.ucn.disc.dam.controlaucn.model.Persona;
import cl.ucn.disc.dam.controlaucn.model.Persona_Table;
import cl.ucn.disc.dam.controlaucn.model.Registro;
import cl.ucn.disc.dam.controlaucn.model.Registro_Table;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo_Table;

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


    private List<Vehiculo> listVehiculos;

    private InsertRegistro insertRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.insertRegistro =InsertRegistro.builder().build();

        this.eText_box = (EditText) findViewById(R.id.editText_box);

        {
            FlowManager.init(new FlowConfig.Builder(getApplicationContext())
                    .openDatabasesOnInit(true)
                    .build());
        }

        this.listVehiculos  = SQLite.select().from(Vehiculo.class).queryList();
        if(listVehiculos.size() == 0) {

            Persona p1 = Persona.builder()
                    .nombre("German Rojo")
                    .rut("19.446.088-0")
                    .correo("garojar@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Estudiante")
                    .build();
            Persona p2 = Persona.builder()
                    .nombre("Diego Saavedra")
                    .rut("18.423.512-1")
                    .correo("dsaavedra@hotmail.com")
                    .numCelular("969021232")
                    .tipo("Estudiante")
                    .build();
            Persona p3 = Persona.builder()
                    .nombre("Andres Arce")
                    .rut("12.230.239-2")
                    .correo("aarce@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Estudiante")
                    .build();

            Persona p4 = Persona.builder()
                    .nombre("Ignacio Bravo")
                    .rut("10.402.125-k")
                    .correo("ibravo@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Academico")
                    .build();

            Persona p5 = Persona.builder()
                    .nombre("Manuel Urrutia")
                    .rut("9.304.238-1")
                    .correo("murrutia@hotmail.com")
                    .numCelular("99023231")
                    .tipo("Estudiante")
                    .build();

            Persona p6 = Persona.builder()
                    .nombre("Carlos Leiva")
                    .rut("14.530.503-1")
                    .correo("cleiva@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Funcionario")
                    .build();

            Persona p7 = Persona.builder()
                    .nombre("Jose Luis")
                    .rut("10.454.502-1")
                    .correo("jluis@hotmail.com")
                    .numCelular("96450942")
                    .tipo("Academico")
                    .build();

            Persona p8 = Persona.builder()
                    .nombre("Juan Bekios")
                    .rut("5.341.123-1")
                    .correo("jbekios@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Academico")
                    .build();

            Persona p9 = Persona.builder()
                    .nombre("Kevin Araya")
                    .rut("17.230.151-1")
                    .correo("karaya@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Estudiante")
                    .build();

            Persona p10 = Persona.builder()
                    .nombre("Hatsune Miku")
                    .rut("23.125.686-1")
                    .correo("hmiku@hotmail.com")
                    .numCelular("91255940")
                    .tipo("Estudiante")
                    .build();

            Persona p11 = Persona.builder()
                    .nombre("Jethro Morales")
                    .rut("18.239.498-1")
                    .correo("jmorales@hotmail.com")
                    .numCelular("963473122")
                    .tipo("Estudiante")
                    .build();

            Persona p12 = Persona.builder()
                    .nombre("Ayleen Torres")
                    .rut("19.240.159-1")
                    .correo("atorres@hotmail.com")
                    .numCelular("95237891")
                    .tipo("Estudiante")
                    .build();

            Persona p13 = Persona.builder()
                    .nombre("Carlos Pon")
                    .rut("2.305.134")
                    .correo("cpon@hotmail.com")
                    .numCelular("964121050")
                    .tipo("Academico")
                    .build();

            p1.save();
            p2.save();
            p3.save();
            p4.save();
            p5.save();
            p6.save();
            p7.save();
            p8.save();
            p9.save();
            p10.save();
            p11.save();
            p12.save();
            p13.save();




            Vehiculo v = Vehiculo.builder()
                    .patente("BBXN65")
                    .marca("Toyota")
                    .color("Negro")
                    .modelo("Next")
                    .year("2020")
                    .owner(p1)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v1 = Vehiculo.builder()
                    .patente("CFGC90")
                    .marca("Ford")
                    .color("Blanco")
                    .modelo("Fiesta")
                    .year("2017")
                    .owner(p2)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v2 = Vehiculo.builder()
                    .patente("GBDK67")
                    .marca("Hyundai")
                    .color("Amarillo")
                    .modelo("Santa Fe")
                    .year("2019")
                    .owner(p3)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v3 = Vehiculo.builder()
                    .patente("JKLT34")
                    .marca("Suzuki")
                    .color("Azul")
                    .modelo("Swift")
                    .year("2011")
                    .owner(p4)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v4 = Vehiculo.builder()
                    .patente("KGNM45")
                    .marca("Subaru")
                    .color("Azul")
                    .modelo("GO")
                    .year("2011")
                    .owner(p5)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v5 = Vehiculo.builder()
                    .patente("XCBR53")
                    .marca("AlfaRomeo")
                    .color("Verde")
                    .modelo("Sirvi")
                    .year("2011")
                    .owner(p6)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v6 = Vehiculo.builder()
                    .patente("GBDK63")
                    .marca("Chevrolet")
                    .color("Rojo")
                    .modelo("Corsa")
                    .year("2011")
                    .owner(p7)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v7 = Vehiculo.builder()
                    .patente("HJKR12")
                    .marca("Ford")
                    .color("Rojo")
                    .modelo("f-150")
                    .year("2020")
                    .owner(p8)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v8 = Vehiculo.builder()
                    .patente("YTPJ23")
                    .marca("Chevrolet")
                    .color("Rojo")
                    .modelo("Bacan")
                    .year("2011")
                    .owner(p9)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v9 = Vehiculo.builder()
                    .patente("FGKQ34")
                    .marca("Audi")
                    .color("Verde")
                    .modelo("Fast")
                    .year("2011")
                    .owner(p10)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v10 = Vehiculo.builder()
                    .patente("KTPK80")
                    .marca("Lamborgini")
                    .color("Rojo")
                    .modelo("Murcielago")
                    .year("2015")
                    .owner(p13)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v11 = Vehiculo.builder()
                    .patente("RDFV49")
                    .marca("Hyundai")
                    .color("Negro")
                    .modelo("Carpe Diem")
                    .year("2013")
                    .owner(p11)
                    .situacion("No Registrado")
                    .build();

            Vehiculo v12 = Vehiculo.builder()
                    .patente("PGJB42")
                    .marca("KIA")
                    .color("Blanco")
                    .modelo("Frontier")
                    .year("2015")
                    .owner(p12)
                    .situacion("No Registrado")
                    .build();

            v.save();
            v1.save();
            v2.save();
            v3.save();
            v4.save();
            v5.save();
            v6.save();
            v7.save();
            v8.save();
            v9.save();
            v10.save();
            v11.save();
            v12.save();

        }

        this.vehiculoAdapter = new VehiculoAdapter(this, listVehiculos);
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
                Persona owner = SQLite.select().from(Persona.class).where(Persona_Table.id.eq(item.getOwner().getId())).querySingle();//item.getOwner().getId();
                tv_patente.setText(item.getPatente());
                tv_nombre.setText(owner.getNombre());
                tv_marcaModelo.setText(item.getMarca()+" "+item.getModelo());
                tv_rut.setText(owner.getRut());
                tv_year.setText(item.getYear());
                tv_celular.setText(owner.getNumCelular());
                tv_correo.setText(owner.getCorreo());
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
                        Vehiculo vehiculo = SQLite.select().from(Vehiculo.class).where(Vehiculo_Table.id.eq(vehiculoAdapter.getItem(pos).getId())).querySingle();
                        if (!reg.equals("Registrado")) {

                            //Se registrar y se cambia text a registrado
                            Toast.makeText(MainActivity.this, "Ingresado Correctamente", Toast.LENGTH_SHORT).show();
                            TextView reg = mView.findViewById(R.id.text_situacion);

                            vehiculo.setSituacion("Registrado");
                            vehiculo.update();

                            insertRegistro.addEntrada(vehiculo.getPatente(),gate);

                            refreshAdapter();
                            dialog.cancel();

                        } else {
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
                        //se obtiene de la query el vehiculo segun si id para cambiar su situacion
                        Vehiculo vehiculo = SQLite.select().from(Vehiculo.class).where(Vehiculo_Table.id.eq(vehiculoAdapter.getItem(pos).getId())).querySingle();
                        if(reg.equals("Registrado")) {

                            //Se registrar y se cambia text a No registrado
                            Toast.makeText(MainActivity.this, "Salida Registrada Correctamente", Toast.LENGTH_SHORT).show();

                            vehiculo.setSituacion("No Registrado");

                            vehiculo.update();

                            insertRegistro.addSalida(vehiculo.getPatente(),gate);
                            refreshAdapter();
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
            case R.id.ic_reg:
                //AlertDialog.Builder rBuilder= new AlertDialog.Builder(MainActivity.this);
               // View rView = getLayoutInflater().inflate(R.layout.item_registro,null);

               // TextView p = findViewById(R.id.txt_patente_r);
               // TextView d = findViewById(R.id.txt_day);
               // TextView t = findViewById(R.id.txt_time);
              //  TextView a = findViewById(R.id.txt_accion);

              //  long i =1;
              //  Registro reg = SQLite.select().from(Registro.class).where(Registro_Table.id.eq(i)).querySingle();

            //    p.setText(reg.getPatente());
             //   d.setText(reg.getEstado());
             //   t.setText(reg.getDATE_DAY());
              //  final AlertDialog rdialog = rBuilder.create();
             //   rdialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Actualiza el adapter si esque hubo un cambio en la base de datos
     */
    private void refreshAdapter() {
        this.listVehiculos  = SQLite.select().from(Vehiculo.class).queryList();
        this.vehiculoAdapter.setListaVehiculos(this.listVehiculos);
        this.vehiculoAdapter.refreshFilterList();

    }

}
