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
        }
        if (board[r][i] == -1) {
          return false;
        }
        if (board[i][c] != -1) {
          board[i][c] += 1;
        }
        if (board[i][c] == -1) {
          return false;
        }
        if (board[r+i][c+i] != -1 && r+i < board.length && c+i < board.length) {
          board[r+i][c+i] += 1;
        }
        if (board[r+i][c+i] == -1 && r+i < board.length && c+i < board.length) {
          return false;
        }
        if (board[r-i][c-i] != -1 && r-i > 0 && c-i > 0) {
          board[r-i][c-i] += 1;
        }
        if (board[r-i][c-i] == -1 && r-i > 0 && c-i > 0) {
          return false;
        }
        if (board[r-i][c+i] != -1 && r-i > 0 && c+i < board.length) {
          board[r-i][c+i] += 1;
        }
        if (board[r-i][c+i] == -1 && r-i > 0 && c+i < board.length) {
          return false;
        }
        if (board[r+i][c-i] != -1 && r+i < board.length && c-i > 0) {
          board[r+i][c-i] += 1;
        }
        if (board[r+i][c-i] != -1 && r+i < board.length && c-i > 0) {
          return false;
        }
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
        }
        if (board[r][i] <= 0) {
          return false;
        }
        if (board[i][c] > 0) {
          board[i][c] -= 1;
        }
        if (board[i][c] <= 0) {
          return false;
        }
        if (board[r+i][c+i] > 0 && r+i < board.length && c+i < board.length) {
          board[r+i][c+i] -= 1;
        }
        if (board[r+i][c+i] <= 0 && r+i < board.length && c+i < board.length) {
          return false;
        }
        if (board[r-i][c-i] > 0 && r-i > 0 && c-i > 0) {
          board[r-i][c-i] -= 1;
        }
        if (board[r-i][c-i] <= 0 && r-i > 0 && c-i > 0) {
          return false;
        }
        if (board[r-i][c+i] > 0 && r-i > 0 && c+i < board.length) {
          board[r-i][c+i] -= 1;
        }
        if (board[r-i][c+i] <= 0 && r-i > 0 && c+i < board.length) {
          return false;
        }
        if (board[r+i][c-i] > 0 && r+i < board.length && c-i > 0) {
          board[r+i][c-i] -= 1;
        }
        if (board[r+i][c-i] <= 0 && r+i < board.length && c-i > 0) {
          return false;
        }
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



}
