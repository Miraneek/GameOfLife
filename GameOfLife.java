import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {
    public static Scanner scanner = new Scanner(System.in);
    public static int generation = 0;
    public static int delay = 1000;

    public static Boolean[][] gridGenerationMinusOne;
    public static boolean loop = false;

    public static void main(String[] args) throws InterruptedException {
        Boolean[][] grid = initializeGrid(10,10);
        printGrid(grid);

        while (true) {
            grid = updateGrid(grid);
            printGrid(grid);
        }
    }

    public static void printGrid(Boolean[][] grid) throws InterruptedException {
        System.out.printf("Generation: %d\n", generation++);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] ? "⬜" : "⬛");
            }
            System.out.println();
        }
        if (!loop){
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(delay);
            }
            for (int i = 0; i < 500; i++) {
                System.out.println();
            }
        }

    }

    public static Boolean[][] initializeGrid(int rows, int columns) {
        Boolean[][] grid = new Boolean[rows][columns];
        for (Boolean[] booleans : grid) {
            Arrays.fill(booleans, false);
        }
        /*
        //Glider
        grid[1][2] = true;
        grid[2][3] = true;
        grid[3][1] = true;
        grid[3][2] = true;
        grid[3][3] = true;
        */

        //Loop
        grid[4][5] = true;
        grid[4][6] = true;
        grid[5][5] = true;
        grid[5][6] = true;


        return grid;
    }

    public static Boolean[][] updateGrid(Boolean[][] grid) throws InterruptedException {
        Boolean[][] newGrid = new Boolean[grid.length][grid[0].length];
        if (gridGenerationMinusOne != null && Arrays.deepEquals(gridGenerationMinusOne, grid)) {
            loop = true;
            printGrid(grid);
            System.out.println("We're in an infinite loop!");
            System.out.println("Do you want to continue? (y/n)");
            if (scanner.nextLine().equals("y")) {
                System.out.println("You have chosen to continue indefensibly.");
            }else {
                System.out.println("Ending program...");
                System.exit(0);
            }
        }

        gridGenerationMinusOne = new Boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridGenerationMinusOne[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int aliveNeighbours = countAliveNeighbours(grid, i, j);
                if (grid[i][j]) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newGrid[i][j] = false;
                    } else {
                        newGrid[i][j] = true;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newGrid[i][j] = true;
                    } else {
                        newGrid[i][j] = false;
                    }
                }
            }
        }
        return newGrid;
    }

    public static int countAliveNeighbours(Boolean[][] grid, int row, int column) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (row + i < 0 || row + i >= grid.length || column + j < 0 || column + j >= grid[0].length) {
                    continue;
                }
                if (grid[row + i][column + j]) {
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }

}
