/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ONYX
 */
public class Servicio {

  public static int id = 1;
  public int idServicio;
  public String nombre;
  public int unidades;
  public double costoFijo;
  public double costoVariable;
  public double iva;
  public double subTotal;

  public Servicio() {
    this.idServicio = Servicio.id++;
    this.nombre = "";
    this.unidades = 0;
    this.costoFijo = 0.0;
    this.costoVariable = 0.0;
    this.iva = 0.16;
    this.subTotal = 0.0;
  }

  public Servicio(String n, int u, double cF, double cV) {
    this.idServicio = Servicio.id++;
    this.nombre = n;
    this.unidades = u;
    this.costoFijo = cF;
    this.costoVariable = cV;
    this.iva = 0.16;
    this.subTotal = unidades * costoVariable + costoFijo;
  }

  public double getSubtotal() {
    return subTotal;
  }

  public void actualizarSubtotal() {
    this.subTotal = unidades * costoVariable + costoFijo;
  }
  
  public double calcularPrecioVenta() {
    double pV = 0.0;
    pV = this.unidades * this.costoVariable + this.costoFijo;
    return pV;
  }

  public double calcularIVA() {
    double pIVA = 0.0;
    pIVA = calcularPrecioVenta() * this.iva;
    return pIVA;
  }

  public String mostrar() {
    String r = "";
    r = "ID asignado al servicio: " + this.idServicio +
        "\nNombre del servicio: " + this.nombre +
        "\nCosto fijo:" + this.costoFijo +
        "\nCosto variable: " + this.costoVariable + 
        "\nCosto total del servicio: " + this.subTotal;
    return r;
  }

}
