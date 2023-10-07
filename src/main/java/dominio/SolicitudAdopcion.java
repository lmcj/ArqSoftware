package dominio;

public class SolicitudAdopcion {
    private Adoptante adoptante;
    private MascotaAdoptada mascotaAdoptada;
    private String estado;

    public SolicitudAdopcion(Adoptante adoptante, MascotaAdoptada mascotaAdoptada) {
        this.adoptante = adoptante;
        this.mascotaAdoptada = mascotaAdoptada;
        this.estado = "Pendiente";
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public MascotaAdoptada getMascotaAdoptada() {
        return mascotaAdoptada;
    }

    public String getEstado() {
        return estado;
    }

    public void aprobarSolicitud() {
        estado = "Aprobada";
        adoptante.setMascotaAdoptada(mascotaAdoptada);
    }

    public void rechazarSolicitud() {
        estado = "Rechazada";
    }

    public void cancelarSolicitud() {
        estado = "Cancelada";
    }
}
