package de.jannik.goette.three;

import de.jannik.goette.shared.FileReader;

public class Main {

    private static final int[][] grid = new int[1000][1000]; //X,Y

    private static int x = 500;
    private static int y = 500;

    public static void main(String[] args) {
        final String input = new FileReader().readFile("three");
        final char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i = i + 2) {
            move(chars[i]);
        }

        x = 500;
        y = 500;
        for (int j = 1; j < chars.length; j = j + 2) {
            move(chars[j]);
        }

        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }

    private static void move(char c) {
        grid[x][y] = 1;

        switch(c) {
            case '^' -> {
                y++;
                grid[x][y] = 1;
            }
            case 'v' -> {
                y--;
                grid[x][y] = 1;
            }
            case '<' -> {
                x--;
                grid[x][y] = 1;
            }
            case '>' -> {
                x++;
                grid[x][y] = 1;
            }
        }
    }
}
