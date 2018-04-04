 package br.com.sattra.model;

import java.io.Serializable;

public class Cliente implements Serializable {
      
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private long codCliente;	
	private String nome;
     private String cpf;
     private String contatos;
     private String telefone;
     private String email;
     private Endereco endereco;
   
     public long getCodCliente() {
 		return codCliente;
 	}

 	public void setCodCliente(long codCliente) {
 		this.codCliente = codCliente;
 	}
     public String getNome() {
          return nome;
     }
      
     public void setNome(String nome) {
          this.nome = nome;
     }
      
     public String getContatos() {
         return contatos;
    }
     
    public void setContatos(String contatos) {
         this.contatos = contatos;
    }
     public String getCpf() {
          return cpf;
     }
      
     public void setCpf(String cpf) {
          this.cpf = cpf;
     }
      
     public String getTelefone() {
          return telefone;
     }
      
     public void setTelefone(String telefone) {
          this.telefone = telefone;
     }
     public String getEmail() {
         return email;
    }
     
    public void setEmail(String email) {
         this.email = email;
    }
      
     public Endereco getEndereco() {
         return endereco;
     }
      
    public void setEndereco(Endereco endereco) {
         this.endereco = endereco;
     }
      
     public static String inserirCliente() {
    	 
    	 String sql = "INSERT INTO cliente (nome, contatos, cpf, telefone, email, cod_endereco) VALUES (?,?,?,?,?,?);";
    	 return sql;
     }
     public static String listarCliente() {
    	 
    	 String sql = "SELECT nome, contatos, cpf, telefone, email FROM cliente ";
    	 return sql;
     }
     @Override
     public String toString() {
     return "Cliente:" + getNome()  +" CPF:" + getCpf();
     }
}