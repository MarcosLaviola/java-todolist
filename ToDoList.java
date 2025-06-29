import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static class Tarefa {
        String descricao;
        boolean concluida;

        Tarefa(String descricao) {
            this.descricao = descricao;
            this.concluida = false;
        }

        void marcarConcluida() {
            this.concluida = true;
        }

        @Override
        public String toString() {
            return (concluida ? "[X] " : "[ ] ") + descricao;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- MENU TO-DO LIST ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    tarefas.add(new Tarefa(descricao));
                    System.out.println("Tarefa adicionada!");
                    break;
                case 2:
                    System.out.println("\n--- TAREFAS ---");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + tarefas.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa a marcar como concluída: ");
                    int numero = scanner.nextInt();
                    if (numero >= 1 && numero <= tarefas.size()) {
                        tarefas.get(numero - 1).marcarConcluida();
                        System.out.println("Tarefa marcada como concluída.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}