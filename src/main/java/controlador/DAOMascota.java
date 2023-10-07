package controlador;

import conexiondb.CConexion;
import dominio.Fundacion;
import dominio.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOMascota {

    Connection con;
    CConexion cn = new CConexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarMascota(Mascota mas) {
        String sql = "INSERT INTO mydb.mascotas (nombre, especie, raza, genero, edad, color, estado_salud, disponible, adoptante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setString(1, mas.getNombre());
            ps.setString(2, mas.getEspecie());
            ps.setString(3, mas.getRaza());
            ps.setString(4, mas.getGenero());
            ps.setInt(5, mas.getEdad());
            ps.setString(6, mas.getColor());
            ps.setString(7, mas.getEstado_salud());
            ps.setBoolean(8, mas.getDisponible());
            ps.setInt(9, mas.getFundacion().getIdFundacion());

            int n = ps.executeUpdate();

            if (n != 0) {
                con.commit();
                JOptionPane.showMessageDialog(null, "SE HA CREADO LA MASCOTA CON ÉXITO");
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

    public List<Mascota> ALLMascotas() throws SQLException {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.mascotas";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setIdMascota(rs.getInt("idMascotas"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setGenero(rs.getString("genero"));
                m.setEdad(rs.getInt("edad"));
                m.setColor(rs.getString("color"));
                m.setEstado_salud(rs.getString("estado_salud"));
                m.setDisponible(rs.getBoolean("disponible"));
                lista.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public List<Mascota> ListarMascotasFundacion(Fundacion fundacion) {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.mascotas WHERE Fundacion_idFundacion = ?";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, fundacion.getIdFundacion());
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setIdMascota(rs.getInt("idMascotas"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setGenero(rs.getString("genero"));
                m.setEdad(rs.getInt("edad"));
                m.setColor(rs.getString("color"));
                m.setEstado_salud(rs.getString("estado_salud"));
                m.setDisponible(rs.getBoolean("disponible"));
                m.setFundacion(fundacion);
                lista.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        }
        return lista;
    }

    public boolean editarMascota(Mascota mas) {
        String sql = "UPDATE mydb.mascotas SET nombre = ?, especie = ?, raza = ?, genero = ?, edad = ?, color = ?, estado_salud = ?, disponible = ? WHERE idMascotas = ?";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false); // Deshabilitar la autoconfirmación de la transacción

            ps = con.prepareStatement(sql);
            ps.setString(1, mas.getNombre());
            ps.setString(2, mas.getEspecie());
            ps.setString(3, mas.getRaza());
            ps.setString(4, mas.getGenero());
            ps.setInt(5, mas.getEdad());
            ps.setString(6, mas.getColor());
            ps.setString(7, mas.getEstado_salud());
            ps.setBoolean(8, mas.getDisponible());
            ps.setInt(9, mas.getIdMascota());

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

    public Mascota buscar(Mascota mas) {
        String sql = "SELECT * FROM mydb.mascotas WHERE idMascotas=?; ";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mas.getIdMascota());
            rs = ps.executeQuery();
            if (rs.next()) {
                mas.setIdMascota(rs.getInt("idMascotas"));
                mas.setNombre(rs.getString("nombre"));
                mas.setEspecie(rs.getString("especie"));
                mas.setRaza(rs.getString("raza"));
                mas.setGenero(rs.getString("genero"));
                mas.setEdad(rs.getInt("edad"));
                mas.setColor(rs.getString("color"));
                mas.setEstado_salud(rs.getString("estado_salud"));
                mas.setDisponible(rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        }
        return mas;
    }

    public boolean eliminarMascota(Mascota mas) {
        String sql = "DELETE FROM mydb.mascotas WHERE idMascotas = ? AND Fundacion_idFundacion = ?";

        try {
            con = cn.estableceConexion();
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setInt(1, mas.getIdMascota());
            ps.setInt(2, mas.getFundacion().getIdFundacion());

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
