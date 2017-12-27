package cl.ucn.disc.dam.controlaucn.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;

import cl.ucn.disc.dam.controlaucn.dao.AppDataBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *@author  Germán Rojo on 30-11-2017.
 */
@Builder
@Table(database = AppDataBase.class)
@AllArgsConstructor
@NoArgsConstructor
public final class Persona extends BaseEntityModel{

    /**
     * Primary key
     */
    @PrimaryKey(autoincrement = true)
    @Getter
    @Column
    long id;

    /**
     * Rut unico de cada persona
     */
    @Unique
    @Column
    @Setter
    @Getter
    String rut;

    /**
     * Nombre
     */
    @Column
    @Setter
    @Getter
    String nombre;
    /**
     * Correo Electronico xxxx@yyy.zz
     */
    @Column
    @Setter
    @Getter
    String correo;

    /**
     * Numero telefono movil 9xxxxxxxx
     */
    @Column
    @Setter
    @Getter
    String numCelular;

    /**
     * Tipo de persona ( estudiante, funcionario o academico)
     */
    @Column
    @Setter
    @Getter
    String tipo;




}
