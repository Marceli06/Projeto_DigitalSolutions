package br.com.digitalsolutions.biblioteca;

/**
 *
 * @author Silas
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UsuarioDB {

    private Properties properties;

    private int id, tipo;
    private String nome,senha;
    
    public UsuarioDB(Properties properties){
        this.properties = properties;
    }
    
    public void dadosUsuario(Usuario s) throws Exception{
        int id = 0;
        String nome = "";
        String email = "";
        String senha = "";
        int tipo = 0;
        
        
        var fabrica = new ConnectionFactory(properties);
        
        try(var conexao = fabrica.conectar()){
            
            String sql = "SELECT * FROM usuario_simples WHERE nome = ?;";
            try(var ps = conexao.prepareStatement(sql)){
                
                ps.setString(1, s.getNome());
                // executa um select
                try(ResultSet rs = ps.executeQuery();){
                    while (rs.next()) {
                        id = rs.getInt("id");
                        nome = rs.getString("nome");
                        email = rs.getString("email");
                        senha = rs.getString("senha");
                        tipo = rs.getInt("tipo");
                    }
                }
            }
            
            // itera no ResultSet
            Usuario use = new Usuario(id, nome, email, senha, tipo);
            this.id = id;
            this.nome = nome;
            this.senha = senha;
            this.tipo = tipo;
        }
    }
    
    public void cadastarUsuario(UsuarioCadastrado use) throws Exception{
        
        
        var fabrica = new ConnectionFactory(properties);
        
        
        try(var conexao = fabrica.conectar()){
            
            String sql = "INSERT INTO usuario_simples (nome,email,senha,tipo) values ( ?, ?, ?, ?)";
            
            try(var ps = conexao.prepareStatement(sql)){
                
       
                ps.setString(1, use.getNome());
                ps.setString(2, use.getEmail());
                ps.setString(3, use.getSenha());
                ps.setInt(4, use.getTipo());

                ps.execute();
            }
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
