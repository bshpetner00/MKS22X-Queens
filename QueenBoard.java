public class QueenBoard {
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
  }

  public int getVal(int r, int c) {
    return this.board[r][c];
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      int inc = 0;
      for (int i = 0; i < board.length; i++) {
        board[i][c] += 1; // marks all the way down column
      }
      for (int j = c; j < board.length; j++) { // marks possible spaces all the way down row
        board[r][j] += 1;
        if (r-inc >= 0) { //diagonal w/ increment (lower bound)
          board[r-inc][j] += 1;
        }
        if (r+inc < board.length) { //diagonal w/ increment (upper bound)
          board[r+inc][j] += 1;
        }
        inc+=1;
      }
      board[r][c] = -1;
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int r, int c) { //almost identical to add except in reverse
    if (board[r][c] == -1) {
      int inc = 0;
      for (int i = 0; i < board.length; i++) { //marks all the way down column
        if (i != r) {
          board[i][c] -= 1;
        }
      }
      for (int j = c; j < board.length; j++) {
        board[r][j] -= 1;
        if (r >= inc) {
          board[r-inc][j] -= 1;
        }
        if (r + inc < board.length) {
          board[r+inc][j] -= 1;
        }
        inc+=1;
      }
      board[r][c] = 0;
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

  public String toStringDebug() {
    String s = "";
    String piece = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
          if (j == board.length -1) {
            piece = ""+board[i][j]+"\n"; 
            s+=piece;
            piece = "";
          }
          else {
            piece = ""+board[i][j]+" ";
            s += piece;
            piece = "";
          }
        }
    }
    return s;
  }

  public void clearBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = 0;
      }
    }
  }
  
  private boolean solveHelp(int c) {
    if (c >= board.length) {
      return true;
    } 
    for (int r = 0; r < board.length; r ++) {
      if (addQueen(r, c)) {
        if (solveHelp(c + 1)) {
          return true;
        } 
        removeQueen(r, c);
      }
    }
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
    return solveHelp(0);
  }

  public int countHelp(int c, int queens) {
    int s = 0;
    if (queens == board.length) {
      return 1;
    }
    else {
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r,c)) {
          s += countHelp(c+1,queens+1);
        }
        removeQueen(r,c);
      }
      return s;
    }
  }

  public int countSolutions() throws IllegalStateException {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException("Empty board required.");
        }
      }
    }
    return countHelp(0,0);
  }
}
