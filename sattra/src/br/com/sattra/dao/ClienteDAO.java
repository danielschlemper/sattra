package br.com.sattra.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.com.sattra.model.Cliente;

public class ClienteDAO {

	public void inserirCliente(Cliente cliente) {
		try {
			PreparedStatement preparedStatement = ConexaoDAO.getConection().prepareStatement(Cliente.inserirCliente());
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getContatos());
			preparedStatement.setLong(3, cliente.getCpf());
			preparedStatement.setString(4, cliente.getTelefone());
			preparedStatement.setString(5, cliente.getEmail());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void salvarTXT(Cliente cliente) {
	

		FileWriter arq;
		try {
			System.out.println("Chegou aqui ");
			arq = new FileWriter("c:\\cliente\\cliente.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.printf("+---Cliente------");
			gravarArq.printf("#");
			gravarArq.printf("Nome: "+cliente.getNome());
			gravarArq.printf("#");
			gravarArq.printf("Contatos: "+cliente.getContatos());
			gravarArq.printf("#");
			gravarArq.printf("CPF: "+cliente.getCpf());
			gravarArq.printf("#");
			gravarArq.printf("Telefone: "+cliente.getTelefone());
			gravarArq.printf("#");
			gravarArq.printf("Email: "+cliente.getEmail());
			gravarArq.printf("#");

			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
}
