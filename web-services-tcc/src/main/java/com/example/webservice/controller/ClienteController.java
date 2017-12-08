package com.example.webservice.controller;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import com.example.webservice.dao.ClienteDAO;
import com.example.webservice.model.Cliente;

//Classe responsável por ser o controlador entre o resource e a camada DAO
public class ClienteController {

	public ArrayList<Cliente> listarTodos() {
		System.out.println("passou ClienteController ArrayList");
		return ClienteDAO.getInstance().listarTodos();
	}
/*	public Cliente add() {
		System.out.println("passou ClienteController add");
		return ClienteDAO.getInstance().add(Cliente cliente);
	}
	*/	

}