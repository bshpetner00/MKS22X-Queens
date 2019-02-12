public class Driver {
  public static void main(String[] args) {
    QueenBoard b = new QueenBoard(6);
    System.out.println(b.toString());
    b.addQueen(0,0);
    System.out.println(b.toString());
    b.addQueen(0,0);
    System.out.println(b.toString());
    b.removeQueen(0,0);
    System.out.println(b.toString());
    b.solve();
    System.out.println(b.toString());
    QueenBoard x = new QueenBoard(8);
    System.out.println("Possible solutions for board x: " + x.countSolutions());
  }
}
