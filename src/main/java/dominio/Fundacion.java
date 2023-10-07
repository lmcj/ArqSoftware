package dominio;

import java.util.ArrayList;
import java.util.List;

public class Fundacion {

    private int idFundacion;
    private String nombre;
    private int telefono;
    private String direccion;
    private String correo_electronico;
    private String mision;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Voluntario> voluntarios = new ArrayList<>();
    private List<Mascota> mascotas = new ArrayList<>();

    public Fundacion() {
    }

    public Fundacion(int idFundacion) {
        this.idFundacion = idFundacion;
    }

    public Fundacion(String nombre, int telefono, String direccion, String correo_electronico, String mision) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.mision = mision;
    }

    public Fundacion(int idFundacion, String nombre, int telefono, String direccion, String correo_electronico, String mision) {
        this.idFundacion = idFundacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.mision = mision;
    }

    public int getIdFundacion() {
        return idFundacion;
    }

    public void setIdFundacion(int idFundacion) {
        this.idFundacion = idFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getMision() {
        return mision;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public Empleado agregarEmpleado(String nombre, String cargo, String funciones, Fundacion fun) {
        Empleado empleado = new Empleado(nombre, cargo, funciones, fun);
        empleados.add(empleado);
        return empleado;
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados de la fundacion " + nombre + ":");
        for (Empleado empleado : this.empleados) {
            System.out.println("Nombre: " + empleado.getNombre() + ", Cargo: " + empleado.getCargo() + ", Funciones: " + empleado.getFunciones());
        }
    }

    public boolean editarEmpleado(Empleado empleado, String nuevoNombre, String nuevoCargo, String nuevasFunciones) {
        for (Empleado emp : empleados) {
            if (emp.equals(empleado)) {
                emp.setNombre(nuevoNombre);
                emp.setCargo(nuevoCargo);
                emp.setFunciones(nuevasFunciones);
                return true;
            }
        }
        return false; 
    }

    //eliminar empleado
    public void eliminarEmpleado(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                empleados.remove(empleado);
                break;
            }
        }
    }

    public Voluntario agregarVoluntario(String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono) {
        Voluntario voluntario = new Voluntario(nombre, direccion, correo_electronico, habilidades, disponibilidad, telefono);
        voluntarios.add(voluntario);
        return voluntario;
    }

    public void mostrarVoluntarios() {
        System.out.println("Voluntarios de la fundacion " + nombre + ":");
        for (Voluntario voluntario : voluntarios) {
            System.out.println("Nombre: " + voluntario.getNombre() + ", Direccion: " + voluntario.getDireccion() + ", Correo electronico: " + voluntario.getCorreo_electronico() + ", Habilidades: " + voluntario.getHabilidades() + ", Disponibilidad: " + voluntario.getDisponibilidad() + ", Telefono: " + voluntario.getTelefono());
        }
    }

    //eliminar voluntario
    public void eliminarVoluntario(String nombre) {
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getNombre().equals(nombre)) {
                voluntarios.remove(voluntario);
                break;
            }
        }
    }

    public Mascota agregarMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud) {
        Mascota mascota = new Mascota(nombre, especie, raza, genero, edad, color, estado_salud, true);
        mascotas.add(mascota);
        return mascota;
    }

    public void mostrarMascotas() {
        System.out.println("Mascotas de la fundacion " + nombre + ":");
        for (Mascota mascota : mascotas) {
            System.out.println("Nombre: " + mascota.getNombre() + ", Especie: " + mascota.getEspecie() + ", Raza: " + mascota.getRaza() + ", Genero: " + mascota.getGenero() + ", Edad: " + mascota.getEdad() + ", Color: " + mascota.getColor() + ", Estado de salud: " + mascota.getEstado_salud());
        }
    }

    //eliminar mascota
    public void eliminarMascota(String nombre) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equals(nombre)) {
                mascotas.remove(mascota);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Fundacion {"
                + " Id Fundacion ='" + getIdFundacion() + '\''
                + ", Nombre ='" + getNombre() + '\''
                + ", Telefono ='" + getTelefono() + '\''
                + ", Direccion='" + getDireccion() + '\''
                + ", Mision=" + getMision()
                + ", Correo Electronico=" + getCorreo_electronico() + '}';
    }
}
