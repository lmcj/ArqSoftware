package controlador;

import conexiondb.CConexion;
import dominio.Fundacion;
import dominio.Voluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOVoluntario {

    Connection con;
    CConexion cn = new CConexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarVoluntario(Voluntario vol) {
        String sql = "INSERT INTO mydb.voluntarios (nombre, telefono, correo_electronico, habilidades, disponibilidad, Fundacion_idFundacion) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); 

            ps = con.prepareStatement(sql);
            ps.setString(1, vol.getNombre());
            ps.setInt(2, vol.getTelefono());
            ps.setString(3, vol.getCorreo_electronico());
            ps.setString(4, vol.getHabilidades());
            ps.setString(5, vol.getDisponibilidad());
            ps.setInt(6, vol.getFundacion().getIdFundacion());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE HA CREADO EL VOLUNTARIO CON ÉXITO");
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

    public List<Voluntario> ALLVoluntarios() throws SQLException {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.voluntarios";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("idVoluntarios"));
                v.setNombre(rs.getString("nombre"));
                v.setDireccion(rs.getString("direccion"));
                v.setCorreo_electronico(rs.getString("correo_electronico"));
                v.setHabilidades(rs.getString("habilidades"));
                v.setDisponibilidad(rs.getString("disponibilidad"));
                v.setTelefono(rs.getInt("telefono"));
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public List<Voluntario> ListarVoluntariosFundacion(Fundacion fundacion) {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.voluntarios WHERE Fundacion_idFundacion = ?";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fundacion.getIdFundacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                Voluntario v = new Voluntario();
                v.setIdVoluntario(rs.getInt("idVoluntarios"));
                v.setNombre(rs.getString("nombre"));
                v.setDireccion(rs.getString("direccion"));
                v.setCorreo_electronico(rs.getString("correo_electronico"));
                v.setHabilidades(rs.getString("habilidades"));
                v.setDisponibilidad(rs.getString("disponibilidad"));
                v.setTelefono(rs.getInt("telefono"));
                v.setFundacion(fundacion);
                lista.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public boolean editarVoluntario(Voluntario vol) {
        String sql = "UPDATE mydb.voluntarios SET nombre=?, telefono=?, correo_electronico=?, habilidades=?, disponibilidad=? WHERE idVoluntarios=?";
        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setString(1, vol.getNombre());
            ps.setInt(2, vol.getTelefono());
            ps.setString(3, vol.getCorreo_electronico());
            ps.setString(4, vol.getHabilidades());
            ps.setString(5, vol.getDisponibilidad());
            ps.setInt(6, vol.getIdVoluntario());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE ACTUALIZARON DATOS");
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

    public Voluntario buscar(Voluntario vol) {
        String sql = "SELECT * FROM mydb.voluntarios WHERE Fundacion_idFundacion=?; ";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vol.getIdVoluntario());
            rs = ps.executeQuery();
            if (rs.next()) {
                vol.setIdVoluntario(rs.getInt("idVoluntarios"));
                vol.setNombre(rs.getString("nombre"));
                vol.setDireccion(rs.getString("direccion"));
                vol.setCorreo_electronico(rs.getString("correo_electronico"));
                vol.setHabilidades(rs.getString("habilidades"));
                vol.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        }
        return vol;
    }

    public boolean eliminarVoluntario(Voluntario vol) {
        String sql = "DELETE FROM mydb.voluntarios WHERE idVoluntarios= ? AND Fundacion_idFundacion = ?";
        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); 

            ps = con.prepareStatement(sql);
            ps.setInt(1, vol.getIdVoluntario());
            ps.setInt(2, vol.getFundacion().getIdFundacion());

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
