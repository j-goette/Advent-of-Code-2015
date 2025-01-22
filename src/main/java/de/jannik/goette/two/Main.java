package de.jannik.goette.two;

import de.jannik.goette.shared.FileReader;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        final String   input = new FileReader().readFile("two");
        final String[] lines = input.split("\n");

        int result = 0, ribbon = 0;
        for (String line : lines) {
            final String[] numbers = line.split("x");
            final Rect     rect    = new Rect(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));

            final int firstDimension    = 2 * rect.length() * rect.width();
            final int secondDimension   = 2 * rect.width() * rect.height();
            final int thirdDimension    = 2 * rect.height() * rect.length();
            final int smallestDimension = (Math.min(Math.min(firstDimension, secondDimension), thirdDimension)) / 2;
            result += firstDimension + secondDimension + thirdDimension + smallestDimension;

            final int wrap = (rect.getSmallest() + rect.getMid()) * 2;
            final int bow  = rect.length() * rect.width() * rect.height();
            ribbon += wrap + bow;
        }
        System.out.println("Result: " + result);
        System.out.println("Ribbon: " + ribbon);
    }
}

record Rect(int length, int width, int height) {

    public int getSmallest() {
        return getValuesAsArray()[0];
    }

    public int getMid() {
        return getValuesAsArray()[1];
    }

    private Integer[] getValuesAsArray() {
        var numbers = new Integer[]{length, width, height};
        Arrays.sort(numbers, Comparator.naturalOrder());
        return numbers;
    }
}