import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playnewround;

        System.out.print("Name des ersten Spielers: ");
        String name1 = scanner.next();
        System.out.print("Name des zweiten Spielers: ");
        String name2 = scanner.next();

        Player player1 = new Player(name1, 'O');
        Player player2 = new Player(name2, 'X');

        do {

            System.out.println("\n\n\n\n\n\n\n\n");
            // Neues Spiel Ausgabe
            System.out.println("========================================");
            System.out.println("Neues Spiel, neues Glück!");
            System.out.println("========================================");
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("========================================");

            // Das Feld vorbereiten
            Field.clearField();
            Field.showField();

            // Sieg auf false setzen
            boolean player1Wins = false;
            boolean player2Wins = false;

            // Für 9 Züge:
            for (int i = 1; i <= 9; i++) {

                // Wenn noch niemand gewonnen hat:
                if (!player1Wins && !player2Wins) {

                    // Spieler 1:
                    if (i % 2 != 0) {

                        System.out.println(player1.getName() + " ist an der Reihe");
                        String coordinates;
                        boolean finish;

                        // Frage nach Feld
                        do {
                            finish = false;
                            System.out.print("Bitte gebe ein Feld an: ");
                            coordinates = scanner.next();

                            if (Field.isPlaceAvailable(coordinates) && Field.isFree(coordinates)) {
                                Field.setSign(coordinates, player1);
                                finish = true;
                            } else {
                                System.out.println("Bitte gebe ein existierendes oder freies Feld an!");
                            }
                        } while (!finish);

                        System.out.println("\n\n\n\n\n");
                        Field.showField();

                        // Überprüfen, ob Spieler 1 gewonnen hat
                        player1Wins = Field.hasPlayer1ThreeInRow();

                        // Spieler 2:
                    } else {
                        System.out.println(player2.getName() + " ist an der Reihe");
                        String coordinates;
                        boolean finish;

                        // Frage nach Feld
                        do {
                            finish = false;
                            System.out.print("Bitte gebe ein Feld an: ");
                            coordinates = scanner.next();

                            if (Field.isPlaceAvailable(coordinates) && Field.isFree(coordinates)) {
                                Field.setSign(coordinates, player2);
                                finish = true;
                            } else {
                                System.out.println("Bitte gebe ein existierendes oder freies Feld an!");
                            }
                        } while (!finish);

                        System.out.println("\n\n\n\n\n");
                        Field.showField();

                        // Überprüfen, ob Spieler 2 gewonnen hat
                        player2Wins = Field.hasPlayer2ThreeInRow();
                    }
                }
            }

            // SiegeScore hochsetzen
            if (player1Wins) {
                player1.setSiege(player1.getSiege() + 1);
                System.out.println(player1.getName() + " hat gewonnen. Siege insgesamt: " + player1.getSiege());
            } else if (player2Wins) {
                player2.setSiege(player2.getSiege() + 1);
                System.out.println(player2.getName() + " hat gewonnen. Siege insgesamt: " + player2.getSiege());
            }

            // Fragen, ob noch eine Runde gespielt werden soll
            System.out.print("Weiter spielen (Ja/Nein): ");
            String answer = scanner.next().toLowerCase();
            playnewround = answer.equals("ja") || answer.equals("yes") || answer.equals("j") || answer.equals("y");

        } while (playnewround);

        System.out.println("\n\n");
        // Engültige Ausgabe des Gewinners
        System.out.println("====================================");
        if (player1.getSiege() > player2.getSiege()) {
            System.out.println(player1.getName() + " gewinnt mit insgesamt " + player1.getSiege() + " Siegen!");
            System.out.println(player2.getName() + " verliert mit insgesamt " + player2.getSiege() + " Siegen!");
        } else if (player2.getSiege() > player1.getSiege()) {
            System.out.println(player2.getName() + " gewinnt mit insgesamt " + player2.getSiege() + " Siegen!");
            System.out.println(player1.getName() + " verliert mit insgesamt " + player1.getSiege() + " Siegen!");
        } else {
            System.out.println("Unentschieden: Beide haben insgesamt " + player1.getSiege() + " Siege");
        }
        System.out.println("====================================");
        System.out.println("Vielen Dank fürs Spielen!");
    }
}