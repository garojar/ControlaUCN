package cl.ucn.disc.dam.controlaucn.controller;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Calendar;
import java.util.List;

import cl.ucn.disc.dam.controlaucn.model.Registro;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import lombok.Builder;

/**
 * Created by Germán Rojo on 27-12-2017.
 */
@Builder
public final class InsertRegistro {


    public void addEntrada(String p,String g){

        String day = Integer.toString(Calendar.DATE);
        String time = Integer.toString(Calendar.HOUR_OF_DAY);
        Registro registro  = Registro.builder()
                .Patente(p)
                .DATE_DAY(day)
                .DATE_TIME(time)
                .Gate(g)
                .Estado("Entrada")
                .build();

        registro.save();





    }

    public void addSalida(String p, String g){
        String day = Integer.toString(Calendar.DATE);
        String time = Integer.toString(Calendar.HOUR_OF_DAY);
        Registro registro  = Registro.builder()
                .Patente(p)
                .DATE_DAY(day)
                .DATE_TIME(time)
                .Gate(g)
                .Estado("Salida")
                .build();

        registro.save();

    }
}
