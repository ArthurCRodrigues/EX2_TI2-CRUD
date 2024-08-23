package dao;

import java.sql.*;
import model.Usuario;

public class UsuarioDAO extends DAO {

    public UsuarioDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public boolean insert(Usuario usuario) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO biblioteca (\"Author\", \"Title\", \"Year\", \"Code\") "
                    + "VALUES ('" + usuario.getAuthor() + "', '" + usuario.getTitle() + "', " 
                    + usuario.getYear() + ", " + usuario.getCode() + ");";
            st.executeUpdate(sql);
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public Usuario get(int code) {
        Usuario usuario = null;
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM biblioteca WHERE \"Code\" = " + code;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                usuario = new Usuario(rs.getString("Author"), rs.getString("Title"), rs.getInt("Year"), rs.getInt("Code"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }

    public boolean update(Usuario usuario) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE biblioteca SET \"Author\" = '" + usuario.getAuthor() + "', \"Title\" = '" 
                        + usuario.getTitle() + "', \"Year\" = " + usuario.getYear() 
                        + " WHERE \"Code\" = " + usuario.getCode();
            st.executeUpdate(sql);
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int code) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM biblioteca WHERE \"Code\" = " + code;
            st.executeUpdate(sql);
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}
