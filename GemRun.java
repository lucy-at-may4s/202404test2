/* 202404 Test123123 */

/** Author: Pei-Yu Chen 
(lucychenhappy@gmail.com)
Assignment by Outlier.org */

import java.util.Scanner;
import java.lang.Math;

public class GemRun {

    public static void main(String[] args) {
        final int MAZE_SIZE = 20; // uneditable board size measurement

        // Scanner incantation
        Scanner input = new Scanner(System.in);

        // Ask user for player and gem positions
        // 'gem' is an int -1-19; if -1, randomize position
        // 'player' is an int -1-19; if -1, randomize position
        System.out.print("Enter 0-19 for gem position or -1 to randomize: ");
        int gem = input.nextInt();
        System.out.print("Enter 0-19 for player position or -1 to randomize: ");
        int player = input.nextInt();
        input.nextLine(); // Scanner incantation

        /* TODO: Initializing The Game
         * - Initialize the player and/or gem positions if user entered -1
         * - Print the starter board */
        
        if (gem == -1) {
            gem = (int) (Math.random() * MAZE_SIZE);
        }
        if (player == -1) {
            player = (int) (Math.random() * MAZE_SIZE);
            do {
                player = (int) (Math.random() * MAZE_SIZE);
            } while (player == gem);
        }
        System.out.println("_".repeat(player) + "P" + "_".repeat(19 - player));

        /* TODO: Progressing The Game
         * - Ask for player input
         * - Update variables and print messages accordingly
         * - Print the updated board */
        System.out.print("Enter a direction (left or right): ");
        String dir = input.nextLine();

        if (dir.equals("left")) {
          player -= 1;
        } else if (dir.equals("right")) {
          player += 1;
        }
        int distance = Math.abs(player - gem);
      
        do {
          if (distance >= 7) {
            System.out.println("Very cold!");
          } else if (distance == 1) {
            System.out.println("Very warm!");
          } 
          System.out.println("_".repeat(player) + "P" + "_".repeat(19 - player));
          
          System.out.print("Enter a direction (left or right): ");
          dir = input.nextLine();
          if (dir.equals("left")) {
            player -= 1;
          } else if (dir.equals("right")) {
            player += 1;
          }
          distance = Math.abs(player - gem);
        } while (distance != 0);
        
        /* TODO: Ending The Game
         * - Print the final board
         * - Print the victory message */
        if (distance == 0) {
          System.out.println("_".repeat(player) + "*" + "_".repeat(19 - player));
          System.out.println("Found the gem!");
        }

        // Scanner incantation finish
        input.close();
    }
}
