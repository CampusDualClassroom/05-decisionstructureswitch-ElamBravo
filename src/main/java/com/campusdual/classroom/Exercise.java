package com.campusdual.classroom;

import java.util.Calendar;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class Exercise {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH) + 1;
        int hour = now.get(Calendar.HOUR_OF_DAY);

        checkSeason(month);
        checkHour(hour);

        String textToSave = generateStringToSave(null);
        printToFile(textToSave);
    }

    public static void checkHour(int hour) {
        if (hour >= 0 && hour < 7) {
            System.out.println("It's night");
        } else if (hour >= 7 && hour < 14) {
            System.out.println("It's morning");
        } else if (hour >= 14 && hour < 21) {
            System.out.println("It's afternoon");
        } else if (hour >= 21 && hour < 24) {
            System.out.println("It's night");
        } else {
            System.out.println("Invalid hour");
        }
    }

    public static void checkSeason(int month) {
        switch (month) {
            case 1: case 2: case 3:
                System.out.println("Winter");
                break;
            case 4: case 5: case 6:
                System.out.println("Spring");
                break;
            case 7: case 8: case 9:
                System.out.println("Summer");
                break;
            case 10: case 11: case 12:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Invalid month");
                break;
        }
    }

    public static String generateUserInputToSave() {
        System.out.println("Introduce una cadena de texto para guardar en el fichero:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String generateStringToSave(String string) {
        if (string == null) {
            return generateUserInputToSave();
        }
        return string;
    }

    public static void printToFile(String string) {
        try {
            Path path = Paths.get("src/main/resources/data.txt");
            Files.write(path, string.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Texto guardado correctamente en el fichero.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}

