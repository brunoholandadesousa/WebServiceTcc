package com.example.webservice.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.webservice.controller.ClienteController;
import com.example.webservice.dao.ClienteDAO;
import com.example.webservice.model.Cliente;

@CrossOrigin(origins="*")
@Controller
@RequestMapping("/cliente")
public class ClienteResource {
	// Método responsável por fazer chamada ao controller

	@RequestMapping(method=RequestMethod.GET, path="/listarTodos", 
			produces= {"application/json"} )
	@ResponseBody
	public ArrayList<Cliente> listarTodos() {		
		ArrayList<Cliente> list = new ClienteController().listarTodos();		
		return list;
	}		
	
	@RequestMapping(method=RequestMethod.GET, path="/listarId", 
			produces= {"application/json"} )
	@ResponseBody
	public Cliente getById (@RequestParam(value="id_dispositivo")int id_dispositivos) {
		Cliente cliente = new Cliente(id_dispositivos);
		ClienteDAO clientedao = new ClienteDAO();
		clientedao.getOriginalPosition(cliente);
		return cliente;
		
		
	}
	@RequestMapping(method=RequestMethod.GET, path="/add", 
			produces= {"application/json"} )
	@ResponseBody
	public void cliente (@RequestParam(value = "id_dispositivo")int id,@RequestParam(value = "longitude") double longitude,@RequestParam(value = "latitude")double latitude, @RequestParam(value = "currentdate") String data) {		
		
		Cliente cliente = new Cliente (id, longitude, latitude, data);
		ClienteDAO clienteDao = new ClienteDAO();		
		clienteDao.add(cliente);	
		System.out.println("Salvo com sucesso: "+latitude +""+latitude+""+data);
		

	}

	
	
}