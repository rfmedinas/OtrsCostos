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
@Table(name = "sysman_contratado")
// @IdClass(ContratoId.class)
/**
 * Identiica la tabla para incluir los datos de lo contratado por cliente
 * 
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 *         url base:
 *         https://attacomsian.com/blog/spring-data-jpa-composite-primary-key
 */
public class Contrato implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	/**
	 * Columna que identifica el identificador único del cliente
	 */
	@Column(name = "id_cliente", nullable = false)
	private int idCliente;
	/**
	 * Columna que identifica el Ip del contrato
	 */
	@Column(name = "ip", nullable = false)
	private String ip;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	@Column(name = "fecha_final")
	private Date fechaFinal;

	@Column(name = "fecha_servicio")
	private Date fechaServicio;

	@Column(name = "h_presencial", nullable = false, columnDefinition = "DECIMAL(10,2) default 0")
	private double hPresencial;

	@Column(name = "h_virtual", nullable = false, columnDefinition = "DECIMAL(10,2) default 0")
	private double hVirtual;

	@Column(name = "h_ajuste", nullable = false, columnDefinition = "DECIMAL(10,2) default 0")
	private double hAjuste;

	@Column(name = "transaccion_tol", nullable = false, columnDefinition = "DECIMAL(10,2) default 0")
	private double transaccionTol;

	@Column(name = "estado", nullable = false, columnDefinition = "int default -1")
	private boolean estado;

	@Column(name = "autoriza")
	private String autoriza;

	@Column(name = "asesor")
	private String asesor;

	@Column(name = "observacion")
	private String observacion;

	@Column(name = "creacion")
	private Date creacion;

	@Column(name = "ano")
	private int ano;

	@Column(name = "horas_ano_anterior", nullable = false, columnDefinition = "DECIMAL(10,2) default 0") 
	private double horas_ano_anterior;

	@Column(name = "fecha_corte") 
	private Date fecha_corte;

	@Column(name = "horas_corte" , nullable = false, columnDefinition = "DECIMAL(10,2) default 0")
	private double horas_corte;

	public Contrato() {
	}

	public Contrato(int idCliente, String ip, Date fechaInicio, Date fechaFinal, Date fechaServicio, double hPresencial,
			double hVirtual, double hAjuste, double transaccionTol, boolean estado, String autoriza, String asesor) {
		this.idCliente = idCliente;
		this.ip = ip;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.fechaServicio = fechaServicio;
		this.hPresencial = hPresencial;
		this.hVirtual = hVirtual;
		this.hAjuste = hAjuste;
		this.transaccionTol = transaccionTol;
		this.estado = estado;
		this.autoriza = autoriza;
		this.asesor = asesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaServicio() {
		return fechaServicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}

	public double gethPresencial() {
		return hPresencial;
	}

	public void sethPresencial(double hPresencial) {
		this.hPresencial = hPresencial;
	}

	public double gethVirtual() {
		return hVirtual;
	}

	public void sethVirtual(double hVirtual) {
		this.hVirtual = hVirtual;
	}

	public double gethAjuste() {
		return hAjuste;
	}

	public void sethAjuste(double hAjuste) {
		this.hAjuste = hAjuste;
	}

	public double getTransaccionTol() {
		return transaccionTol;
	}

	public void setTransaccionTol(double transaccionTol) {
		this.transaccionTol = transaccionTol;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getAutoriza() {
		return autoriza;
	}

	public void setAutoriza(String autoriza) {
		this.autoriza = autoriza;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getCreacion() {
		return creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getHoras_ano_anterior() {
		return horas_ano_anterior;
	}

	public void setHoras_ano_anterior(double horas_ano_anterior) {
		this.horas_ano_anterior = horas_ano_anterior;
	}

	public Date getFecha_corte() {
		return fecha_corte;
	}

	public void setFecha_corte(Date fecha_corte) {
		this.fecha_corte = fecha_corte;
	}

	public double getHoras_corte() {
		return horas_corte;
	}

	public void setHoras_corte(double horas_corte) {
		this.horas_corte = horas_corte;
	}

}
