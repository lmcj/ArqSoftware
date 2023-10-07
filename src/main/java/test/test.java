package test;

import java.util.Date;

import conexiondb.CConexion;
import controlador.DAOEmpleado;
import controlador.DAOFundacion;
import dominio.Fundacion;
import dominio.CalculadoraSalario;
import dominio.Empleado;
import dominio.Voluntario;
import dominio.Mascota;
import java.sql.SQLException;
import java.util.List;

public class test {

    public static void main(String[] args) throws SQLException {

        DAOFundacion insertFundacion = new DAOFundacion();
        DAOEmpleado insertEmpleado = new DAOEmpleado();

        
//FUNDACIONES

//        Insertar Fundacion
//        Fundacion fundacion = new Fundacion("Fundacion ", 85274, "Mi llanura", "fundacion@gmail.com", "Ayudar animales");
//        insertFundacion.insertar(fundacion);

//        Listar fundaciones
//        List<Fundacion> listaFundacion = insertFundacion.Listar();
//        for (Fundacion fundacion : listaFundacion) {
//            System.out.println(fundacion.toString());
//        }

//        Editar fundaciones
//        Fundacion fundacion = new Fundacion();
//        fundacion.setIdFundacion(2);
//        fundacion.setNombre("Hogar de Animalitos");
//        fundacion.setTelefono(649321);
//        fundacion.setDireccion("Villanueva");
//        fundacion.setMision("Proteger y rescatar");
//        fundacion.setCorreo_electronico("hogarAnimalitos@gmail.com");        
//        insertFundacion.editar(fundacion);

//        Buscar fundacion
//        int idFundacion = 2;
//        Fundacion fundacionBuscar = new Fundacion();
//        fundacionBuscar.setIdFundacion(idFundacion);
//        insertFundacion.buscar(fundacionBuscar);

//        Eliminar fundacion
//        int idFundacion = 8;
//        Fundacion fundacionEliminar = new Fundacion();
//        fundacionEliminar.setIdFundacion(idFundacion);
//        insertFundacion.eliminar(fundacionEliminar);

//EMPLEADOS

//        Insertar empleados
//        String nombreEmpleado = "Camilo";
//        String cargoEmpleado = "Doctor";
//        String funcionesEmpleado = "Gestión de proyectos";
//        int idFundacion = 4 ;        
//        Fundacion fundacion = new Fundacion(idFundacion);       
//        insertEmpleado.insertarEmpleado(fundacion.agregarEmpleado(nombreEmpleado, cargoEmpleado, funcionesEmpleado, fundacion));

////      Editar empleado
//        int idEmpleado = 3;
//        
//        Empleado empleado = new Empleado();
//        String nuevoNombre = "Nuevo Nombre";
//        String nuevoCargo = "Nuevo Cargo";
//        String nuevasFunciones = "Nuevas Funciones";
//        Fundacion fundacion = new Fundacion();       
//        fundacion.editarEmpleado(empleado, nuevoNombre, nuevoCargo, nuevasFunciones);



    }

}
