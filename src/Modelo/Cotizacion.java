/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ONYX
 */
public class Cotizacion {

  public static int f = 1;
  public int folio;
  public String fecha;
  public ListaServicios servicios;
  public double total;

  public void setFolio(int folio) {
    this.folio = folio;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public int getFolio() {
    return folio;
  }

  public String getFecha() {
    return fecha;
  }

  public Cotizacion() {
    this.folio = Cotizacion.f++;
    this.fecha = "";
    this.servicios = new ListaServicios(5);
    this.total = 0;
  }

  public Cotizacion(int folio, String fecha, ListaServicios servicios) {
    this.folio = Cotizacion.f++;
    this.fecha = fecha;
    this.servicios = servicios;
    this.total = 0.0;
  }

  public Cotizacion(int folio, String fecha) {
    this.folio = Cotizacion.f++;
    this.fecha = fecha;
    this.servicios = new ListaServicios(5);
    this.total = 0.0;
  }

  public void agregarCotizacion(Servicio servicio, int unidades) {
    // Agregar el servicio a la lista de servicios de la cotización
    servicios.agregarServicio(servicio, unidades);
    // Actualizar el número de unidades del servicio agregado
    servicio.unidades = unidades;
    // Actualizar el total de la cotización
    this.total = calcularTotal();
  }

  public double calcularTotal() {
    double total = 0.0;
    for (int i = 0; i < servicios.servicios.length; i++) {
      if (servicios.servicios[i] != null) {
        total += servicios.servicios[i].calcularPrecioVenta();
      }
    }
    return total;
  }

  public double calcularIVA() {
    return (calcularTotal() * 0.16);
  }

  public double calcularTotalconIVA() {
    return (calcularTotal() + calcularIVA());
  }

  public String mostrar() {
    return "Folio: " + this.folio + "\n" +
        "Fecha: " + this.fecha + "\n" +
        "Subtotal: $" + calcularTotal() + "\n" +
        "IVA(16%) : $" + calcularIVA() + "\n" +
        "Total: $" + calcularTotalconIVA();
  }

}
