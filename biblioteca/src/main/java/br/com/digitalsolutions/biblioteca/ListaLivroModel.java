/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalsolutions.biblioteca;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Silas
 */
public class ListaLivroModel implements Comparable <Livro>{
    
    private List<Livro> listaLivros;
    private String titulo;
    private int avaliacao;
    
    private String[] colunas = {"ID", "Titulo", "Editora", "Genero", "Autor"};

    public ListaLivroModel(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    

    @Override
    public int compareTo(Livro o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
