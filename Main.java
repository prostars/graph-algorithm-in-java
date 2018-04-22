import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    int[][] matrix =
      {   //   0  1  2  3  4  5  6
        {0, 1, 1, 0, 0, 0, 0},  // 0
        {1, 0, 0, 0, 1, 0, 0},  // 1
        {1, 0, 0, 0, 0, 1, 0},  // 2
        {1, 0, 0, 0, 0, 0, 0},  // 3
        {0, 1, 0, 0, 0, 1, 1},  // 4
        {0, 0, 1, 0, 1, 0, 0},  // 5
        {0, 0, 0, 0, 0, 1, 0}   // 6
      };

    DirectedGraphUsingMatrix graphUsingMatrix = new DirectedGraphUsingMatrix(matrix);
    graphUsingMatrix.depthFirstSearch(0);
    System.out.println("-----------------------------------");
    graphUsingMatrix.depthFirstSearchForAll();
    System.out.println("-----------------------------------");
    graphUsingMatrix.depthFirstSearchForAllUsingStack();
    System.out.println("===================================");

    List<List<Integer>> adjacencyList = new ArrayList<>();
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.add(new ArrayList<>());
    adjacencyList.get(0).add(1);
    adjacencyList.get(0).add(2);
    adjacencyList.get(1).add(0);
    adjacencyList.get(1).add(4);
    adjacencyList.get(2).add(0);
    adjacencyList.get(2).add(5);
    adjacencyList.get(3).add(0);
    adjacencyList.get(4).add(1);
    adjacencyList.get(4).add(5);
    adjacencyList.get(4).add(6);
    adjacencyList.get(5).add(2);
    adjacencyList.get(5).add(4);
    adjacencyList.get(6).add(5);
    DirectedGraphUsingList graphUsingList = new DirectedGraphUsingList(adjacencyList);
    graphUsingList.depthFirstSearch(0);
    System.out.println("-----------------------------------");
    graphUsingList.depthFirstSearchForAll();
    System.out.println("-----------------------------------");
    graphUsingList.depthFirstSearchForAllUsingStack();
    System.out.println("-----------------------------------");
  }
}
