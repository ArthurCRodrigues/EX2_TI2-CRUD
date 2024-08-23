package app;

import java.util.Scanner;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("Escolha sua opção!");
            System.out.println("1) Cadastrar novo livro");
            System.out.println("2) Informações de algum Livro");
            System.out.println("3) Atualizar livro existente");
            System.out.println("4) Descartar Livro");
            System.out.println("5) Sair\n");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nome do livro: ");
                    String nome = sc.nextLine();
                    System.out.println("Nome do Autor: ");
                    String nomeA = sc.nextLine();
                    System.out.println("Ano de lançamento: ");
                    int data = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Codigo do livro: ");
                    int code = sc.nextInt();
                    sc.nextLine();
                    Usuario novoLivro = new Usuario(nomeA, nome, data, code);
                    if (usuarioDAO.insert(novoLivro)) {
                        System.out.println("Livro cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o livro.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o código do livro: ");
                    code = sc.nextInt();
                    sc.nextLine();
                    Usuario livro = usuarioDAO.get(code);
                    if (livro != null) {
                        System.out.println("Informações do Livro:");
                        System.out.println(livro);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o código do livro que deseja atualizar: ");
                    code = sc.nextInt();
                    sc.nextLine();
                    livro = usuarioDAO.get(code);
                    if (livro != null) {
                        System.out.println("Atualize as informações do livro.");
                        System.out.println("Nome do livro: ");
                        nome = sc.nextLine();
                        System.out.println("Nome do Autor: ");
                        nomeA = sc.nextLine();
                        System.out.println("Ano de lançamento: ");
                        data = sc.nextInt();
                        sc.nextLine();
                        livro.setAuthor(nomeA);
                        livro.setTitle(nome);
                        livro.setYear(data);
                        if (usuarioDAO.update(livro)) {
                            System.out.println("Livro atualizado com sucesso!");
                        } else {
                            System.out.println("Erro ao atualizar o livro.");
                        }
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o código do livro que deseja descartar: ");
                    code = sc.nextInt();
                    sc.nextLine();
                    if (usuarioDAO.delete(code)) {
                        System.out.println("Livro descartado com sucesso!");
                    } else {
                        System.out.println("Erro ao descartar o livro.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
