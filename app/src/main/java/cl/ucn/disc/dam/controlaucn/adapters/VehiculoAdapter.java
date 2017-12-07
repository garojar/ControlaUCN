package cl.ucn.disc.dam.controlaucn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
    private List<Vehiculo> vehiculos =  new ArrayList<>();
    /**
     * Contexto
     */
    private final Context context;

    /**
     * @param context
     */
    public VehiculoAdapter(final Context context) {
        this.context = context;
    }

    /**
     * Cuantos items hay en este adapter
     *
     * @return Cantidad de items
     */
    @Override
    public int getCount() {
        return 0;
    }

    /**
     * Obtiene un item especifico indicado por una posicion
     *
     * @param position posicion de la cual queremos obtener el dato
     * @return el dato en la posicion indicada
     */
    @Override
    public Vehiculo getItem(int position) {
        return null;
    }

    /**
     * Obtiene la posicion de la fila asociada a una posicion
     *
     * @param i la posicion del adapter
     * @return la id del item
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        final View view;

        if(convertView == null){
            //si la vista no esta creada, se crea
            view = LayoutInflater.from(context).inflate(R.layout.item_vehiculo,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }

        final Vehiculo vehiculo = this.getItem(i);

        if(vehiculo != null){
            holder.owner.setText(vehiculo.getOwner().getNombre());
            holder.marca.setText(vehiculo.getMarca());
            holder.year.setText(vehiculo.getYear());
            holder.tipo.setText(vehiculo.getModelo());
        }

        return view;
    }

    /**
     * Patron ViewHolder
     */
    private static class ViewHolder{
        TextView owner;
        TextView marca;
        TextView year;
        TextView tipo;
        ImageView patente;

        ViewHolder(final View view){
            this.owner = view.findViewById(R.id.text_owner);
            this.marca = view.findViewById(R.id.text_marca);
            this.year = view.findViewById(R.id.text_year);
            this.tipo = view.findViewById(R.id.text_tipo);
            this.patente = view.findViewById(R.id.image_patente);
        }

    }

}
