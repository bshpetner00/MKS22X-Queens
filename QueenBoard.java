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

  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] == -1;
      return true;
    }
    else {
      return false;
    }
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      return true;
    }
    else {
      return false;
    }
  }



}
