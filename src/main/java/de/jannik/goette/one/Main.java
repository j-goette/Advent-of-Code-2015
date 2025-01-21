package de.jannik.goette.one;

import de.jannik.goette.shared.FileReader;

public class Main {

    public static void main(String[] args) {
        final String input = new FileReader().readFile();

        int floor = 0;
        boolean found = false;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            switch (letter) {
                case '(' -> floor++;
                case ')' -> floor--;
            }

            if (floor < 0 && !found) {
                found = true;
                System.out.println(i + 1);
            }
        }
        System.out.println(floor);
    }
}















//(()) and ()() both result in floor 0.
//        ((( and (()(()( both result in floor 3.
//        ))((((( also results in floor 3.
//        ()) and ))( both result in floor -1 (the first basement level).
//        ))) and )())()) both result in floor -3.