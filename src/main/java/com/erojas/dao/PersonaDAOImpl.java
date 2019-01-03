package com.erojas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.erojas.model.Persona;
import com.erojas.util.Conexion;

public class PersonaDAOImpl implements PersonaDAO{

	private Connection cn;
	
	public PersonaDAOImpl() {
		cn=Conexion.conectar();
	}
	
	@Override
	public int save(Persona persona) {
		String sql = "insert into persona (id,nombre) values (?,?)";
		int flag=0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, persona.getId());
			ps.setString(2, persona.getNombre());
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		
	}

	@Override
	public int deleteById(Integer id) {
		String sql = " delete from persona where id=?";
		int flag=0;
				try {
					PreparedStatement ps = cn.prepareStatement(sql);
					ps.setInt(1, id);
				flag=ps.executeUpdate();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return flag;
	}

	@Override
	public Persona getOne(Integer id) {
		Persona persona = new Persona();
		String sql = "select * from persona where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public List<Persona> findAll() {
		List<Persona> lista = new ArrayList<>();
		
		try {
			//PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			String sql = "select * from persona";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				lista.add(persona);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public int update(Persona persona) {
		String sql = "update persona set   nombre =? where id =?";
		int flag=0;
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, persona.getNombre());
			ps.setInt(2, persona.getId());
			flag=ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
		
	}

	@Override
	public int generateId() {
		//1  ? parametro de retorno
		String sql = "{call generateId(?)}";
		int id=0;
		try {
			CallableStatement cs = cn.prepareCall(sql);
			// 2 Definiendo el tipo de retorno
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			// 3 Obteniendo el valor definido 2
			id=cs.getInt(1);
			cs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
