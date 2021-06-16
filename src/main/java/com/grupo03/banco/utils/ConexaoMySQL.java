package com.grupo03.banco.utils;

import java.sql.*;

public class ConexaoMySQL implements IMySQL {

    public static Connection getConexao() {
        Connection con = null;

        try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
        }

        return con;
    }

    public boolean fechar(Connection con) {
        return false;
    }

    public boolean fechar(Connection con, PreparedStatement pstm) {
        return false;
    }

    public boolean fechar(Connection con, PreparedStatement pstm, ResultSet res) {
        return false;
    }

}