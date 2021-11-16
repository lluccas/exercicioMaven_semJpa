package dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Estoque;
import solucoes.Conexao;

public class EstoqueDao {

	public void cadastrar(Estoque es) {
		try {
			Conexao conexao = new Conexao();
			String sql = "INSERT INTO estoque(marca,modelo,cor,memoriaInterna,memoriaRam,cameraTraseira,cameraFrontal,tela,processador,quantidade,preco) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

			ps.setString(1, es.getMarca());
			ps.setString(2, es.getModelo());
			ps.setString(3, es.getCor());
			ps.setString(4, es.getMemoriaInterna());
			ps.setString(5, es.getMemoriaRam());
			ps.setString(6, es.getCameraTraseira());
			ps.setString(7, es.getCameraFrontal());
			ps.setDouble(8, es.getTela());
			ps.setString(9, es.getProcessador());
			ps.setInt(10, es.getQuantidade());
			ps.setDouble(11, es.getPreco());

			ps.execute();

			System.out.println("Produto(s) cadastrado(s) com sucesso!!!!!!!");

		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

	public List<Estoque> listarDB() {
		List<Estoque> est = new ArrayList<>();
		try {
			Conexao conex = new Conexao();
			String sql = "SELECT * FROM estoque";
			PreparedStatement ps = conex.getConexao().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Estoque es = new Estoque();

				es.setId(rs.getInt("id"));
				es.setMarca(rs.getString("marca"));
				es.setModelo(rs.getString("modelo"));
				es.setCor(rs.getString("cor"));
				es.setMemoriaInterna(rs.getString("memoriaInterna"));
				es.setMemoriaRam(rs.getString("memoriaRam"));
				es.setCameraTraseira(rs.getString("cameraTraseira"));
				es.setCameraFrontal(rs.getString("cameraFrontal"));
				es.setTela(rs.getDouble("tela"));
				es.setProcessador(rs.getString("processador"));
				es.setQuantidade(rs.getInt("quantidade"));
				es.setPreco(rs.getDouble("preco"));

				est.add(es);

			}

		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		return est;
	}
	
	public static List<Estoque> pesquisaMarca() {
		Scanner s = new Scanner(System.in);

		List<Estoque> est = new ArrayList<>();
		try {
			Conexao conex = new Conexao();
			String marca;
			System.out.println("Qual a marca que procura: ");
			marca = s.next();
			
			String sql = "SELECT * FROM 	estoque WHERE marca LIKE '" + marca + "%'";
			
			PreparedStatement ps = conex.getConexao().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Estoque es = new Estoque();

				es.setId(rs.getInt("id"));
				es.setMarca(rs.getString("marca"));
				es.setModelo(rs.getString("modelo"));
				es.setCor(rs.getString("cor"));
				es.setMemoriaInterna(rs.getString("memoriaInterna"));
				es.setMemoriaRam(rs.getString("memoriaRam"));
				es.setCameraTraseira(rs.getString("cameraTraseira"));
				es.setCameraFrontal(rs.getString("cameraFrontal"));
				es.setTela(rs.getDouble("tela"));
				es.setProcessador(rs.getString("processador"));
				es.setQuantidade(rs.getInt("quantidade"));
				es.setPreco(rs.getDouble("preco"));

				est.add(es);
			}

		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		return est;
	}

	public void editar(Estoque es, int id) {
		
		String sql = "UPDATE estoque SET marca = ?, modelo = ?, cor = ?, memoriaInterna = ?, memoriaRam = ?, cameraTraseira = ?, cameraFrontal = ?, tela = ?, processador = ?, quantidade = ?, preco = ? WHERE id = ?  ";
		
		try {
		Conexao conexao = new Conexao();

		PreparedStatement ps = conexao.getConexao().prepareStatement(sql);

		ps.setString(1, es.getMarca());
		ps.setString(2, es.getModelo());
		ps.setString(3, es.getCor());
		ps.setString(4, es.getMemoriaInterna());
		ps.setString(5, es.getMemoriaRam());
		ps.setString(6, es.getCameraTraseira());
		ps.setString(7, es.getCameraFrontal());
		ps.setDouble(8, es.getTela());
		ps.setString(9, es.getProcessador());
		ps.setInt(10, es.getQuantidade());
		ps.setDouble(11, es.getPreco());
		ps.setInt(12 , id);
		
		ps.execute();
		
		System.out.println("Produto com ID:" + id + " - Atualizado");

		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void excluir(Estoque es, int id) {
		try {
			Conexao conexao = new Conexao();
			String sql = "DELETE FROM estoque WHERE id = ?";

			PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ps.execute();
			
			System.out.println("ID-  " + id + " excluido do banco com sucesso!!!");
		}catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	
	
}
