import java.util.Scanner;

import game.Game;
import game.Tower;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opt;
        int disksNumber = 0;

        do {
            System.out.println("1 - Play\n2 - Challenge Bot\n3 - Configure disks number\n4 - Exit");
            System.out.print("Options: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    if (disksNumber == 0) {
                        System.err.println("Configure disks number in the option 3!");
                        break;
                    }
                    play(disksNumber, sc);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("Insert the number of disks: ");
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
            System.out.println("Make your movement:\n1 - move\n2 - help\n3 - leave");
            System.out.print("Option: ");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Origin: ");
                    int origem = sc.nextInt();
                    System.out.print("Destination: ");
                    int destino = sc.nextInt();

                    g.move(Tower.values()[origem - 1], Tower.values()[destino - 1]);
                    break;
                case 2:
                    System.out.println("HOW TO PLAY?");
                    System.out.println("RULE 1: You can only move the disk that is on top.\nRULE 2: The destination where the disk will be placed must not contain a disk of lesser value on top.");
                    System.out.println("NOTE: The source is the tower from which you want to remove the disk, the destination is where you will place this disk.");
                    break;
                case 3:
                    System.out.println("Leaving...");
                default:
                    break;
            }
        } while(!g.isGameFinished() && opt != 3);

        if (g.isGameFinished()) {
            System.out.println("---------------------------------");
            System.out.println("Congratulations, you win the challenge!");
            System.out.println("---------------------------------");
        }
    }
}
