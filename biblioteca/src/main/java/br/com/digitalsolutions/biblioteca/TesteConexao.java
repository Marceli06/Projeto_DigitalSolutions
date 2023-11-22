/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalsolutions.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class TesteConexao {
    public static void main(String[] args){
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("conf.properties")));
            var factory = new ConnectionFactory(properties);
            var minhaConexao = factory.conectar();
            JOptionPane.showMessageDialog(
                    null,"Conectou!!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                    null, 
                    e.getMessage()
            );
            e.printStackTrace();
        }
    }
}
