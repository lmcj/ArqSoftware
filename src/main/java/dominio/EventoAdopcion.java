  
package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoAdopcion {
    private Date fecha;
    private String lugar;
    private String descripcion;
    private List<Mascota> mascotasDisponibles;

    public EventoAdopcion(Date fecha, String lugar, String descripcion) {
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.mascotasDisponibles = new ArrayList<>();
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Mascota> getMascotasDisponibles() {
        return mascotasDisponibles;
    }

    public void setMascotasDisponibles(List<Mascota> mascotasDisponibles) {
        this.mascotasDisponibles = mascotasDisponibles;
    }
    
    public void agregarMascota(Mascota mascota) {
        mascotasDisponibles.add(mascota);
    }

    public void mostrarInformacion() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Lugar: " + lugar);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Mascotas Disponibles:");
        for (Mascota mascota : mascotasDisponibles) {
            System.out.println("- " + mascota.getNombre());
        }
    }
}
