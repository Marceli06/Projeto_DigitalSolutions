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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LivroDB {
    private int id;
    private String titulo,autor,genero,editora,avaliacao;
    private Properties properties;
    private List <Livro> lista = new ArrayList<>();
    
    
    public LivroDB(java.util.Properties properties){
        this.properties = properties;
    }
    
    public void cadastrarLivro(Livro livro) throws Exception{
        
        var fabrica = new ConnectionFactory(properties);
      
        try(var conexao = fabrica.conectar()){
            
            String sql = "INSERT INTO Livro(titulo,autor,genero,editora) VALUES (?,?,?,?);";
            
            try(var ps = conexao.prepareStatement(sql)){
                
                ps.setString(1,livro.getTitulo());
                ps.setString(2,livro.getAutor());
                ps.setString(3,livro.getGenero());
                ps.setString(4,livro.getEditora());

                ps.execute();
            }
        }
    }
    
    public List<Livro> ExibirLivros() throws Exception{
        int i = 0;
        var fabrica = new ConnectionFactory(properties);
        StringBuilder sb = new StringBuilder();
        
        
        try(var conexao = fabrica.conectar()){
            
            String sql = "SELECT * FROM Livro";

            try(var ps = conexao.prepareStatement(sql)){
                
                // executa um select
                try(ResultSet rs = ps.executeQuery();){ 
                
                    while (rs.next()) {
                       
                        id = rs.getInt("id");
                        titulo = rs.getString("titulo");
                        editora = rs.getString("editora");
                        genero = rs.getString("genero");
                        autor = rs.getString("autor");
                        avaliacao = rs.getString("avaliacao");
                        
                        //Livro livro = new Livro(id, titulo, editora, genero, autor);
                        Livro l = new Livro(titulo,editora,genero,autor,avaliacao);
                        //sb.append(l.getTitulo() + " \n" + l.getEditora());
                        lista.add(l);
                        //sb.append();

                        /*for(Livro a : lista){
                            System.out.println(a.getTitulo() + " " + a.getEditora());
                            JOptionPane.showMessageDialog(null, l.getTitulo());
                        }*/
                        
                    }
                return lista;
                
                }catch(Exception e){
                    System.out.println("Erro misterioso");
                }
            }catch(Exception e){
                System.out.println("Erro de conexão");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return lista;
    }
    
    /*public List<Livro> obterProdutosDoBanco() throws Exception{
        List<Livro> listaLivros = new ArrayList<>();

        var fabrica = new ConnectionFactory(properties);
        
        try(var conexao = fabrica.conectar()){
            
            String sql = "SELECT * FROM Livro";

            try(var ps = conexao.prepareStatement(sql)){
                
                // executa um select
                try(ResultSet rs = ps.executeQuery();){ 

                    while (rs.next()) {
                        Livro l = new Livro();
                        l.setId(rs.getInt("id"));
                        l.setTitulo(rs.getString("titulo"));
                        l.setEditora(rs.getString("editora"));
                        l.setGenero(rs.getString("genero"));
                        l.setAutor(rs.getString("autor"));

                        listaLivros.add(l);
                    }
                } 
            } 
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaLivros;
    }*/
    
    
    public void avaliar(Livro livro, String nome, String nota) throws Exception{
        var fabrica = new ConnectionFactory(properties);
      
        try(var conexao = fabrica.conectar()){
            
            String sql = "UPDATE `Livro` SET avaliacao = '"+ nota+"' WHERE `TITULO` = '"+ nome +"';";
            
            try(var ps = conexao.prepareStatement(sql)){
                
                
                //ps.setInt(1,livro.getAvaliacao());
                //ps.setString(2,nome);
                
                
                ps.execute();
            }
        }
    }
    

}

