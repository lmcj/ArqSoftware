package dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Voluntario {

    private int idVoluntario;
    private String nombre;
    private String direccion;
    private String correo_electronico;
    private String habilidades;
    private String disponibilidad;
    private int telefono;
    private Map<Date, Double> horas_registro;
    private List<String> historialInformes;
    private Fundacion fundacion;
    
    public Voluntario(){
    }
    
    public Voluntario (String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.habilidades = habilidades;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
        this.horas_registro = new HashMap<>();
        this.historialInformes = new ArrayList<>();
    }
    
    public Voluntario (int idVoluntario, String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono){
        this.idVoluntario = idVoluntario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.habilidades = habilidades;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
    }
    
    public Voluntario (String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono, Fundacion fundacion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.habilidades = habilidades;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
        this.horas_registro = new HashMap<>();
        this.historialInformes = new ArrayList<>();
        this.fundacion = fundacion;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getCorreo_electronico(){
        return correo_electronico;
    }

    public String getHabilidades(){
        return habilidades;
    }

    public String getDisponibilidad(){
        return disponibilidad;
    }

    public int getTelefono(){
        return telefono;
    }

    public Map<Date, Double> getHoras_registro(){
        return horas_registro;
    }

    public Fundacion getFundacion() {
        return fundacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }
    
    public void registrarHorasVoluntariado(Date fecha, double horas){
        
        if (horas_registro.containsKey(fecha)){
            double horas_voluntariado = horas_registro.get(fecha);
            horas_voluntariado += horas;
            horas_registro.put(fecha, horas_voluntariado);
        } else {
            horas_registro.put(fecha, horas);
        }
    }

    public void mostrarRegistroHoras(){
        System.out.println("Registro de horas de voluntariado de " + nombre + ":");
        for(Map.Entry<Date, Double> registro : horas_registro.entrySet()){
            Date fecha = registro.getKey();
            Double horas = registro.getValue();
            System.out.println("Fecha: " + fecha + ", Horas de voluntariado: " + horas);
        }
    }

    public void mostrarHorasVoluntariado(){

        double horas_voluntariado = 0.0;

        for(double horas : horas_registro.values()){
            horas_voluntariado += horas;
        }

        System.out.println("Horas de voluntariado de " + nombre + ": " + horas_voluntariado );
    }

    // public void mostrarHorasVoluntariado(){
    //     System.out.println("Horas de voluntariado de " + nombre + ": " + calcularHorasVoluntariado());
    // }


    public void enviarInformeActividades(String informe){
        historialInformes.add(informe);
        System.out.println("Informe actividades enviado y guardado en el historial de informes de " + nombre + ".");	
    }

    public void mostrarHistorialInformes(){
        System.out.println("Historial de informes de " + nombre + ":");
        for(String informe : historialInformes){
            System.out.println(informe);
            System.out.println("--------------------------------------------------");
        }
    }
    
}
