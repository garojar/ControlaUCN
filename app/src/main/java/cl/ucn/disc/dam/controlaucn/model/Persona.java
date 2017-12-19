package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
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
public final class Persona extends cl.ucn.disc.dam.controlaucn.model.BaseModel {

    /**
     * identificador de a persona
     */
    @Getter
    @Column
    @PrimaryKey(autoincrement= true)
    long id ;
    /**
     * Rut unico de cada persona
     */
    @Getter
    @Column
    @Unique
    String rut;

    /**
     * Nombre
     */
    @Getter
    @Column
    String nombre;

    /**
     * apellido paterno
     */

    //@Column
    //@Getter
    //String paterno;

    /**
     * apellido materno
     */
    //@Getter
    //@Column
    //String materno;

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
    //puede ser Long

    /**
     * numero anexo de la persona
     */
    //@Getter
    //@Column
    //Integer anexo;



}
