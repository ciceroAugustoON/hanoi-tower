import java.util.Scanner;

import game.Game;
import game.Tower;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int opt;
        int disksNumber = 0;

        do {
            System.out.println("1 - Jogar\n2 - Desafiar Bot\n3 - Configurar Número de Discos\n4 - Sair");
            System.out.print("Opção: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    if (disksNumber == 0) {
                        System.err.println("Configure o número de discos na opção 3!");
                        break;
                    }
                    play(disksNumber, sc);
                case 2:
                    break;
                case 3:
                    System.out.print("Insira o número de discos: ");
                    disksNumber = sc.nextInt();
                default:
                    break;
            }
        } while (opt != 4);
        sc.close();
    }

    public static void play(int disks, Scanner sc) {
        Game g = new Game(disks);
        int opt = 0;

        System.out.println("----Tower of Hanoi-----");
        do {
            System.out.println("-----------");
            g.see();
            System.out.println("-----------");
            System.out.println("Faça seu movimento:\n1 - mover\n2 - ajuda\n3 - sair");
            System.out.print("Opção: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Origem: ");
                    int origem = sc.nextInt();
                    System.out.print("Destino: ");
                    int destino = sc.nextInt();

                    g.move(Tower.values()[origem - 1], Tower.values()[destino - 1]);
                    break;
                case 2:
                    System.out.println("COMO JOGAR?");
                    System.out.println("REGRA 1: Você só pode mover o disco que esta no topo.\nREGRA 2: O destino ao qual o disco será colocado não deve conter um disco de menor valor no topo.");
                    System.out.println("OBS: A origem é a torre da qual você deseja retirar o disco, o destino aonde voce ira colocar este disco.");
                    break;
                case 3:
                    System.out.println("Saindo...");
                default:
                    break;
            }
        } while(!g.isGameFinished() && opt != 3);

        if (g.isGameFinished()) {
            System.out.println("---------------------------------");
            System.out.println("Parabéns, você concluiu o desafio!");
            System.out.println("---------------------------------");
        }
    }
}
