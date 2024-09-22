/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ONYX
 */
public class ListaCotizaciones {
  public Cotizacion[] cotizaciones;
  public int contador;
  public int ultimoFolio;

  public ListaCotizaciones() {
    this.cotizaciones = new Cotizacion[10];
    this.contador = 0;
    this.ultimoFolio = 0;
  }

  public ListaCotizaciones(Cotizacion cotizacion) {
    this.cotizaciones = new Cotizacion[5];
    this.cotizaciones[0] = cotizacion;
    this.contador = 1;
    this.ultimoFolio = cotizacion.getFolio(); // Inicializar al folio de la cotización
  }

  public int generarFolio() {
    this.ultimoFolio++; // Incrementar el último folio
    return this.ultimoFolio;
  }

  public String agregarCotizacion(Cotizacion cotizacion) {
    if (this.contador == 5) {
      return "No se pueden agregar más cotizaciones";
    }
    cotizacion.setFolio(generarFolio());
    this.cotizaciones[this.contador] = cotizacion;
    this.contador++;
    return "Cotización agregada con éxito";
  }

  public double calcularTotalCotizacionesFecha(String fecha) {
    double total = 0;
    for (int i = 0; i < contador; i++) {
      if (this.cotizaciones[i].getFecha().equals(fecha)) {
        total += this.cotizaciones[i].calcularTotalconIVA();
      }
    }
    return total;
  }

  public Cotizacion buscarCotizacionFolio(int f) {
    Cotizacion cEncontrado = null;
    for (int i = 0; i < cotizaciones.length; i++) {
      if (cotizaciones[i] != null) {
        if (cotizaciones[i].folio == f) {
          cEncontrado = cotizaciones[i];
        }
      }
    }
    return cEncontrado;
  }

  public String mostrar() {
    String r = "";
    for (int i = 0; i < cotizaciones.length; i++)
      if (cotizaciones[i] != null)
        r = r + cotizaciones[i].mostrar() + "\n";
    return r;
  }

  public int obtenerNumeroCotizacionesFecha(String fecha) {
    int contadorCotizaciones = 0;
    for (Cotizacion cotizacion : cotizaciones) {
      if (cotizacion.fecha.equals(fecha)) {
        contadorCotizaciones++;
      }
    }
    return contadorCotizaciones;
  }

}
