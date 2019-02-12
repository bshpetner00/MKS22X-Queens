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

  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int i = 0; i < board.length; i++) {
        if (board[r][i] != -1) {
          board[r][i] += 1;
        } // across row
        if (board[i][c] != -1) {
          board[i][c] += 1;
        } // down column
        if (board[r+i][c+i] != -1 && r+i < board.length && c+i < board.length) {
          board[r+i][c+i] += 1;
        } //diagonal y = x
        if (board[r-i][c-i] != -1 && r-i > 0 && c-i > 0) {
          board[r-i][c-i] += 1;
        } //diagonal -y = -x
        if (board[r-i][c+i] != -1 && r-i > 0 && c+i < board.length) {
          board[r-i][c+i] += 1;
        } //diagonal -y = x
        if (board[r+i][c-i] != -1 && r+i < board.length && c-i > 0) {
          board[r+i][c-i] += 1;
        } // diagonal y = -x
      }
      return true;
    }
    else {
      return false;
    }
  }

  public boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int i = 0; i < board.length; i++) {
        if (board[r][i] > 0) {
          board[r][i] -= 1;
        } // across row

        if (board[i][c] > 0) {
          board[i][c] -= 1;
        } // down column

        if (board[r+i][c+i] > 0 && r+i < board.length && c+i < board.length) {
          board[r+i][c+i] -= 1;
        } //diagonal y = x

        if (board[r-i][c-i] > 0 && r-i > 0 && c-i > 0) {
          board[r-i][c-i] -= 1;
        } //diagonal -y = -x

        if (board[r-i][c+i] > 0 && r-i > 0 && c+i < board.length) {
          board[r-i][c+i] -= 1;
        } //diagonal -y = x

        if (board[r+i][c-i] > 0 && r+i < board.length && c-i > 0) {
          board[r+i][c-i] -= 1;
        } // diagonal y = -x

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
    b = new QueenBoard(s);
  }
  
  public boolean solveHelp(int c) {
    if (c >= board.length) {
      return true;
    }
    else {
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r,c)) {
          if (solveHelp(c+1)) {
            return true;
          }
          removeQueen(r,c);
        }
      }
      clearBoard(this,board.size);
      return false;
    }
  }

  public boolean solve() throws IllegalStateException {
    if (board[0][0] != 0) {
      throw new IllegalStateException("Empty board required.");
    }
    else { 
      return this.solveHelp(0);
    }
  }




}
