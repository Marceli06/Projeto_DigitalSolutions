package br.com.digitalsolutions.biblioteca;

/**
 *
 * @author Silas
 */
public class Usuario {
    private int id;
    private String nome;
    private String emal;
    private String senha;
    private int tipo;
    
    public Usuario(int id, String nome, String email, String senha, int tipo){
        this.id = id;
        this.nome = nome;
        this.emal = email;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
}
