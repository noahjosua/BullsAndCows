import java.util.*;

public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static boolean quit = false;
    private static String code;
    private static char max;
    private static int length;
    private static int symbols;
    private static String guess;

    public static void start() {
        System.out.println("Please, enter the secret code's length:");
        String input = SCANNER.nextLine();
        try {
            length = Integer.parseInt(input);
            if (length < 1 || length > 36) {
                System.out.println("Error: minimum length must be 1, maximum length can be 36.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + input + " isn't a valid number.");
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        String input2 = SCANNER.nextLine();
        try {
            symbols = Integer.parseInt(input2);
            if (symbols < length) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + symbols + " unique symbols.");
                return;
            } else if (symbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + input2 + " isn't a valid number.");
            return;
        }
        try {
            code = codeGenerator(length, symbols);
            System.out.println("The secret is prepared: " + asterisk(length) + " (0-9, a-" + max + ").");
            game();
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    private static void game() {
        int round = 0;
        while (!quit) {
            System.out.println("Turn " + (round + 1) + ":");
            try {
                guess = SCANNER.nextLine();
            } catch (Exception e) {
                System.out.println("Error: your guess has to be exactly as long as the secret code.");
                quit = true;
            }
            bullOrCow(code, guess);
            round++;
        }
    }

    private static void result(int bull, int cow) {
        if (bull == code.length()) {
            System.out.println("Grade: " + bull + " bulls.");
            System.out.println("Congratulations! You guessed the secret code.");
            quit = true;
        } else if (bull == 0 && cow == 0) {
            System.out.println("Grade: None");
        } else if (bull == 0 && cow >= 1) {
            System.out.println("Grade: " + cow + " cow(s)");
        } else if (cow == 0 && bull >= 1) {
            System.out.println("Grade: " + bull + " bull(s)");
        } else {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s)");
        }
    }

    private static String codeGenerator(int length, int symbols) {
        StringBuilder secret = new StringBuilder();
        List<Character> characters = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        List<Character> prepareForCode = characters.subList(0, symbols);
        if (symbols > 10) {
            max = prepareForCode.get(prepareForCode.size() - 1);
        }
        Collections.shuffle(prepareForCode);
        int element = 0;
        while (element < length) {
            secret.append(prepareForCode.get(element));
            element++;
        }
        return secret.toString();
    }

    private static String asterisk(int length) {
        return "*".repeat(Math.max(0, length));
    }

    private static void bullOrCow(String code, String guess) {
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == guess.charAt(i)) {
                bull++;
            } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                cow++;
            }
        }
        result(bull, cow);
    }
}
