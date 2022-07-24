package edu.ics211.h09;

import java.util.ArrayList;

/**
 * Class for recursively finding a solution to a Sudoku problem.
 * missing solveSudoku and legalValues, to be implemented by the students in ICS 211
 * @author Biagioni, Edoardo, Cam Moore 
 */
public class Sudoku {

  /**
   * Find an assignment of values to sudoku cells that makes the sudoku valid.
   *
   * @param sudoku to be solved
   * @return whether a solution was found if a solution was found, 
   *     the sudoku is filled in with the solution if no
   *     solution was found, restores the sudoku to its original value
   */
  public static boolean solveSudoku(int[][] sudoku) {
    // TODO: Implement this method recursively. You may use a recursive
    // helper method.
    // Solve the soduku with recursive method
    for (int a = 0; a < sudoku.length; a++) {
        
      for (int b = 0; b < sudoku[a].length; b++) {
            
        if (sudoku[a][b] == 0) {
                
          ArrayList<Integer> vals = legalValues(sudoku, a, b);
                
          if (vals == null) {
            return false;
          }
                
          for (int c : vals) {
                    
            sudoku[a][b] = vals.get(c);
                    
            if (solveSudoku(sudoku)) {
              return true;
            }
            sudoku[a][b] = 0;
            return false;
          }
          return false;
        }
      }
    }
    return false;
    
  }


  /**
   * Find the legal values for the given sudoku and cell.
   *
   * @param sudoku the sudoku being solved.
   * @param row the row of the cell to get values for.
   * @param column the column of the cell.
   * @return an ArrayList of the valid values.
   */
  public static ArrayList<Integer> legalValues(int[][] sudoku, int row, int column) {
    // TODO: Implement this method. You may want to look at the checkSudoku method
    // to see how it finds conflicts.
    ArrayList<Integer> solutions = new ArrayList<Integer>();
    
    // checks if cell is not empty
    if (sudoku[row][column] != 0) {
      return null;
    }
    
    // creates list of possible solutions (1-9)
    for (int i = 1; i <= 9; i++) {
      solutions.add(i);
    }

    // checks if a number already exists in a row
    for (int a = 0; a < 9; a++) {
      for (int b = 0; b < solutions.size(); b++) {
        if (solutions.get(b) == sudoku[a][column]) {
          solutions.remove(b);
        }
      }
    }
    
    // checks if a number already exists in a column
    for (int a = 0; a < 9; a++) {
      for (int b = 0; b < solutions.size(); b++) {
        if (solutions.get(b) == sudoku[row][a]) {
          solutions.remove(b);
        }
      }
    }
    
    // if no possible numbers left, returns null
    if (solutions.size() == 0) {
      return null;
    }
    
    // returns possible numbers
    return solutions;
  }


  /**
   * checks that the sudoku rules hold in this sudoku puzzle. cells that contain 0 are not checked.
   *
   * @param sudoku to be checked
   * @param printErrors whether to print the error found, if any
   * @return true if this sudoku obeys all of the sudoku rules, otherwise false
   */
  public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
    if (sudoku.length != 9) {
      if (printErrors) {
        System.out.println("sudoku has " + sudoku.length + " rows, should have 9");
      }
      return false;
    }
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i].length != 9) {
        if (printErrors) {
          System.out.println("sudoku row " + i 
                  + " has " + sudoku[i].length + " cells, should have 9");
        }
        return false;
      }
    }
    /* check each cell for conflicts */
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        int cell = sudoku[i][j];
        if (cell == 0) {
          continue; /* blanks are always OK */
        }
        if ((cell < 1) || (cell > 9)) {
          if (printErrors) {
            System.out.println("sudoku row " + i + " column " + j + " has illegal value " + cell);
          }
          return false;
        }
        /* does it match any other value in the same row? */
        for (int m = 0; m < sudoku.length; m++) {
          if ((j != m) && (cell == sudoku[i][m])) {
            if (printErrors) {
              System.out.println("sudoku row " + i 
                      + " has " + cell + " at both positions " + j + " and " + m);
            }
            return false;
          }
        }
        /* does it match any other value it in the same column? */
        for (int k = 0; k < sudoku.length; k++) {
          if ((i != k) && (cell == sudoku[k][j])) {
            if (printErrors) {
              System.out.println("sudoku column " + j 
                      + " has " + cell + " at both positions " + i + " and " + k);
            }
            return false;
          }
        }
        /* does it match any other value in the 3x3? */
        for (int k = 0; k < 3; k++) {
          for (int m = 0; m < 3; m++) {
            int testRow = (i / 3 * 3) + k; /* test this row */
            int testCol = (j / 3 * 3) + m; /* test this col */
            if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
              if (printErrors) {
                System.out.println("sudoku character " + cell + " at row " + i + ", column " + j
                    + " matches character at row " + testRow + ", column " + testCol);
              }
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * Converts the sudoku to a printable string.
   *
   * @param sudoku to be converted
   * @param debug whether to check for errors
   * @return the printable version of the sudoku
   */
  public static String toString(int[][] sudoku, boolean debug) {
    if ((!debug) || (checkSudoku(sudoku, true))) {
      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 3 == 0) {
          result = result + "+-------+-------+-------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 3 == 0) {
            result = result + "| ";
          }
          if (sudoku[i][j] == 0) {
            result = result + "  ";
          } else {
            result = result + sudoku[i][j] + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+-------+-------+-------+\n";
      return result;
    }
    return "illegal sudoku";
  }
}
