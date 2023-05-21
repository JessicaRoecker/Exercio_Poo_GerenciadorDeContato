import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeContatos {
    private Map<String, String> contatos;

    public GerenciadorDeContatos() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, String numeroTelefone) {
        contatos.put(nome, numeroTelefone);
        System.out.println("Contato adicionado: " + nome + " - " + numeroTelefone);
    }

    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            String numeroTelefone = contatos.remove(nome);
            System.out.println("Contato removido: " + nome);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void buscarContato(String nome) throws ContatoNaoEncontradoException {
        if (contatos.containsKey(nome)) {
            String numeroTelefone = contatos.get(nome);
            System.out.println("Número de telefone de " + nome + ": " + numeroTelefone);
        } else {
            throw new ContatoNaoEncontradoException("Contato não encontrado: " + nome);
        }
    }

    public void listarContatos() {
        System.out.println("Contatos:");
        for (Map.Entry<String, String> entry : contatos.entrySet()) {
            String nome = entry.getKey();
            String numeroTelefone = entry.getValue();
            System.out.println(nome + " - " + numeroTelefone);
        }
    }

    public void gravarContatos() {
        try {
            FileOutputStream fileOut = new FileOutputStream("contatos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(contatos);
            out.close();
            fileOut.close();
            System.out.println("Contatos gravados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar contatos: " + e.getMessage());
        }
    }

    public void lerContatos() {
        try {
            FileInputStream fileIn = new FileInputStream("contatos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            contatos = (Map<String, String>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Contatos lidos com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler contatos: " + e.getMessage());
        }
    }

}

