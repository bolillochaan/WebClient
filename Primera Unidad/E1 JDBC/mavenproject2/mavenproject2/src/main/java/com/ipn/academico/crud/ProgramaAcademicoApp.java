package com.ipn.academico.crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramaAcademicoApp {
    private static final String SQL_INSERT = "INSERT INTO ProgramaAcademico (nombre, descripcion, fecha) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE ProgramaAcademico SET nombre=?, descripcion=?, fecha=? WHERE idProgramaAcademico=?";
    private static final String SQL_DELETE = "DELETE FROM ProgramaAcademico WHERE idProgramaAcademico=?";
    private static final String SQL_SELECT = "SELECT * FROM ProgramaAcademico WHERE idProgramaAcademico=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ProgramaAcademico";

    private Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/7CM1?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String usuario = "root";
        String clave = "chorizo12";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error en la conexión con la base de datos.", e);
        }
    }

    public void create(ProgramaAcademico programa) throws SQLException {
        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {
            ps.setString(1, programa.getNombre());
            ps.setString(2, programa.getDescripcion());
            ps.setDate(3, new java.sql.Date(programa.getFecha().getTime()));
            ps.executeUpdate();
        }
    }

    public void update(ProgramaAcademico programa) throws SQLException {
        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, programa.getNombre());
            ps.setString(2, programa.getDescripcion());
            ps.setDate(3, new java.sql.Date(programa.getFecha().getTime()));
            ps.setLong(4, programa.getIdProgramaAcademico());
            ps.executeUpdate();
        }
    }

    public void delete(Long id) throws SQLException {
        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(SQL_DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    public List<ProgramaAcademico> readAll() throws SQLException {
        List<ProgramaAcademico> lista = new ArrayList<>();
        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProgramaAcademico programa = new ProgramaAcademico();
                programa.setIdProgramaAcademico(rs.getLong("idProgramaAcademico"));
                programa.setNombre(rs.getString("nombre"));
                programa.setDescripcion(rs.getString("descripcion"));
                programa.setFecha(rs.getDate("fecha"));
                lista.add(programa);
            }
        }
        return lista;
    }

    public ProgramaAcademico read(Long id) throws SQLException {
        ProgramaAcademico programa = null;
        try (Connection con = obtenerConexion();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                programa = new ProgramaAcademico();
                programa.setIdProgramaAcademico(rs.getLong("idProgramaAcademico"));
                programa.setNombre(rs.getString("nombre"));
                programa.setDescripcion(rs.getString("descripcion"));
                programa.setFecha(rs.getDate("fecha"));
            }
        }
        return programa;
    }
}
