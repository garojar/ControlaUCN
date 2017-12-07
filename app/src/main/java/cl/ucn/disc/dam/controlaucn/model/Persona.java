package cl.ucn.disc.dam.controlaucn.model;

import lombok.Builder;
import lombok.Getter;

/**
 *@author  Germán Rojo on 30-11-2017.
 */
@Builder
public final class Persona {

    /**
     * Rut unico de cada persona
     */
    @Getter
    String rut;

    /**
     * Nombre
     */
    @Getter
    String nombre;
    /**
     * Correo Electronico xxxx@yyy.zz
     */
    @Getter
    String correo;

    /**
     * Numero telefono movil 9xxxxxxxx
     */
    @Getter
    String numCelular;




}
