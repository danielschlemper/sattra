package br.com.sattra.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sattra.model.Endereco;

public class EnderecoDAO {

	
	public void inserirEndereco(Endereco endereco) {
		try {
			PreparedStatement preparedStatement = ConexaoDAO.getConection()
					.prepareStatement(Endereco.inserirEndereco());
			preparedStatement.setString(1, endereco.getCep());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setString(3, endereco.getNumero());
			preparedStatement.setString(4, endereco.getComplemento());
			preparedStatement.setString(5, endereco.getBairro());
			preparedStatement.setString(6, endereco.getLocalidade());
			preparedStatement.setString(7, endereco.getUf());
			preparedStatement.setString(8, endereco.getIbge());
			preparedStatement.setString(9, endereco.getGia());
			preparedStatement.setString(10, endereco.getUnidade());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String ultimoEnderecoInserido() {
		PreparedStatement st;
		String lastid = null;
		try {
			st = ConexaoDAO.getConection().prepareStatement("select MAX(cod_endereco) AS last_id from endereco ");
			ResultSet rs = st.executeQuery();			
			 while (rs.next()) {
				 lastid = rs.getString("last_id");
			 }
			// não funcionou não entendi por que mas não arrumei por causa do tempo
			//st = ConexaoDAO.getConection().prepareStatement("select last_insert_id() as last_id from endereco");
			//ResultSet rs = st.executeQuery();
			//lastid = rs.getString("last_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastid;
	}
}
