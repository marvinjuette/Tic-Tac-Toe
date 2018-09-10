public class Player {
    
    private String name;
    private int siege;
    private char sign;
    
    Player(String pName, char pSign) {
        this.name = pName;
        this.sign = pSign;
        this.siege = 0;
    }
    
    String getName() {
        return name;
    }
    
    public int getSiege() {
        return siege;
    }

    public void setSiege(int value) {
        siege = value;
    }

    char getSign() {
        return sign;
    }

    public String toString() {
        return "Name: " + name + "; Siege: " + siege + "; Zeichen: " + sign;
    }
}