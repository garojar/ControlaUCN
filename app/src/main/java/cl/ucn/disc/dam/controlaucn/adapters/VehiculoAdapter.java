package cl.ucn.disc.dam.controlaucn.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Germán Rojo on 30-11-2017.
 */
//@Slf4j
public final class VehiculoAdapter extends BaseAdapter{

    /**
     * Contexto
     */
    private final Context context;

    /**
     *
     * @param context
     */
    public VehiculoAdapter(final Context context){
        this.context = context;
    }

    /**
     * Cuantos items hay en este adapter
     * @return Cantidad de items
     */
    @Override
    public int getCount(){
        return 0;
    }

    /**
     * Obtiene un item especifico indicado por una posicion
     * @param position posicion de la cual queremos obtener el dato
     * @return el dato en la posicion indicada
     */
    @Override
    public Vehiculo getItem(int position){
        return null;
    }

    /**
     * Obtiene la posicion de la fila asociada a una posicion
     * @param i la posicion del adapter
     * @return la id del item
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
