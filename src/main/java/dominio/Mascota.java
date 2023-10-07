
package dominio;

import java.util.List;

public class Mascota {
    private int idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String genero;
    private int edad;
    private String color;
    private String estado_salud;
    private Boolean disponible; 
    private Adoptante adoptante;
    private List<Mascota> mascotasDisponibles;
    private List<Mascota> mascotasNoDisponibles;
    private Fundacion fundacion;
    
    public Mascota(){
    }
    
    public Mascota(String nombre, String especie, String raza, String genero, int edad, 
            String color, String estado_salud, Boolean disponible){
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.estado_salud = estado_salud;
        this.disponible = disponible;
    }
    
    public Mascota(int idMascota, String nombre, String especie, String raza, String genero, int edad, 
            String color, String estado_salud, Boolean disponible, Fundacion fundacion){
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.estado_salud = estado_salud;
        this.disponible = disponible;
    }
    
    public Mascota(String nombre, String especie, String raza, String genero, int edad, 
            String color, String estado_salud, Boolean disponible, Fundacion fundacion){
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.estado_salud = estado_salud;
        this.disponible = disponible;
        this.fundacion = fundacion;       
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    
    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getEstado_salud() {
        return estado_salud;
    }
    public void setEstado_salud(String estado_salud) {
        this.estado_salud = estado_salud;
    } 

    public Fundacion getFundacion() {
        return fundacion;
    }

    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Raza: " + raza);
        System.out.println("Genero: " + genero);
        System.out.println("Edad: " + edad);
        System.out.println("Color: " + color);
        System.out.println("Estado de Salud: " + estado_salud);
    }
    

}
