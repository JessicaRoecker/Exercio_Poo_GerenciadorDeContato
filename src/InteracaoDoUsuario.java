import java.util.Scanner;

public class InteracaoDoUsuario {
    public static void main(String[] args) {
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Listar contatos");
            System.out.println("5 - Gravar contatos");
            System.out.println("6 - Ler contatos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o número de telefone:");
                    String numeroTelefone = scanner.nextLine();
                    gerenciador.adicionarContato(nome, numeroTelefone);
                    break;
                case 2:
                    System.out.println("Digite o nome do contato a ser removido:");
                    String nomeRemover = scanner.nextLine();
                    gerenciador.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.println("Digite o nome do contato a ser buscado:");
                    String nomeBuscar = scanner.nextLine();
                    try {
                        gerenciador.buscarContato(nomeBuscar);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    gerenciador.listarContatos();
                    break;
                case 5:
                    gerenciador.gravarContatos();
                    break;
                case 6:
                    gerenciador.lerContatos();
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}

class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

