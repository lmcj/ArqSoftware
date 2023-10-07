package controlador;

import conexiondb.CConexion;
import dominio.Empleado;
import dominio.Fundacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOEmpleado {

    Connection con;
    CConexion cn = new CConexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarEmpleado(Empleado emp) {
        String sql = "INSERT INTO mydb.empleados (nombre, cargo, funciones, Fundacion_idFundacion) VALUES (?, ?, ?, ?)";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); 

            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getCargo());
            ps.setString(3, emp.getFunciones());
            ps.setInt(4, emp.getFundacion().getIdFundacion());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE HA CREADO EL EMPLEADO CON ÉXITO");
                return true;
            } else {
                con.rollback();
                JOptionPane.showMessageDialog(null, "NO SE HA CREADO EL EMPLEADO CON ÉXITO");
                return false;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        } finally {
            try {
                con.setAutoCommit(true); 
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Empleado> ALLEmpleados() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.empleados";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleados"));
                e.setNombre(rs.getString("nombre"));
                e.setCargo(rs.getString("cargo"));
                e.setFunciones(rs.getString("funciones"));
                lista.add(e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public List<Empleado> ListarEmpleadosFundacion(Fundacion fundacion) {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.empleados WHERE Fundacion_idFundacion = ?";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fundacion.getIdFundacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleados"));
                e.setNombre(rs.getString("nombre"));
                e.setCargo(rs.getString("cargo"));
                e.setFunciones(rs.getString("funciones"));
                e.setFundacion(fundacion);
                lista.add(e);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public boolean editarEmpleado(Empleado emp) {
        String sql = "UPDATE mydb.empleados SET nombre=?, cargo=?, funciones=? WHERE idEmpleados=?";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getCargo());
            ps.setString(3, emp.getFunciones());
            ps.setInt(4, emp.getIdEmpleado());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE ACTUALIZARON DATOS");
                return true;
            } else {
                con.rollback();
                JOptionPane.showMessageDialog(null, "NO SE HA ACTUALIZARON DATOS");
                return false;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        } finally {
            try {
                con.setAutoCommit(true); 
                con.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Empleado buscar(Empleado emp) {
        String sql = "SELECT * FROM mydb.empleados WHERE idEmpleado=?; ";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpleado());
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setIdEmpleado(rs.getInt("idEmpleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setCargo(rs.getString("cargo"));
                emp.setFunciones(rs.getString("funciones"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        }
        return emp;
    }

    public boolean eliminarEmpleado(Empleado emp) {
        String sql = "DELETE FROM mydb.empleados WHERE idEmpleados = ? AND Fundacion_idFundacion = ?";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); 

            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getIdEmpleado());
            ps.setInt(2, emp.getFundacion().getIdFundacion());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE LOGRÓ ELIMINAR");
                return true;
            } else {
                con.rollback();
                JOptionPane.showMessageDialog(null, "ID NO ENCONTRADO");
                return false;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ELIMINAR");
            System.out.println("Error al eliminar datos");
            return false;
        } finally {
            try {
                con.setAutoCommit(true); 
                con.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
