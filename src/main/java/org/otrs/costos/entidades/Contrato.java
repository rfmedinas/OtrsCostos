package org.otrs.costos.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "sysman_contratado")
@IdClass(ContratoId.class)
/**
 * Identiica la tabla para incluir los datos de lo contratado por cliente
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 * url base: https://attacomsian.com/blog/spring-data-jpa-composite-primary-key
 */
public class Contrato implements Serializable {
   @Id
   /**
    * Columna que identifica el identificador único del cliente
    */
   @Column(name = "id_cliente", nullable = false)
   private int idClient;
   /**
    * Columna que identifica el Ip del contrato
    */
   @Column(name = "ip", nullable = false)
   private String ip;

   @Column(name = "fecha_inicio", nullable = false)
   private Date fechaInicio;

   @Column(name = "fecha_final", nullable = false)
   private Date fechaFinal;

   @Column(name = "h_presencial", nullable = false, columnDefinition = "int default 0") 
   private double hPresencial;

   @Column(name = "h_virtual", nullable = false, columnDefinition = "int default 0") 
   private double hVirtual;

   @Column(name = "h_ajuste", nullable = false, columnDefinition = "int default 0") 
   private double hAjuste;

   @Column(name = "transaccion_tol", nullable = false, columnDefinition = "int default 0") 
   private double transaccionTol;

   @Column(name = "estado", nullable = false, columnDefinition = "int default -1") 
   private boolean estado;

   public Contrato(int idClient, String ip, Date fechaInicio, Date fechaFinal, double hPresencial, double hVirtual,
         double hAjuste, double transaccionTol, boolean estado) {
      this.idClient = idClient;
      this.ip = ip;
      this.fechaInicio = fechaInicio;
      this.fechaFinal = fechaFinal;
      this.hPresencial = hPresencial;
      this.hVirtual = hVirtual;
      this.hAjuste = hAjuste;
      this.transaccionTol = transaccionTol;
      this.estado = estado;
   }

   public int getIdClient() {
      return idClient;
   }

   public void setIdClient(int idClient) {
      this.idClient = idClient;
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

}
