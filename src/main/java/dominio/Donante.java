
package dominio;

import java.util.ArrayList;
import java.util.List;


public class Donante {
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private List<String> historialDonaciones;
    private String preferenciasDonacion;

    public Donante(String nombre, String direccion, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.historialDonaciones = new ArrayList<>();
        this.preferenciasDonacion = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<String> getHistorialDonaciones() {
        return historialDonaciones;
    }

    public void setHistorialDonaciones(List<String> historialDonaciones) {
        this.historialDonaciones = historialDonaciones;
    }

    public String getPreferenciasDonacion() {
        return preferenciasDonacion;
    }

    public void setPreferenciasDonacion(String preferenciasDonacion) {
        this.preferenciasDonacion = preferenciasDonacion;
    }
    
    public void registrarDonacion(String donacion) {
        historialDonaciones.add(donacion);
    }
    
    public void mostrarHistorialDonaciones() {
        System.out.println("Historial de Donaciones de " + nombre + ":");
        for (String donacion : historialDonaciones) {
            System.out.println("- " + donacion);
        }
    }
}

