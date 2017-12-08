package com.example.webservice.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://ec2-54-221-229-64.compute-1.amazonaws.com:5432/d31nkksjqf1e6r?user=uedygixfwybrlw&password=8569a2289191915193a7541b044c88f2b5ce393f9b12b3d9009a15ca9afacba1&sslmode=require";
	private static final String USUARIO = "uedygixfwybrlw";
	private static final String SENHA = "8569a2289191915193a7541b044c88f2b5ce393f9b12b3d9009a15ca9afacba1";
	static String status="";
	// Método responsável por criar uma conexao com o banco

	 
	    
	    public static Connection getConnection(){
	    	 Connection conn = null;    	
	    	 
	    	 try {
				Class.forName("org.postgresql.Driver").newInstance();				
				conn = (Connection) DriverManager.getConnection(URL,"USUARIO","SENHA");
				status = "Connection opened";
			} catch (SQLException e) {
				// TODO: handle exception
				status = e.getMessage();
			}catch (ClassNotFoundException e){
				status = e.getMessage();
			}catch (Exception e) {
				// TODO: handle exception
				status = e.getMessage();				
			}
	    	 return conn;
	    }
}
