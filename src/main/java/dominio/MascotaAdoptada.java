
package dominio;

import java.util.Date;

public class MascotaAdoptada extends Mascota{
    private Date fechaAdopcion;
    private Adoptante adoptante;

    public MascotaAdoptada(String nombre, String especie, String raza, 
            String genero, int edad, String color, String estado_salud) {
        super(nombre, especie, raza, genero, edad, color, estado_salud, false);
        this.fechaAdopcion = null;
        this.adoptante = null;
    }  

    public Date getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
    
   public void marcarComoAdoptada(Date fechaAdopcion, Adoptante adoptante){
       this.fechaAdopcion = fechaAdopcion;
       this.adoptante = adoptante;
   }
   
   public void asignarAdoptante(Adoptante adoptante){
       
   }
   
   public void gestionarAdopcion(){}
   @Override
   public void mostrarInformacion(){
       super.mostrarInformacion();
       if(fechaAdopcion != null){
           System.out.println("Fecha de Adopcion: " + fechaAdopcion);
           System.out.println("Adoptante: " + adoptante.getNombre());
       }
   }
}
