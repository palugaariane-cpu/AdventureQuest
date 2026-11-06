
import java.util.Scanner;

interface PlayerSetup {
    void enterName();
}

interface GameMode {
    void selectMode();
}

interface GameLauncher {
    void startGame();
}

public class AdventureQuest implements PlayerSetup, GameMode, GameLauncher {

    Scanner input = new Scanner(System.in);
    String playerName;
    int mode;

    public void enterName() {
        System.out.print("Enter your name: ");
        playerName = input.nextLine();
    }

    public void selectMode() {
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");

        System.out.print("Choose your mode: ");
        mode = input.nextInt();
        input.nextLine();

        while (mode != 1 && mode != 2) {
            System.out.print("Invalid choice. Choose 1 or 2: ");
            mode = input.nextInt();
            input.nextLine();
        }
    }

    public void startGame() {
        String choice;

        System.out.print("Press P to start playing, " + playerName + ": ");
        choice = input.nextLine();

        while (!choice.equalsIgnoreCase("P")) {
            System.out.print("Press P to start playing: ");
            choice = input.nextLine();
        }

        System.out.println("\nWelcome to Adventure Quest, " + playerName + "!");

        if (mode == 1) {
            storyMode();
        } else {
            survivalMode();
        }
    }

    public void storyMode() {
        System.out.println("\n--- STORY MODE ---");
        System.out.println("You wake up in a mysterious forest.");
        System.out.println("1 - Explore the forest");
        System.out.println("2 - Enter a dark cave");
        System.out.print("Choose your action: ");

        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You found a hidden treasure!");
        } else if (choice == 2) {
            System.out.println("You discovered an ancient sword!");
        } else {
            System.out.println("You stayed in the forest.");
        }
    }

    public void survivalMode() {
        System.out.println("\n--- SURVIVAL MODE ---");
        System.out.println("You are stranded on an island.");
        System.out.println("1 - Search for food");
        System.out.println("2 - Find shelter");
        System.out.print("Choose your action: ");

        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("You found food and regained your strength!");
        } else if (choice == 2) {
            System.out.println("You built a shelter for the night!");
        } else {
            System.out.println("You wasted time. Be careful!");
        }
    }

    public static void main(String[] args) {
        AdventureQuest game = new AdventureQuest();

        game.enterName();
        game.selectMode();
        game.startGame();

        game.input.close();
    }
}
