import java.util.ArrayList; 

public class Tile {
    private static final String HIDDEN_SYMBOL = "~";
    private static final String PLAYER_ON_EXIT_TILE_SYMBOL = "O";
    private static final String PLAYER_TILE_SYMBOL = "P";
    private static final String EXIT_TILE_SYMBOL = "X";
    private static final String OBSTACLE_TILE_SYMBOL = "#";
    private static final String UNKNOWN_ITEM_SYMBOL = "?";
    private static final String EMPTY_TILE_SYMBOL = " ";

    private int x;
    private int y;
    private boolean visibility;
    private ArrayList <String> data;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        visibility = true;
        data = new ArrayList<String>();
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public boolean getVisibility() {
        return visibility;
    }
    
    public void setVisibility(boolean b) {
        visibility = b;
    }

    public void addItemToTile(String s) {
        if (data.size() == 0) {
            data.add(s);
        }
        else {
            for (int i = 0; i < data.size(); i++) {
                if (s != data.get(i)) {
                    data.add(s);
                }
            }
        }
    }

    public void removeItemFromTile(String s) {
        for (int i = 0; i < data.size(); i++) {
            if (s == data.get(i)) {
                data.remove(i);
            }
        }
    }

    public boolean isItemOnTile(String s) {
       for (String string : data) {
           if (s == string) {
               return true;
           }
       }
       return false;
    }

    public String toString() {
        if (visibility) {
            if (data.size() == 0) {
                return EMPTY_TILE_SYMBOL;
            }
            
            else if (data.contains("Player") && data.contains("Exit")) {
                return PLAYER_ON_EXIT_TILE_SYMBOL;
            }

            else if (data.contains("Player")) {
                return PLAYER_TILE_SYMBOL;
            }

            else if (data.contains("Exit")) {
                return EXIT_TILE_SYMBOL;
            }

            else if (data.contains("Obstacle")) {
                return OBSTACLE_TILE_SYMBOL;
            }

            else return UNKNOWN_ITEM_SYMBOL;
        }
        return HIDDEN_SYMBOL;
    }
}
