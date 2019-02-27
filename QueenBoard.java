public class QueenBoard {
  private int[][]board;
  private int numQueens;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      int inc = 0;
      board[r][c] = -1;
      numQueens++;
      for (int i = 0; i < board.length; i++) {
        board[i][c]++; // marks all the way down column
      }
      for (int j = c; j < board.length; j++) { // marks possible spaces all the way down row
        board[r][j]++;
        if (r-inc >= 0) { //diagonal
          board[r-inc][j]++;
        }
        if (r+inc < board.length) { //diagonal
          board[r+inc][j]++;
        }
        inc++;
      }
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int r, int c) { //almost identical to add except in reverse
    if (board[r][c] == -1) {
      int inc = 0;
      board[r][c] = 0;
      numQueens--;
      for (int i = 0; i < board.length; i++) { //marks all the way down column
        if (i != r) { //special check to ensure that original position doesn't get altered twice
          board[i][c]--;
        }
      }
      for (int j = c; j < board.length; j++) {
        board[r][j]--;
        if (r-inc >= 0) {
          board[r-inc][j]--;
        }
        if (r + inc < board.length) {
          board[r+inc][j]--;
        }
        inc++;
      }
      return true;
    }
    else {
      return false;
    }
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == -1) {
          if (j == board.length -1) {
            s+="Q\n";
          }
          else {
            s += "Q ";
          }
        }
        else {
          if (j == board.length -1) {
            s += "_\n";
          }
          else {
            s += "_ ";
          }
        }
      }
    }
    return s;
  }

  public void clearBoard(QueenBoard b, int s) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = 0;
      }
    }
  }
  
  public boolean solveHelp(int c) {
    if (c >= board.length) {
      return true;
    }
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r,c)) {
          if (solveHelp(c+1)) {
            return true;
          }
          removeQueen(r,c);
        }
      }
      clearBoard(this,board.length);
      return false;
  }

  public boolean solve() throws IllegalStateException {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException("Empty board required.");
        }
      }
    }
    return this.solveHelp(0);
  }

  public int countHelp(int c, int count) {
    if (c >= board.length) {
      return count;
    }
    else {
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r,c)) {
          if (solveHelp(c+1)) {
            count++;
          }
        }
        removeQueen(r,c);
      }  
    }
    return countHelp(c+1,count);
  }

  public int countSolutions() throws IllegalStateException {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException("Empty board required.");
        }
      }
    }
    return this.countHelp(0,0);
  }
}
