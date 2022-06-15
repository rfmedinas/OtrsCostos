package org.otrs.costos.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Objeto que permite identificar el id de la clase Contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
public class ContratoId implements Serializable {
    /**
     * Columna que identifica el identificador único del cliente
     */
    private int idCliente;
    /**
     * Columna que identifica el Ip del contrato
     */
    private String ip;

    public ContratoId() {

    }

    public ContratoId(int idCliente, String ip) {
        this.idCliente = idCliente;
        this.ip = ip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, ip);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContratoId other = (ContratoId) obj;
        if (idCliente != other.idCliente)
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        return true;
    }

}
