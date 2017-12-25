package cl.ucn.disc.dam.controlaucn.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase Vehiculo
 * @author Germán Rojo
 *
 */
@Builder
public final  class Vehiculo {

    /**
     * Persona que inscribio el vehiculo
     */
    @Getter
    private Persona owner;
    /**
     * Placa patente
     */
    @Getter
    private String patente;

    /**
     * Marca productora
     */
    @Getter
    private String marca;

    /**
     * Color asociado
     */
    @Getter
    private String color;

    /**
     * Modelo = version
     */
    @Getter
    private String modelo;

    /**
     * año de fabricacion
     */
    @Getter
    private String year;

    /**
     * Descripcion opcional sobre el vehiculo
     */
    @Getter
    private String nota;

    /**
     * Situacion del vehiculo ( dentro del establecimiento = registrado , representado por true)
     */
    @Getter
    @Setter
    private String situacion;
}
