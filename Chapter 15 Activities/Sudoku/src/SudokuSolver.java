import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        this.rows = new ArrayList<>();
        
        for(int row = 0; row < N; row++)
        {
            Set<Integer> set = new HashSet<>();
            
            for(int col = 0; col < N; col++)
            {
                set.add(grid[row][col]);
            }
            
            this.rows.add(set);
        }

        // create the list of sets for each col (this.cols)
        this.cols = new ArrayList<>();
        
        for(int row = 0; row < N; row++)
        {
            Set<Integer> set = new HashSet<>();
            
            for(int col = 0; col < N; col++)
            {
                set.add(grid[col][row]);
            }
            
            this.cols.add(set);
        }

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        this.squares=new ArrayList<>();
        for(int squarex = 0; squarex < N; squarex += 3)
        {
            for(int squarey = 0; squarey < N; squarey += 3)
            {
                Set<Integer> set = new HashSet<>();
                for(int row = squarex; row < squarex + 3 ; row++)
                {
                    for(int col = squarey;  col < squarey + 3 ; squarey++)
                    {
                        set.add(this.grid[row][col]);
                        
                    }
                }
                this.squares.add(set);
                
            }
        }
        

        // create a hash set for [1..9] (this.nums)
        this.nums = new HashSet<Integer>();
        this.nums.add(1);
        this.nums.add(2);
        this.nums.add(3);
        this.nums.add(4);
        this.nums.add(5);
        this.nums.add(6);
        this.nums.add(7);
        this.nums.add(8);
        this.nums.add(9);


        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        
        
        Set<Integer> row = new HashSet<Integer>(rows.get(nextRow));
        Set<Integer> col  = new HashSet<Integer>(cols.get(nextCol));
        
        int square = -1;
        if (nextRow < 3){
            switch (nextCol / 3){
                case 0:
                    square = 0;
                    break;
                case 1:
                    square = 1;
                    break;
                case 2:
                    square = 2;
                    break;
            }
        } else if (nextRow < 6){
            switch (nextCol / 3){
                case 0:
                    square = 3;
                    break;
                case 1:
                    square = 4;
                    break;
                case 2:
                    square = 5;
                    break;
            }
        } else {
            switch (nextCol / 3){
                case 0:
                    square = 6;
                    break;
                case 1:
                    square = 7;
                    break;
                case 2:
                    square = 8;
                    break;
            }
        }

        Set<Integer> cube = new HashSet<Integer>(squares.get(square));

        
        possibleNums.removeAll(this.rows.get(nextRow));
        possibleNums.removeAll(this.cols.get(nextCol));
        possibleNums.removeAll(this.squares.get(square));

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            this.rows.get(nextRow).add(possibleNum);
            this.cols.get(nextCol).add(possibleNum);
            this.squares.get(square).add(possibleNum);
            this.grid[nextRow][nextCol]=possibleNum;

            // recursively solve the board
            if (this.solve()) {
                
                // the board is solved!
                return true;
            } else {
                
                 /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                this.grid[nextRow][nextCol] = 0;
                this.rows.get(nextRow).remove(possibleNum);
                this.cols.get(nextCol).remove(possibleNum);
                this.squares.get(square).remove(possibleNum);
                
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}
