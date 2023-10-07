package controlador;

import conexiondb.CConexion;
import dominio.Fundacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOFundacion {

    Connection con;
    CConexion cn = new CConexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertar(Fundacion fun) {
        String sql = "INSERT INTO Fundacion (nombre, telefono, direccion, mision, correo_electronico) VALUES (?, ?, ?, ?, ?)";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setString(1, fun.getNombre());
            ps.setInt(2, fun.getTelefono());
            ps.setString(3, fun.getDireccion());
            ps.setString(4, fun.getMision());
            ps.setString(5, fun.getCorreo_electronico());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE LOGRÓ GUARDAR DATOS");
                return true;
            } else {
                con.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRÓ GUARDAR DATOS");
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

    public List<Fundacion> Listar() throws SQLException {
        List<Fundacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.fundacion";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Fundacion f = new Fundacion();
                f.setIdFundacion(rs.getInt("idFundacion"));
                f.setNombre(rs.getString("nombre"));
                f.setTelefono(rs.getInt("telefono"));
                f.setDireccion(rs.getString("direccion"));
                f.setMision(rs.getString("mision"));
                f.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos " + e);
        }
        return lista;
    }

    public boolean editar(Fundacion fun) {
        String sql = "UPDATE Fundacion SET nombre=?,telefono=?,direccion=?, mision=?, correo_electronico=? WHERE idFundacion=? ";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(6, fun.getIdFundacion());
            ps.setString(1, fun.getNombre());
            ps.setInt(2, fun.getTelefono());
            ps.setString(3, fun.getDireccion());
            ps.setString(4, fun.getMision());
            ps.setString(5, fun.getCorreo_electronico());
            int n = ps.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "SE HA ACTUALIZADO CON EXITO");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        }
    }

    public Fundacion buscar(Fundacion fun) {
        String sql = "SELECT * FROM mydb.fundacion WHERE idFundacion=?; ";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fun.getIdFundacion());
            rs = ps.executeQuery();
            if (rs.next()) {
                fun.setIdFundacion(rs.getInt("idFundacion"));
                fun.setNombre(rs.getString("nombre"));
                fun.setTelefono(rs.getInt("telefono"));
                fun.setDireccion(rs.getString("direccion"));
                fun.setMision(rs.getString("mision"));
                fun.setCorreo_electronico(rs.getString("correo_electronico"));
                System.out.println(fun.toString());
            }else{
                JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("Error al buscar datos");
        }
        return fun;
    }

    public boolean eliminar(Fundacion fun) {
        String sql = "DELETE FROM mydb.fundacion WHERE idFundacion=?";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); 

            ps = con.prepareStatement(sql);
            ps.setInt(1, fun.getIdFundacion());
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
