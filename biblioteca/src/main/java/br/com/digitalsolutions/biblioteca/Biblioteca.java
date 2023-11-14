/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.digitalsolutions.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Silas Rodrigues
 */
public class Biblioteca {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("conf.properties")));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
}
    