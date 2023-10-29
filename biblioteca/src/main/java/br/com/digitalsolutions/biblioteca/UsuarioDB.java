package br.com.digitalsolutions.biblioteca;

/**
 *
 * @author Silas
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDB {
    private int id;
    private String nome;
    private String senha;
    
    public void dadosUsuario(String nomeLog, String senhaLog) throws Exception{
        int id = 0;
        String nome = "";
        String senha = "";
        
        
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
              senha = rs.getNString("senha");
            }
            
            this.id = id;
            this.nome = nome;
            this.senha = senha;
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
}
