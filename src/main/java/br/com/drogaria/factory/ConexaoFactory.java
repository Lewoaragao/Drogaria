package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "Root@mysql";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useTimezone=true&serverTimezone=UTC";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
