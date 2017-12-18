package cl.ucn.disc.dam.controlaucn.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.activities.MainActivity;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Germán Rojo on 30-11-2017.
 */
//@Slf4j
public final class VehiculoAdapter extends BaseAdapter{

    /**
     * Listado de Vehiculos original ( no debe ser modificada)
     */
    private ArrayList<Vehiculo> listaVehiculos;
    /**
     * lista que tendra solo los elementos filtrado y la que contiene los elementos a mostrar;
     */
    private ArrayList<Vehiculo> listaFilterVehiculos;
    /**
     * Contexto
     */
    private final Context context;

    /**
     *
     */
    private Filter valueFilter;

    /**
     * @param context
     */
    public VehiculoAdapter(final Context context, final ArrayList<Vehiculo> lista) {
        this.context = context;
        this.listaVehiculos = new ArrayList<Vehiculo>(lista);
        this.listaFilterVehiculos = new ArrayList<Vehiculo>(lista);
    }

    /**
     * Cuantos items hay en este adapter
     *
     * @return Cantidad de items
     */
    @Override
    public int getCount() {
        return listaFilterVehiculos.size();
    }

    /**
     * Obtiene un item especifico indicado por una posicion
     *
     * @param position posicion de la cual queremos obtener el dato
     * @return el dato en la posicion indicada
     */
    @Override
    public Vehiculo getItem(int position) {
        return listaFilterVehiculos.get(position);
    }

    /**
     * Obtiene la posicion de la fila asociada a una posicion
     *
     * @param i la posicion del adapter
     * @return la id del item
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Metodo personalizado que realiza el proceso de filtrado modificando listaFilterVehiculos
     * notificando cada vez que se realiza un cambio.
     * @return
     */
    public void Filter(String charSequence) {
        charSequence = charSequence.toUpperCase(Locale.getDefault());
        listaFilterVehiculos.clear();
        if (StringUtils.isEmpty(charSequence)) {
            listaFilterVehiculos.addAll(listaVehiculos);
        } else {
            for (Vehiculo v : listaVehiculos) {
                final String patentefromList = v.getPatente();

                if (patentefromList.contains(charSequence)) {
                    listaFilterVehiculos.add(v);
                }
            }
        }
        notifyDataSetChanged();
    }

    /**
     * Se genera la vista para cada elemento
     * @param i
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final ViewHolder holder;


        if(convertView == null){
            //si la vista no esta creada, se crea
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_vehiculo,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        if (listaFilterVehiculos.get(i) == null){
            Log.d("ERROR","LISTAFILTERVEHICULOS VACIA AUN");
        }
       Vehiculo vehiculo = (Vehiculo) listaFilterVehiculos.get(i);

        //final Vehiculo vehiculo = (Vehiculo) getItem(i);

        if(vehiculo != null){
            holder.owner.setText(vehiculo.getOwner().getNombre());
            holder.marca.setText(vehiculo.getMarca());
            holder.year.setText(vehiculo.getYear());
            holder.tipo.setText(vehiculo.getModelo());
            holder.patente.setText(vehiculo.getPatente());

        }else{
            Log.d("VNUL","VEHICULO NULL");
        }

        return convertView;
    }

    /**
     * Patron ViewHolder
     */
    private  class ViewHolder{
        TextView owner;
        TextView marca;
        TextView year;
        TextView tipo;
        TextView patente;
        TextView color;

        public ViewHolder(final View view){
            this.owner = (TextView) view.findViewById(R.id.text_owner);
            this.marca =(TextView)view.findViewById(R.id.text_marca);
            this.year = (TextView)view.findViewById(R.id.text_year);
            this.tipo = (TextView)view.findViewById(R.id.text_tipo);
            this.patente = (TextView) view.findViewById(R.id.text_patente);

            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"LicensePlate.ttf");
            this.patente.setTypeface(typeface);
        }


    }



}
