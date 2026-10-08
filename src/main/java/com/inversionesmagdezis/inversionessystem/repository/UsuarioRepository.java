package main.java.com.inversionesmagdezis.inversionessystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import main.java.com.inversionesmagdezis.inversionessystem.config.DBConnection;
import main.java.com.inversionesmagdezis.inversionessystem.dto.request.UsuarioDTORequest;
import main.java.com.inversionesmagdezis.inversionessystem.dto.response.UsuarioDTOResponse;
import main.java.com.inversionesmagdezis.inversionessystem.model.Usuario;

public class UsuarioRepository {

    public UsuarioDTOResponse findUserByUsername(UsuarioDTORequest request) {
        String sql = "select "
                + " concat(u.nombre + ' ' + u.apellido) as nombre_completo,"
                + " u.password_hash "
                + " r.nombre_rol "
                + " from usuarios as u "
                + " inner join roles as r "
                + " on u.id_rol = r.id_rol "
                + " where username = ?";

        try (Connection conn = DBConnection.getDBConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, request.getUsername());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new UsuarioDTOResponse(
                        rs.getString("nombre_completo"),
                        rs.getString("password_hash"),
                        rs.getString("nombre_rol")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar con la base de datos: " + e.getMessage());
        }
        return null;
    }

    public boolean save(Usuario usuario) {
        boolean estado = false;
        String sql = "insert into usuarios values(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getDBConnection(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, usuario.getIdUser());
            pstm.setString(2, usuario.getNombre());
            pstm.setString(3, usuario.getApellido());
            pstm.setString(4, usuario.getUsername());
            pstm.setString(5, usuario.getPasswordHash());
            pstm.setString(6, usuario.getEmail());

            int filasAfectadas = pstm.executeUpdate();
            
            if (filasAfectadas > 0) {
                estado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar con la base de datos: " + e.getMessage());
            estado = false;
        }
        return estado;
    }
}