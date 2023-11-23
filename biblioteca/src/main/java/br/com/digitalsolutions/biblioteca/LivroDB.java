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
        String sql = "INSERT INTO Livro(titulo,autor,genero,editora) VALUES (?,?,?,?);";
        
        var fabrica = new ConnectionFactory(properties);
        
        try(var conexao = fabrica.conectar()){
            var ps = conexao.prepareStatement(sql);    
        
           
            ps.setString(1,livro.getTitulo());
            ps.setString(2,livro.getAutor());
            ps.setString(3,livro.getGenero());
            ps.setString(4,livro.getEditora());
            
            ps.execute();
            
        }
    }
    
//    public void ExibirLivros(JTable tabela){
//        
//        DefaultTableModel model =(DefaultTableModel) tabela.getModel();
//        model.setNumRows(0);
//        
//        var fabrica = new ConnectionFactory(properties);
//        
////        try(var conexao = fabrica.conectar()){
////            
////            String sql = "SELECT * FROM Livros ";
////            try(var ps = conexao.prepareStatement(sql)){
////                
////                ps.setString(1, s.getNome());
////                // executa um select
////                try(ResultSet rs = ps.executeQuery();){
////                    while (rs.next()) {
////                        id = rs.getInt("id");
////                        nome = rs.getString("nome");
////                        email = rs.getString("email");
////                        senha = rs.getString("senha");
////                        tipo = rs.getInt("tipo");
////                    }
////                }
////            }
//            
//            // itera no ResultSet
////            Usuario use = new Usuario(id, nome, email, senha, tipo);
////            this.id = id;
////            this.nome = nome;
////            this.senha = senha;
////            this.tipo = tipo;
//        }
    }

