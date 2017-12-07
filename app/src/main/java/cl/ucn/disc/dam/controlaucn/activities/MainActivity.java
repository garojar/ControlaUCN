package cl.ucn.disc.dam.controlaucn.activities;

import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import cl.ucn.disc.dam.controlaucn.R;
import cl.ucn.disc.dam.controlaucn.adapters.VehiculoAdapter;

public class MainActivity extends ListActivity  {
    /**
     * Adapter de {@link cl.ucn.disc.dam.controlaucn.model.Vehiculo}
     */
    private BaseAdapter vehiculoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_vehiculo);

        // Row division
        int[] colors = {0, 0xFFFF0000, 0};
        this.getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        this.getListView().setDividerHeight(5);

        this.vehiculoAdapter =  new VehiculoAdapter(this);
        super.setListAdapter(this.vehiculoAdapter);

    }
}
