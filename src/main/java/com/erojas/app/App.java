package com.erojas.app;

import java.util.List;


import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaServiceImpl;
import com.erojas.util.Conexion;

public class App {
	public static void main(String [] args) {
		Conexion cn = new Conexion();
		if(cn.cerrarConexion()!=null) {
			System.out.println("Conexion OK");
		}

		
		PersonaService dao = new PersonaServiceImpl();
		List<Persona> lista =dao.findAll();
		System.out.println("------------------- LISTA -----------------");
		lista.stream().forEach(p -> System.out.println(p.getId() +" - " + p.getNombre())); 
		System.out.println("------------------------------------");
		if(dao.getOne(4)!=null) {
			System.out.println("No Vacio"  );
		}else {
			System.out.println(" Vacio" );
		}

		
		System.out.println(dao.generateId());
	}
}
