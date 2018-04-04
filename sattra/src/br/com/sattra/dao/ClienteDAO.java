package br.com.sattra.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.sattra.model.Cliente;

public class ClienteDAO {

	public void inserirCliente(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = ConexaoDAO.getConection().prepareStatement(Cliente.inserirCliente());
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getContatos());
			preparedStatement.setString(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getTelefone());
			preparedStatement.setString(5, cliente.getEmail());
			preparedStatement.setLong(6, cliente.getEndereco().getCodEndereco());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Cliente> buscarCliente(long cpf) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement pstm = null;
		try {
			
			pstm = ConexaoDAO.getConection().prepareStatement(Cliente.listarCliente() + " WHERE cpf=?;");
			pstm.setLong(1, cpf);
			ResultSet rs = pstm.executeQuery();
		        while (rs.next()) {
		        	Cliente cliente = new Cliente();
		        	cliente.setContatos(rs.getString("contatos"));
		        	cliente.setCpf(rs.getString("cpf"));
		        	cliente.setEmail(rs.getString("email"));
		        	cliente.setNome(rs.getString("nome"));
		        	cliente.setTelefone(rs.getString("telefone"));
		            clientes.add(cliente);
		            System.out.println("Entrou consulta "+cliente.getNome());
		        }
		        pstm.close();
			
		} catch (SQLException e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}			
		return clientes;
	}
	public List<Cliente> buscarCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement pstm = null;
		
		try {
			pstm = ConexaoDAO.getConection().prepareStatement(Cliente.listarCliente());
			
			ResultSet rs = pstm.executeQuery();
		        while (rs.next()) {
		        	Cliente cliente = new Cliente();
		        	cliente.setContatos(rs.getString("contatos"));
		        	cliente.setCpf(rs.getString("cpf"));
		        	cliente.setEmail(rs.getString("email"));
		        	cliente.setNome(rs.getString("nome"));
		        	cliente.setTelefone(rs.getString("telefone"));
		            clientes.add(cliente);
		        }
		        pstm.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}			
		return clientes;
	}

	public void salvarTXT(Cliente cliente) {

		FileWriter arq;
		try {
			System.out.println("Chegou aqui ");
			arq = new FileWriter("c:\\cliente\\cliente.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("+---Cliente------");
			gravarArq.printf("#");
			gravarArq.printf("Nome: " + cliente.getNome());
			gravarArq.printf("#");
			gravarArq.printf("Contatos: " + cliente.getContatos());
			gravarArq.printf("#");
			gravarArq.printf("CPF: " + cliente.getCpf());
			gravarArq.printf("#");
			gravarArq.printf("Telefone: " + cliente.getTelefone());
			gravarArq.printf("#");
			gravarArq.printf("Email: " + cliente.getEmail());
			gravarArq.printf("#");
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
