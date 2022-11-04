import java.util.Scanner;
public class Game {
    private Scanner sc = new Scanner(System.in);
    private int viewDistnace;
    private Grid grid;
    private Player player;
    
    public Game() {
        System.out.print("Enter the grid width: ");
        int w = sc.nextInt();
        System.out.print("Enter the grid height: ");
        int h = sc.nextInt();
        System.out.print("Enter the number of obstacles: ");
        int numberOfObstacles = sc.nextInt();
        System.out.print("Enter the players view distance: ");
        viewDistnace = sc.nextInt();

        grid = new Grid(w, h, numberOfObstacles);
        player = new Player(grid);
    }

    public void render() {
        player.updateVisibility(viewDistnace);
        grid.printGrid();
    }

    public int input() {
        boolean b = true;
        int n = 0;
        while (b) {
            System.out.println("Valid Actions:");
            for (int i : player.getValidMoves()) {
                switch(i) {
                    case 0 : System.out.print(i + ": Do Nothing\n");
                    break;
                    case 1 : System.out.print(i + ": Move Up\n");
                    break;
                    case 2 : System.out.print(i + ": Move Right\n");
                    break;
                    case 3 : System.out.print(i + ": Move Down\n");
                    break;
                    case 4 : System.out.print(i + ": Move Left\n");
                }
            }
            System.out.print("Enter an action: ");
            n = sc.nextInt();
            for (int i : player.getValidMoves()) {
                if (n == i) {
                    b = false;
                }
            }
            if (b) {
                System.out.print("Invalid Action! Please select a valid action from the list.\n");
            }
        }
       return n;
    }

    public void takeAction(int n) {
        player.takeAction(n);
    }

    public void run() {
        while (grid.getPlayerTile().toString() != "O") {
            render();
            takeAction(input());
        }
        render();
        System.out.println("Congratulations, you have found the Exit!");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
