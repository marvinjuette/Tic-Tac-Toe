public class Field {
    
    private static String[][] field = new String[3][3];
    
    static void clearField() {
        for(int i=0; i<field.length; i++) {
            field[i][0] = " ";
            field[i][1] = " ";
            field[i][2] = " ";
        }
    }
    
    static void showField() {
        System.out.println("   || A || B || C ||");
        System.out.println("=======================");
        System.out.println(" 1 || " + field[0][0] + " || " + field[1][0] + " || " + field[2][0] + " || ");
        System.out.println("=======================");
        System.out.println(" 2 || " + field[0][1] + " || " + field[1][1] + " || " + field[2][1] + " || ");
        System.out.println("=======================");
        System.out.println(" 3 || " + field[0][2] + " || " + field[1][2] + " || " + field[2][2] + " || ");
        System.out.println("=======================");
    }

    static void setSign(String coordinatesString, Player player) {
        int[] coordinates;
        coordinates = coordinatesToIndexes(coordinatesString);
        field[coordinates[0]][coordinates[1]] = String.valueOf(player.getSign());
    }

    static boolean isPlaceAvailable(String coordinates) {
        coordinates = coordinates.substring(0).toUpperCase();
        return (coordinates.startsWith("A") || coordinates.startsWith("B") || coordinates.startsWith("C")) && (coordinates.endsWith("1") || coordinates.endsWith("2") || coordinates.endsWith("3")) && coordinates.length() == 2;
    }

    static boolean isFree(String coordinatesString) {
        int[] coordinates;
        coordinates = coordinatesToIndexes(coordinatesString);

        return field[coordinates[0]][coordinates[1]].equals(" ");

    }

    private static int[] coordinatesToIndexes(String coordinates) {
        int[] indexes = new int[2];

        coordinates = coordinates.substring(0).toUpperCase();

        // Change Characters to Index
        if(coordinates.startsWith("A")) indexes[0] = 0;
        else if(coordinates.startsWith("B")) indexes[0] = 1;
        else indexes[0] = 2;

        //Change Number to Index
        if(coordinates.endsWith("1")) indexes[1] = 0;
        else if(coordinates.endsWith("2")) indexes[1] = 1;
        else indexes[1] = 2;

        return indexes;
    }

    public static boolean hasPlayer1ThreeInRow() {
        return field[0][0].equals("O") && field[0][1].equals("O") && field[0][2].equals("O") ||
                field[1][0].equals("O") && field[1][1].equals("O") && field[1][2].equals("O") ||
                field[2][0].equals("O") && field[2][1].equals("O") && field[2][2].equals("O") ||
                field[0][0].equals("O") && field[1][0].equals("O") && field[2][0].equals("O") ||
                field[0][1].equals("O") && field[1][1].equals("O") && field[2][1].equals("O") ||
                field[0][2].equals("O") && field[1][2].equals("O") && field[2][2].equals("O") ||
                field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O") ||
                field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O");
    }

    public static boolean hasPlayer2ThreeInRow() {
        return field[0][0].equals("X") && field[0][1].equals("X") && field[0][2].equals("X") ||
                field[1][0].equals("X") && field[1][1].equals("X") && field[1][2].equals("X") ||
                field[2][0].equals("X") && field[2][1].equals("X") && field[2][2].equals("X") ||
                field[0][0].equals("X") && field[1][0].equals("X") && field[2][0].equals("X") ||
                field[0][2].equals("X") && field[1][2].equals("X") && field[2][2].equals("X") ||
                field[0][1].equals("X") && field[1][1].equals("X") && field[2][1].equals("X") ||
                field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X") ||
                field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X");
    }

}