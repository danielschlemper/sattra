package br.com.sattra.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sattra.model.Cliente;

public class ClienteDAO {

	
	 public void inserirCliente(Cliente cliente) {
	        try {
	            PreparedStatement preparedStatement = 
	            		ConexaoDAO.getConection().prepareStatement(Cliente.inserirCliente());
	            preparedStatement.setString(1,  cliente.getNome());
	            preparedStatement.setString(2,  cliente.getContatos());
	            preparedStatement.setLong(3,  cliente.getCpf());
	            preparedStatement.setString(4,  cliente.getTelefone());
	            preparedStatement.setString(5,  cliente.getEmail());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }	         
	    }
}
