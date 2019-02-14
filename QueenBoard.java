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
        if ((r-i > 0 && c-i > 0 && board[r-i][c-i] == -1) || (r-i > 0 && c+i < board.length && board[r-i][c+i] == -1) || (r+i < board.length && c-i > 0 && board[r+i][c-i] != -1)) {
          return false;
        }
      }
      for (int q = 0; q < board.length; q++) {
        if (board[r][q] != -1) {
          board[r][q] += 1;
        } // across row
        if (board[q][c] != -1) {
          board[q][c] += 1;
        } // down column
        if (r+q < board.length && c+q < board.length && board[r+q][c+q] != -1) {
          board[r+q][c+q] += 1;
        } //diagonal y = x
        if (r-q > 0 && c-q > 0 && board[r-q][c-q] != -1 ) {
          board[r-q][c-q] += 1;
        } //diagonal -y = -x
        if (r-q > 0 && c+q < board.length && board[r-q][c+q] != -1) {
          board[r-q][c+q] += 1;
        } //diagonal -y = x
        if (r+q < board.length && c-q > 0 && board[r+q][c-q] != -1) {
          board[r+q][c-q] += 1;
        } // diagonal y = -x
        return true;
      }
    }
    return false;
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

        if (r+i < board.length && c+i < board.length && board[r+i][c+i] > 0) {
          board[r+i][c+i] -= 1;
        } //diagonal y = x

        if ( r-i > 0 && c-i > 0 && board[r-i][c-i] > 0) {
          board[r-i][c-i] -= 1;
        } //diagonal -y = -x

        if (r-i > 0 && c+i < board.length && board[r-i][c+i] > 0) {
          board[r-i][c+i] -= 1;
        } //diagonal -y = x

        if (r+i < board.length && c-i > 0 && board[r+i][c-i] > 0) {
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
    if (board[0][0] != 0) {
      throw new IllegalStateException("Empty board required.");
    }
    else {
      return this.solveHelp(0);
    }
  }

  public int countHelp(int c, int count) {
    if (c >= board.length) {
      return count;
    }
    else {
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r,c)) {
          if (solveHelp(c+1)) {
            System.out.println(this.toString());
            count++;
          }
        }
        removeQueen(r,c);
      }
    }
    return countHelp(c+1,count);
  }

  public int countSolutions() throws IllegalStateException {
    if (board[0][0] != 0) {
      throw new IllegalStateException("Empty board required.");
    }
    else {
      return this.countHelp(0,0);
    }
  }




}
