package dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String cargo;
    private String funciones;
    private Fundacion fundacion;
    private Map<Date, Double> horario_registro; //horas diarias de trabajo

    public Empleado() {
    }

        public Empleado(String nombre, String cargo, String funciones) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.funciones = funciones;
        this.horario_registro = new HashMap<>();
    }
    
    public Empleado(String nombre, String cargo, String funciones, Fundacion fundacion) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.funciones = funciones;
        this.fundacion = fundacion;
        this.horario_registro = new HashMap<>();
    }

        public Empleado(int idEmpleado,String nombre, String cargo, String funciones) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cargo = cargo;
        this.funciones = funciones;
        this.horario_registro = new HashMap<>();
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
        
    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public void setHorario_registro(Map<Date, Double> horario_registro) {
        this.horario_registro = horario_registro;
    }

    public Fundacion getFundacion() {
        return fundacion;
    }

    public void setFundacion(Fundacion fundacion) {
        this.fundacion = fundacion;
    }

    public Map<Date, Double> getHorario_registro() {
        return horario_registro;
    }

    public void registrarHorarioTrabajo(Date fecha, Double horas) {
        if (horario_registro.containsKey(fecha)) {
            Double horas_trabajadas = horario_registro.get(fecha);
            horas_trabajadas += horas;
            horario_registro.put(fecha, horas_trabajadas);
        } else {
            horario_registro.put(fecha, horas);
        }
    }

    public void mostrarRegistroHorario() {
        System.out.println("Registro de horas trabajadas por el empleado " + nombre + ":");
        for (Map.Entry<Date, Double> registro : horario_registro.entrySet()) {
            Date fecha = registro.getKey();
            Double horas = registro.getValue();
            System.out.println("Fecha: " + fecha + ", Horas trabajadas: " + horas);
            System.out.println("-----------------------------------");
        }
    }

}
