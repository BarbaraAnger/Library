package com.Library;
/*
 *
 *  @author Barbara Anger
 *  © Copyright 2019. All Rights reserved.
 * /
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private String path = "./src/com/Resources/Biblioteca.txt";
    private List<Livro> livrosLista = new ArrayList<>();
    private int nextId;
    public String getPath() {
        return path;
    }

    public Library() {

    }

    public void setPath(String path) {
        this.path = path;
    }

    Livro livro = new Livro();

    public List<Livro> getLivrosLista() {
        return livrosLista;
    }

    public void setLivrosLista(List<Livro> livrosLista) {
        this.livrosLista = livrosLista;
    }

    public void atualizarLista(){
        String line = null;
        try(BufferedReader p = new BufferedReader(new FileReader(getPath()))){
            while((line = p.readLine()) != null){
                String[] partes = line.split(": ", 1);
                int id = Integer.parseInt(Arrays.toString(line.split(";"))); // parse string to int, it still doesnt work
                Livro livro = new Livro(id, partes[1], partes[2], partes[3], partes[4], partes[5]);
                livrosLista.add(livro);
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    public void doarLivro(Livro livro) {
        livrosLista.add(livro);
        cadastrarLivro(livro);
        System.out.println("Livro cadastrado!");
    }
    public int idCadastrado(){
        int numberIds = 0;
        try(BufferedReader p = new BufferedReader(new FileReader(getPath()))){
            String line = null;
            while ((line = p.readLine()) != null) {
                if(line.contains("ID: ")){
                    numberIds++;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return numberIds;
    }

    public void cadastrarLivro(Livro livro){
        this.atualizarLista();
        try(BufferedWriter p = new BufferedWriter(new FileWriter(this.getPath(),true))){
            livro.setRandomId(idCadastrado());
            livro.setStatus("emprestado");
            p.write("ID: " + livro.getID() + "; Titulo: " + livro.getTitulo() + "; Autor: " + livro.getAutor() + "; Ano: " + livro.getAno() + "; Emprestado para: " + livro.getEmprestado());
            p.newLine();
            System.out.println("ID: " + livro.getID() + "Título: " + livro.getTitulo() + "- Autor: " + livro.getAutor() + " - Ano: " + livro.getAno() + "Emprestado para: " + livro.getEmprestado());
            livrosLista.add(livro);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public boolean devolverLivro(int ID){
        Livro livro = buscarporId(ID);
        if(livro == null) {
            System.out.println("Livro não foi encontrado.");
            return false;
        }
        return true;
    }
    public Livro buscarporId(int ID) {
        for(Livro livro: livrosLista) {
            if(livro.getID() == ID) {
                return livro;
            }
        }
        return null;
    }

    public String exibirLista(){
        StringBuffer stringB = new StringBuffer();
        for(Livro livro: livrosLista){
            if(!livro.Emprestado()){
                stringB.append(livro);
            }
        }
        return stringB.toString();
    }

    public String retirar(String titulo){
        this.atualizarLista();
        for(Livro livro: livrosLista){
            if(!livro.Emprestado()) {
                if(livro.getTitulo().equals(titulo)){
                    livrosLista.add(livro);
                    livro.Emprestado();
                }
                System.out.println("Livro emprestado!");
            }
            else System.out.println("Livro não disponível.");
        }
        return "teste";
    }
}