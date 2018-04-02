package br.com.sattra.model;

public class Cliente {
      
	
     private String nome;
     private long cpf;
     private String contatos;
     private String telefone;
     private String email;
     //private Endereco endereco;
   
      
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
     public long getCpf() {
          return cpf;
     }
      
     public void setCpf(long cpf) {
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
      
    // public Endereco getEndereco() {
     //     return endereco;
    // }
      
    // public void setEndereco(Endereco endereco) {
   //       this.endereco = endereco;
   //  }
      
     public static String inserirCliente() {
    	 
    	 String sql = "INSERT INTO cliente (nome, contatos, cpf, telefone, email) VALUES (?,?,?,?,?);";
    	 return sql;
     }
}