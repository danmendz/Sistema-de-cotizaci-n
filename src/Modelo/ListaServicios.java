/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ONYX
 */
public class ListaServicios {
  Servicio[] servicios;

  public ListaServicios(int n) {
    this.servicios = new Servicio[n];
  }

  public boolean agregarServicio(Servicio nuevoS, int posicion) {
    boolean agregado = false;
    if (posicion >= 0 && posicion < servicios.length) {
      if (servicios[posicion] == null) {
        servicios[posicion] = nuevoS;
        agregado = true;
      }
    }
    return agregado;
  }

  public int disponibles() {
    int i, n = 0;
    for (i = 0; i < servicios.length; i++) {
      if (servicios[i] == null) {
        n++;
      }
    }
    return n;
  }

  public int primerVacio() {
    int i = 0, iEncontrado = -1;
    do {
      if (servicios[i] == null) {
        iEncontrado = i;
      } else {
        i++;
      }
    } while (iEncontrado == -1 && i < servicios.length);
    return iEncontrado;
  }

  public Servicio buscarServicioID(int id) {
    Servicio servEncontrado = null;
    for (int i = 0; i < servicios.length; i++) {
      if (servicios[i] != null) {
        if (servicios[i].idServicio == id) {
          servEncontrado = servicios[i];
        }
      }
    }
    return servEncontrado;
  }

  public String buscar(int id) {
    String r = "";

    for (int i = 0; i < servicios.length; i++) {
      if (servicios[i] != null) {
        if (servicios[i].idServicio == id) {
          r = r + (i + 1) + "---------" + servicios[i].mostrar();
        }
      }
    }
    return r;
  }

  public String listarServicios() {
    String r = "";
    int i = 0;

    for (i = 0; i < this.servicios.length; i++) {
      r = r + "----------\n" + (i + 1) + ")  ";
      if (this.servicios[i] == null)
        r = r + "\n";
      else
        r = r + this.servicios[i].mostrar() + "\n";
    }
    r = r + "------------\n";
    return r;
  }

}