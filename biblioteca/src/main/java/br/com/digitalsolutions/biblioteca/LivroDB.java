/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalsolutions.biblioteca;

/**
 *
 * @author Sabrina
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LivroDB {
    private int id;
    private String titulo,autor,genero,editora;
    private Properties properties;
    
    public void LivroDB(Properties properties){
        this.properties = properties;
    }
    
    public void cadastrarLivro(Livro livro) throws Exception{
        
        var fabrica = new ConnectionFactory(properties);
      
        try(var conexao = fabrica.conectar()){
            
            String sql = "INSERT INTO Livro(titulo,autor,genero,editora) VALUES (?,?,?,?);";
            
            try(var ps = conexao.prepareStatement(sql)){
                
                // executa um select
                try(ResultSet rs = ps.executeQuery();){ 
                    
                
                    while (rs.next()) {    
        
           
                        ps.setString(1,livro.getTitulo());
                        ps.setString(2,livro.getAutor());
                        ps.setString(3,livro.getGenero());
                        ps.setString(4,livro.getEditora());

                        ps.execute();
            
                    }
                }
            
            }
        }
    }
    
    public void ExibirLivros(JTable tabela) throws Exception{
        
        DefaultTableModel model =(DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        
        var fabrica = new ConnectionFactory(properties);
        
        try(var conexao = fabrica.conectar()){
            
            String sql = "SELECT * FROM Livro";
            System.out.println("Teste 0");
            try(var ps = conexao.prepareStatement(sql)){
                
                // executa um select
                try(ResultSet rs = ps.executeQuery();){ 
                    
                
                    while (rs.next()) {
                        
                        model.addRow(new Object[] {
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("editora"),
                            rs.getString("genero"),
                            rs.getString("autor")
                        });
                    }
                }catch(Exception e){
                    System.out.println("Erro misterioso");
                }
            }catch(Exception e){
                System.out.println("Erro de conexão");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
         
    }
}

