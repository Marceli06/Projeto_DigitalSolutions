package br.com.digitalsolutions.biblioteca;

/**
 *
 * @author Silas
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB {
    private int id;
    private String nome;
    private String senha;
    private int tipo;
    
    public void dadosUsuario(String nomeLog, String senhaLog) throws Exception{
        int id = 0;
        String nome = "";
        String email = "";
        String senha = "";
        int tipo = 0;
        
        
        String sql = "SELECT * FROM usuario_simples WHERE nome = ?;";
        
        try(
            var conexao = new ConnectionFactory().conectar();
            var ps = conexao.prepareStatement(sql);
                
        ){
            ps.setString(1, nomeLog);
            // executa um select
            ResultSet rs = ps.executeQuery();
            
            // itera no ResultSet
            while (rs.next()) {
              id = rs.getInt("id");
              nome = rs.getString("nome");
              email = rs.getString("email");
              senha = rs.getString("senha");
              tipo = rs.getInt("tipo");
            }
            Usuario use = new Usuario(id, nome, email, senha, tipo);
            this.id = id;
            this.nome = nome;
            this.senha = senha;
            this.tipo = tipo;
        }
    }
    
    public void cadastarUsuario(UsuarioCadastrado use) throws Exception{
        
        String sql = "INSERT INTO usuario_simples (nome,email,senha,tipo) values ( ?, ?, ?, ?)";
        
        try(
            var conexao = new ConnectionFactory().conectar();
            var ps = conexao.prepareStatement(sql);
                
        ){
            ps.setString(1, use.getNome());
            ps.setString(2, use.getEmail());
            ps.setString(3, use.getSenha());
            ps.setInt(4, use.getTipo());
            
            ps.execute();
        }
    }
    
    public int getId(){
        return this.id;
    }
    
    public  String getNome(){
        return this.nome;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public int getTipo(){
        return tipo;
    }
}
