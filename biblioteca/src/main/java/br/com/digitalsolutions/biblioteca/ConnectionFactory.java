/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalsolutions.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionFactory {
//    private static final String host = "bancobiblioteca-sabrina-40e4.aivencloud.com";;;;;
//    private static final String port = "11750";
//    private static final String user = "avnadmin";
//    //maquinas da USJT: senha anima123
//    private static final String password = "AVNS_edQSfPhQZ4w6l0qR5Zx";
//    private static final String db = "defaultdb";
    
    
    private String host,port,db,user,password;
    
    public ConnectionFactory(java.util.Properties properties){
        this(
            properties.getProperty("HOST"),
            properties.getProperty("PORT"),
            properties.getProperty("DB"),
            properties.getProperty("USER"),
            properties.getProperty("PASSWORD")
        );
    }

    public ConnectionFactory(String host, String port, String db, String user, String password) {
        this.host = host;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
    }

    public Connection conectar() throws Exception {
        return DriverManager.getConnection(
        String.format(
            "jdbc:mysql://%s:%s/%s",
            host,
            port,
            db
        ),
            user, 
            password
        );
        
    }
    
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(
            new FileInputStream(new File("conf.properties"))
        );
        final String DB_HOST = properties.getProperty("HOST");
        final String DB_PORT = properties.getProperty("PORT");
        final String DB_NAME = properties.getProperty("DB");
        final String DB_USER = properties.getProperty("USER");
        final String DB_PASSWORD = properties.getProperty("PASSWORD");
        var fabrica = new ConnectionFactory(
            DB_HOST, 
            DB_PORT, 
            DB_NAME, 
            DB_USER, 
            DB_PASSWORD
        );
        System.out.println(fabrica.conectar());
    }
    
}
