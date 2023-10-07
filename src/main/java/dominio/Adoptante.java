
package dominio;

public class Adoptante {
    
    private String nombre;
    private String telefono;
    private String correo_electronico;
    private String estado_adopcion;
    private String preferencia_mascota;
    private String direccion;
    private MascotaAdoptada mascotaAdoptada;

    public Adoptante(String nombre, String telefono, String correo_electronico, String preferencia_mascota, 
            String direccion){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.estado_adopcion = "Pendiente";
        this.preferencia_mascota = preferencia_mascota;
        this.direccion = direccion;
        this.mascotaAdoptada = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getEstado_adopcion() {
        return estado_adopcion;
    }

    public void setEstado_adopcion(String estado_adopcion) {
        this.estado_adopcion = estado_adopcion;
    }

    public String getPreferencia_mascota() {
        return preferencia_mascota;
    }

    public void setPreferencia_mascota(String preferencia_mascota) {
        this.preferencia_mascota = preferencia_mascota;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public MascotaAdoptada getMascotaAdoptada() {
        return mascotaAdoptada;
    }

    public void setMascotaAdoptada(MascotaAdoptada mascotaAdoptada) {
        this.mascotaAdoptada = mascotaAdoptada;
    }
}
