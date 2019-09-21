package com.Library;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 *
 *  @author Barbara Anger
 *  © Copyright 2019. All Rights reserved.
 * /
 */
public class Livro {
    private int ID;
    private String titulo;
    private String autor;
    private String ano;
    private String status;
    private String emprestado_para;
    public boolean Emprestado;

    public boolean Emprestado() {return Emprestado == true;}

    public List<Autor> autores;

    public Livro() {
    }

    public Livro(int ID, String titulo, String autor, String ano, String status, String emprestado_para){
        this.titulo = titulo;
        this.ID = ID;
        this.autor = autor;
        this.ano = ano;
        this.status = status;
        this.emprestado_para = emprestado_para;
    }
    public int getID(){
        return ID;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getAno(){
        return ano;
    }
    public String getStatus(){
        return status;
    }
    public String getEmprestado(){
        return emprestado_para;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setRandomId(int numberIds){
        final AtomicInteger idGenerator = new AtomicInteger(numberIds);
        this.setID(idGenerator.getAndIncrement());
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setAno(String ano){
        this.ano = ano;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setEmprestado(String emprestado_para){
        this.emprestado_para = emprestado_para;
    }

    @Override
    public String toString() {
        return "Autor: " + this.getAutor() + " - Titulo: " + this.getTitulo() + " - ID: " + this.getID() + "Emprestado para: " + this.getEmprestado();
    }
}