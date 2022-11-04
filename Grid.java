import java.util.ArrayList; 

public class Grid {
    private static final String GRID_CORNER_SYMBOL = "+";
    private static final String GRID_HORIZONTAL_SYMBOL = "-";
    private static final String GRID_VERTICAL_SYMBOL = "|"; 

    private int h, w;
    private ArrayList<Tile> tileArray;
    
    public Grid(int w, int h) {
        this.w = w;
        this.h = h;
        tileArray = new ArrayList<Tile>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                tileArray.add(new Tile(i, j));
            }
        }
    }

    public int getGridWidth() {
        return w;
    }

    public int getGridHeight() {
        return h;
    }

    public Tile getTileAtPosition(int x, int y) {
        if (x < w && y < h) {
            for (Tile tile : tileArray) {
                if (x == tile.getXPosition() && y == tile.getYPosition()) {
                    return tile;
                }
            }
        }
        return null;
    }

    public Tile getPlayerTile() {
        for (Tile tile : tileArray) {
            if (tile.isItemOnTile("Player")) {
                return tile;
            }
        }
        return null;
    }
    
    public void printGrid() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            System.out.print(GRID_CORNER_SYMBOL);
            System.out.print(GRID_HORIZONTAL_SYMBOL);
            }
            System.out.println(GRID_CORNER_SYMBOL);
            for (int j = 0; j < w; j++) {
                System.out.print(GRID_VERTICAL_SYMBOL);
                System.out.print(getTileAtPosition(j,i));
            }
            System.out.println(GRID_VERTICAL_SYMBOL);
        }
        for (int j = 0; j < w; j++) {
            System.out.print(GRID_CORNER_SYMBOL);
            System.out.print(GRID_HORIZONTAL_SYMBOL);
        }
        System.out.print(GRID_CORNER_SYMBOL + "\n");
    }
}
