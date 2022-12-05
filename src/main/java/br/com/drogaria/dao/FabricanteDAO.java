package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	// METODO SALVAR
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}

	// METODO EXCLUIR
	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	// METODO EDITAR
	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}

	// METODO BUSCAR
	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;
	}

	// M…TODO PESQUISAR
	public ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao");
		sql.append("FROM fabricante");
		sql.append("ORDER BY descricao ASC");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		// A partir do Java 7 n„o precisa a segunda trava de seguranÁa no diamante new ArrayList<>()
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
		}
	}
	
	public static void main(String[] args) {
		/* Fabricante f1 = new Fabricante();
		Fabricante f2 = new Fabricante(); */

		/* f1.setDescricao("DESCRI√á√ÉO 1");
		f2.setDescricao("DESCRI√á√ÉO 2"); */

		FabricanteDAO fDAO = new FabricanteDAO();
		
		try {
			/* fDAO.salvar(f1);
			fDAO.salvar(f2);
			
			System.out.println("Resultado 1: " + f1);
			System.out.println("Resultado 2: " + f2);
			System.out.println("Os fabricantes foram salvos com sucesso!"); 
			System.out.println("Os fabricantes foram excluidos com sucesso!");
			System.out.println("O fabricante foi editado com sucesso!"); 
			System.out.println("A busca foi feita com sucesso!"); */
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
