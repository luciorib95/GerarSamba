package br.com.logusinfo.consultas;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = ConnUtil.init();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão aberta com sucesso!");
                conn.close();
                System.out.println("Conexão fechada.");
            } else {
                System.out.println("Falha ao abrir conexão.");
            }
        } catch (ConnectionException | SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
