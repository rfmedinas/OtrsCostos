package org.otrs.costos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity 
@Table(name="v_ticket")
public class ConsultaEstado implements Serializable{
	/**
	 * 
	 */
	@Id
	@Column (name="numero")
	private String idTicket;

	@Column (name="nit")
	private String nit;

	@Column (name="cola")
	private String dependencia;

	@Column (name="estado")
	private String estado;

	@Column (name="tipo")
	private String tipoSolicitud;

	@Column (name="transaccion")
	private String solicitud;

	@Column (name="detalle")
	private String nota;

	@Column (name="fecha_creacion")
	private Date fechaNota;

	@Column (name="usuario")
	private String usuario;
	public ConsultaEstado() {

	}

	public ConsultaEstado(String idTicket, String nit, String dependencia, String estado, String tipoSolicitud,
			String solicitud, String nota, Date fechaNota, String usuario) {
		super();
		this.idTicket = idTicket;
		this.nit = nit;
		this.dependencia = dependencia;
		this.estado = estado;
		this.tipoSolicitud = tipoSolicitud;
		this.solicitud = solicitud;
		this.nota = nota;
		this.fechaNota = fechaNota;
		this.usuario = usuario;
	}

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getFechaNota() {
		return fechaNota;
	}

	public void setFechaNota(Date fechaNota) {
		this.fechaNota = fechaNota;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
