package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /**
         *  Monte Carlo simulation calculating the probability of drawing
         *  3 marbles of the same colour from a bowl of 6 marbles, 3 blue, 3 white.
         *  Marbles are not replaced once drawn
         * */

        System.out.println("Probability of drawing 3 marbles of the same colour");
        System.out.println("100 trials: " + marbleSimulation(100));
        System.out.println("1000 trials: " + marbleSimulation(1000));
        System.out.println("10000 trials: " + marbleSimulation(10000));
    }

    public static String marbleSimulation(int numberTrials) {

        // Variables represent blue and white marbles
        final int blue = 1;
        final int white = 2;

        // number var records number of success all 3 marbles are the same colour.
        // result var takes the number of success devided by the numberTrials var.
        double number = 0.0;
        double result = 0.0;


        for (int t = 0; t < numberTrials; t++) {

            result++;

            // Array containing 3 marbles of each color
            int[] bowl = { blue, blue, blue, white, white, white };
            // Amount of drawn marbles out of the bowl
            int[] drawMarbles = new int[3];

            //  Runs 3 times to draw 3 random marbles.
            for (int draw = 0; draw < 3; draw++) {

                // Generate random number as index and pass to bowl Array
                int index = (int) (Math.random() * bowl.length);
                // Place into Array that has 3 marbles drawn
                drawMarbles[draw] = bowl[index];
                // Recreate bowl to remove the latest marble.
                int[] newBowl = new int[bowl.length - 1];
                int j = 0;

                for (int i = 0; i < bowl.length; i++) {

                    // If marble was drawn, then skip
                    if (i == index) {
                        continue;
                    }

                    // Reassign bowl Array to newBowl
                    newBowl[j] = bowl[i];
                    j++;
                }
                bowl = newBowl;
            }

            // Draw 3 marbles and check if they are the same
            if (drawMarbles[0] == drawMarbles[1] && drawMarbles[1] == drawMarbles[2]) {

                // If the same, add one to success
                number++;
            }
//            System.out.println(Arrays.toString(drawMarbles));
        }

        return "Results: " + (number / result);
    }
}
