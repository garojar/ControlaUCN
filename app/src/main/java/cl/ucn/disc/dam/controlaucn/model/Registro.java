package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import cl.ucn.disc.dam.controlaucn.dao.AppDataBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Germán Rojo on 21-12-2017.
 */
@Builder
@Table(database = AppDataBase.class)
@AllArgsConstructor
@NoArgsConstructor
public class Registro extends BaseEntityModel {

    /**
     * Primary key
     */
    @PrimaryKey(autoincrement = true)
    @Getter
    @Column
    long id;



    /**
     * Patente del vehiculo a registrar
     */
    @Column
    @Setter
    @Getter
    private String Patente;

    /**
     * Dia en que se realiza el registro
     */
    @Column
    @Setter
    @Getter
    private String DATE_DAY;

    /**
     * Hora en que se realiza el registro
     */
    @Column
    @Setter
    @Getter
    private String DATE_TIME;

    /**
     * Puerta por la cual se realiza el registro
     */
    @Column
    @Setter
    @Getter
    private String Gate;

    /**
     * Accion del registro (Entrada o Salida)
     */
    @Column
    @Setter
    @Getter
    private String Estado;
}
