package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *@author  Germán Rojo on 30-11-2017.
 */
@Builder
@Table(database = Database.class)
@NoArgsConstructor
@AllArgsConstructor
public final class Persona {

    /**
     * identificador de a persona
     */
    @Getter
    @Column
    @PrimaryKey(autoincrement= true)
    int id ;
    /**
     * Rut unico de cada persona
     */
    @Getter
    @Column
    String rut;

    /**
     * Nombre
     */
    @Getter
    @Column
    String nombre;
    /**
     * Correo Electronico xxxx@yyy.zz
     */
    @Getter
    @Column
    String correo;

    /**
     * Numero telefono movil 9xxxxxxxx
     */
    @Getter
    @Column
    String numCelular;




}
