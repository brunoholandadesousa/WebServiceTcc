package com.example.webservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.webservice.factory.ConnectionFactory;
import com.example.webservice.model.Cliente;

public class ClienteDAO extends ConnectionFactory {

	private static ClienteDAO instance = new ClienteDAO();;

	// Método responsável por criar uma instancia da classe ClienteDAO (Singleton)

	public static ClienteDAO getInstance() {
		return instance;
	}

	// Método responsável por listar todos os clientes do banco

	public ArrayList<Cliente> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Cliente> clientes = null;

		conexao = getConnection();

		clientes = new ArrayList<Cliente>();
		try {
			pstmt = conexao.prepareStatement("SELECT * FROM dispositivos_historico order by currentdate desc");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rs.getInt("id"));
				cliente.setId_dispositivos(rs.getInt("id_dispositivo"));
				cliente.setLatitude(rs.getDouble("latitude"));
				cliente.setLongitude(rs.getDouble("longitude"));
				cliente.setData(rs.getString("currentdate"));

				clientes.add(cliente);
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {

			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}
	
	// Método responsável por listar pelo o Id do dispositivo 
	public void getOriginalPosition(Cliente cliente) {
		Connection conexao = null;
		conexao = getConnection();
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM dispositivos where id_dispositivo = ?");
			pstmt.setInt(1, cliente.getId());			
			rs = pstmt.executeQuery();

			if (rs.next()) {				
				cliente.setId_dispositivos(rs.getInt("id_dispositivo"));
				cliente.setLatitude(rs.getDouble("latitude"));
				cliente.setLongitude(rs.getDouble("longitude"));			

			}

		} catch (Exception e) {
			System.out.println("Erro ao listar o clientes: " + e);
			e.printStackTrace();
		} finally {

			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	// Método responsável por adicionar no banco
	public void add(Cliente cliente) {
		Connection conexao = null;
		conexao = getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conexao.prepareStatement("INSERT INTO dispositivos_historico (id_dispositivo,latitude,longitude, currentdate) VALUES (?,?,?,?)");
			pstmt.setInt(1, cliente.getId());
			pstmt.setDouble(2, cliente.getLatitude());
			pstmt.setDouble(3, cliente.getLongitude());
			pstmt.setString(4, cliente.getData());
			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao adicionar: " + e);
			e.printStackTrace();

		} finally {

			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
