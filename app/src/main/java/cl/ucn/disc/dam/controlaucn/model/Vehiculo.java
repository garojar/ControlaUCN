package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import cl.ucn.disc.dam.controlaucn.dao.AppDataBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Vehiculo
 * @author Germán Rojo
 *
 */
@Builder
@Table(database = AppDataBase.class)
@AllArgsConstructor
@NoArgsConstructor
public final  class Vehiculo extends BaseEntityModel{


    /**
     * Primary key
     */
    @PrimaryKey(autoincrement = true)
    @Getter
    @Column
    long id;

    /**
     * Persona que inscribio el vehiculo
     */
    @Column
    @NotNull
    @ForeignKey(stubbedRelationship = true)
    @Getter
    @Setter
    private Persona owner;
    /**
     * Placa patente
     */
    @NotNull
    @Column
    @Getter
    @Setter
    private String patente;

    /**
     * Marca productora
     */
    @Column
    @Getter
    @Setter
    private String marca;

    /**
     * Color asociado
     */
    @Column
    @Getter
    @Setter
    private String color;

    /**
     * Modelo = version
     */
    @Column
    @Getter
    @Setter
    private String modelo;

    /**
     * año de fabricacion
     */
    @Column
    @Getter
    @Setter
    private String year;

    /**
     * Descripcion opcional sobre el vehiculo
     */
    @Column
    @Getter
    @Setter
    private String nota;

    /**
     * Situacion del vehiculo ( dentro del establecimiento = registrado , representado por true)
     */
    @Column
    @Getter
    @Setter
    private String situacion;
}
