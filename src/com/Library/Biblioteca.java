/*
 *
 *  @author Barbara Anger
 *  © Copyright 2019. All Rights reserved.
 *
 */
package com.Library;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        System.out.println("O que deseja fazer?\n");
        System.out.println("6 - Lista de livros");
        System.out.println("1 - Doar um livro");
        System.out.println("2 - Retirar um livro");
        System.out.println("3 - Devolver um livro");
        System.out.println("0 - Sair\n");

        Scanner input = new Scanner(System.in);
        boolean keep = true;
        Livro livro = new Livro();
        String option = input.nextLine();
        Library biblioteca = new Library();

        do {
                if(option.equals("6")) {
                    biblioteca.exibirLista();
                    break;
                }
                if(option.equals("1")) {
                    System.out.println("Digite o título do livro:");
                    livro.setTitulo(input.nextLine());
                    System.out.println("Digite o autor do livro:");
                    livro.setAutor(input.nextLine());
                    System.out.println("Digite o ano do livro:");
                    livro.setAno(input.nextLine());
                    System.out.println("Digite quem está com o livro:");
                    livro.setEmprestado(input.nextLine());
                    biblioteca.doarLivro(livro);
                    break;
                }
                if(option.equals("2")){
                    System.out.println("Digite o título do livro que deseja retirar");
                        biblioteca.retirar(input.nextLine());
                    break;
                }
//                case 2:
//                    System.out.println("Digite o título do livro que deseja retirar");
//                    b2 = opcao.nextLine();
////                    biblioteca.retirar(b2);
//                    break;
//                case 3:
//                    System.out.println("Digite o título do livro que deseja devolver");
//                    b2 = opcao.nextLine();
////                    biblioteca.devolveLivro(b2);
//                    break;
                if(option.equals("0")){
                    keep = false;
                    break;
                }
                else {
                System.out.println("Opção não encontrada.\n");
                break;
            }
        } while(keep);
    }
}