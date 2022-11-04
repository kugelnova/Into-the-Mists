import java.util.ArrayList;
public class Player {
    private int x,y;
    private Grid grid;
    
    public Player(Grid grid) {
        if (grid.getPlayerTile() == null) {
            grid.getTileAtPosition(0,grid.getGridHeight()-1).addItemToTile("Player");
            x = 0;
            y = grid.getGridHeight()-1;
        }
        else {
            x = grid.getPlayerTile().getXPosition();
            y = grid.getPlayerTile().getYPosition();
        }
        this.grid = grid;
    }

    public int getXPosition() {
        return x;
    }

    public int getYPosition() {
        return y;
    }

    public boolean foundExit() {
        
        if (grid.getPlayerTile().toString() == "O") {
            return true;
        }
        return false;
    }

    public int[] getValidMoves() {
        ArrayList<Integer> moves = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            moves.add(i);
        }

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) == 1) {
                if (y == 0) {
                    moves.remove(i);
                }
                else if (grid.getTileAtPosition(x,y-1).toString() == "#") {
                    moves.remove(i);
                }
            }
        }

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) == 2) {
                if (x == grid.getGridWidth()-1) {
                    moves.remove(i);
                }
                else if (grid.getTileAtPosition(x+1,y).toString() == "#") {
                    moves.remove(i);
                }
            }
        }

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) == 3) {
                if (y == grid.getGridHeight()-1) {
                    moves.remove(i);
                }
                else if (grid.getTileAtPosition(x,y+1).toString() == "#") {
                    moves.remove(i);
                }
            }
        }

        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) == 4) {
                if (x == 0) {
                    moves.remove(i);
                }
                else if (grid.getTileAtPosition(x-1,y).toString() == "#") {
                    moves.remove(i);
                }
            }
        }
        int[] validMoves = new int[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            validMoves[i] = moves.get(i);
            }
        return validMoves;
    }

    public void takeAction(int move) {
        switch(move) {
            case 0 : break;
            case 1 : grid.getPlayerTile().removeItemFromTile("Player");
                     grid.getTileAtPosition(x,y-1).addItemToTile("Player");
                     y--;
                     break;
            case 2 : grid.getPlayerTile().removeItemFromTile("Player");
                     grid.getTileAtPosition(x+1,y).addItemToTile("Player");
                     x++;
                     break;
            case 3 : grid.getPlayerTile().removeItemFromTile("Player");
                     grid.getTileAtPosition(x,y+1).addItemToTile("Player");
                     y++;
                     break;
            case 4 : grid.getPlayerTile().removeItemFromTile("Player");
                     grid.getTileAtPosition(x-1,y).addItemToTile("Player");
                     x--;
                     break;
        }
    }

    public void updateVisibility(int v) {
        for (int i = 0; i < grid.getGridWidth(); i++) {
            for (int j = 0; j < grid.getGridHeight(); j++) {
                grid.getTileAtPosition(i,j).setVisibility(false);
            }
        }
        
        for (int i = y; i >= 0; i--) {
            if (grid.getTileAtPosition(x,i).isItemOnTile("Obstacle") || i == y-v) {
                grid.getTileAtPosition(x,i).setVisibility(true);
                break;
                
            }
            else grid.getTileAtPosition(x,i).setVisibility(true);
        }

        for (int i = x; i <= grid.getGridWidth()-1; i++) {
            if (grid.getTileAtPosition(i,y).isItemOnTile("Obstacle") || i == x+v) {
                grid.getTileAtPosition(i,y).setVisibility(true);
                break;
            }
            else grid.getTileAtPosition(i,y).setVisibility(true);
        }
        
        for (int i = y; i <= grid.getGridHeight()-1; i++) {
            if (grid.getTileAtPosition(x,i).isItemOnTile("Obstacle") || i == x+v) {
                grid.getTileAtPosition(x,i).setVisibility(true);
                break;
            }
            else grid.getTileAtPosition(x,i).setVisibility(true);
        }

        for (int i = x; i >= 0; i--) {
            if (grid.getTileAtPosition(i,y).isItemOnTile("Obstacle") || i == y-v) {
                grid.getTileAtPosition(i,y).setVisibility(true);
                break;
            }
            else grid.getTileAtPosition(i,y).setVisibility(true);
        }
        //grid.getPlayerTile().setVisibility(true);
    }
}
