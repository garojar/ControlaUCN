package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Clase Vehiculo
 * @author Germán Rojo
 *
 */
@Builder
@Table(database = Database.class)
@AllArgsConstructor
@NoArgsConstructor
public final  class Vehiculo {

    /**
     * id de la clase vehiculo
     */
    @Getter
    @Column
    int idVehiculo;

    /**
     * id de Persona que inscribio el vehiculo
     */
    @Getter
    @Column
    int idDueño;

    /**
     * Placa patente
     */
    @Column
    @Getter
    String patente;

    /**
     * Marca productora
     */
    @Column
    @Getter
    String marca;

    /**
     * Color asociado
     */
    @Column
    @Getter
    String color;

    /**
     * Modelo = version
     */
    @Getter
    @Column
    String modelo;

    /**
     * año de fabricacion
     */
    @Getter
    @Column
    String year;

    /**
     * Descripcion opcional sobre el vehiculo
     */
    @Getter
    @Column
    String nota;


}
