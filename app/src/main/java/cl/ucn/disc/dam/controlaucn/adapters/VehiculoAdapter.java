package cl.ucn.disc.dam.controlaucn.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Germán Rojo on 30-11-2017.
 */
//@Slf4j
public final class VehiculoAdapter extends BaseAdapter {

    /**
     * Listado de Vehiculos
     */
    private ArrayList<Vehiculo> vehiculos;
    /**
     * Contexto
     */
    private final Context context;

    /**
     * @param context
     */
    public VehiculoAdapter(final Context context,final ArrayList<Vehiculo> lista) {
        this.context = context;
        this.vehiculos = lista;
    }

    /**
     * Cuantos items hay en este adapter
     *
     * @return Cantidad de items
     */
    @Override
    public int getCount() {
        return vehiculos.size();
    }

    /**
     * Obtiene un item especifico indicado por una posicion
     *
     * @param position posicion de la cual queremos obtener el dato
     * @return el dato en la posicion indicada
     */
    @Override
    public Vehiculo getItem(int position) {
        return vehiculos.get(position);
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


        final Vehiculo vehiculo = (Vehiculo) getItem(i);

        if(vehiculo != null){
            holder.owner.setText(vehiculo.getOwner().getNombre());
            holder.marca.setText(vehiculo.getMarca());
            holder.year.setText(vehiculo.getYear());
            holder.tipo.setText(vehiculo.getModelo());
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
        ImageView patente;

        public ViewHolder(final View view){
            this.owner = (TextView) view.findViewById(R.id.text_owner);
            this.marca =(TextView)view.findViewById(R.id.text_marca);
            this.year = (TextView)view.findViewById(R.id.text_year);
            this.tipo = (TextView)view.findViewById(R.id.text_tipo);
            this.patente = (ImageView)view.findViewById(R.id.image_patente);
        }

    }

}
