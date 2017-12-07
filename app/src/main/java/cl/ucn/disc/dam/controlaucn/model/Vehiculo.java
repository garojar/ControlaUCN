package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;


import lombok.Builder;
import lombok.Getter;

/**
 * Clase Vehiculo
 * @author Germán Rojo
 *
 */
@Builder
@Table(database = Database.class)

public final  class Vehiculo extends BaseModel{

    /**
     * Persona que inscribio el vehiculo
     */
    @Column
    @Getter
    private Persona dueño;
    /**
     * Placa patente
     */
    @Column
    @PrimaryKey
    @Getter
    private String patente;

    /**
     * Marca productora
     */
    @Column
    @Getter
    private String marca;

    /**
     * Color asociado
     */
    @Column
    @Getter
    private String color;

    /**
     * Modelo = version
     */
    @Getter
    @Column
    private String modelo;

    /**
     * año de fabricacion
     */
    @Getter
    @Column
    private String year;

    /**
     * Descripcion opcional sobre el vehiculo
     */
    @Getter
    @Column
    private String nota;
}
