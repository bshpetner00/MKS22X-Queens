public class Driver {
  public static void main(String[] args) {

    QueenBoard eight = new QueenBoard(8);
    QueenBoard one = new QueenBoard(1);
    QueenBoard two = new QueenBoard(2);
    QueenBoard three = new QueenBoard(3);
    QueenBoard four = new QueenBoard(4);
    QueenBoard five = new QueenBoard(5);
    QueenBoard six = new QueenBoard(6);
    QueenBoard x = new QueenBoard(7);
    System.out.println("Possible solutions for board 1: " + one.countSolutions());
    System.out.println("Possible solutions for board 2: " + two.countSolutions());
    System.out.println("Possible solutions for board 3: " + three.countSolutions());
    System.out.println("Possible solutions for board 4: " + four.countSolutions());
    System.out.println("Possible solutions for board 5: " + five.countSolutions());
    System.out.println("Possible solutions for board 6: " + six.countSolutions());
    System.out.println("Possible solutions for board 7: " + x.countSolutions());
    System.out.println("Possible solutions for board 8: " + eight.countSolutions());
  }
}
