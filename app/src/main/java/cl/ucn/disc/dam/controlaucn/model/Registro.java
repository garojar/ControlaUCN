package cl.ucn.disc.dam.controlaucn.model;

/**
 * Created by Germán Rojo on 21-12-2017.
 */

public class Registro {

    /**
     * Patente del vehiculo a registrar
     */
    private String Patente;

    /**
     * Dia en que se realiza el registro
     */
    private String DATE_DAY;

    /**
     * Hora en que se realiza el registro
     */
    private String DATE_TIME;

    /**
     * Puerta por la cual se realiza el registro
     */
    private String Gate;

    /**
     * Accion del registro (Entrada o Salida)
     */
    private String Estado;
}
