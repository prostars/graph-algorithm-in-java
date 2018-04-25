import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    int[][] directedGraphAdjacencyMatrix =
      {//0  1  2  3  4
        {0, 1, 0, 0, 0},  // 0
        {0, 0, 1, 1, 0},  // 1
        {0, 0, 0, 1, 1},  // 2
        {1, 0, 0, 0, 1},  // 3
        {1, 0, 0, 1, 0}}; // 4

    GraphUsingMatrix graphUsingMatrix = new GraphUsingMatrix(directedGraphAdjacencyMatrix);
    System.out.println("===================================");
    System.out.println("- GraphUsingMatrix -");
    System.out.println("- depthFirstSearch -");
    graphUsingMatrix.clearVisited();
    graphUsingMatrix.depthFirstSearch(0);
    System.out.println("- depthFirstSearchForAll -");
    graphUsingMatrix.depthFirstSearchForAll();
    System.out.println("- depthFirstSearchForAllUsingStack -");
    graphUsingMatrix.depthFirstSearchForAllUsingStack();
    System.out.println("- breadthFirstSearch -");
    graphUsingMatrix.clearVisited();
    graphUsingMatrix.breadthFirstSearch(0);
    System.out.println("- breadthFirstSearchForAll -");
    graphUsingMatrix.breadthFirstSearchForAll();
    System.out.println("===================================");
    System.out.println("- check cycle -");
    System.out.println(graphUsingMatrix.hasCycleForAll());
    System.out.println("- check cycle using stack -");
    graphUsingMatrix.clearVisited();
    graphUsingMatrix.clearVisitHistoryForCheckingCycle();
    System.out.println(graphUsingMatrix.hasCycleUsingStack(0));
    System.out.println("===================================");
    System.out.println("- count cycle of distance 2 -");
    System.out.println(graphUsingMatrix.countInDirectedCycleOfDistanceN(2));
    System.out.println("- count cycle of distance 3 -");
    System.out.println(graphUsingMatrix.countInDirectedCycleOfDistanceN(3));
    System.out.println("- count cycle of distance 4 -");
    System.out.println(graphUsingMatrix.countInDirectedCycleOfDistanceN(4));
    System.out.println("- count cycle of distance 5 -");
    System.out.println(graphUsingMatrix.countInDirectedCycleOfDistanceN(5));

    System.out.println();

    List<List<Integer>> directedAdjacencyList = new ArrayList<>();
    directedAdjacencyList.add(new ArrayList<>());
    directedAdjacencyList.add(new ArrayList<>());
    directedAdjacencyList.add(new ArrayList<>());
    directedAdjacencyList.add(new ArrayList<>());
    directedAdjacencyList.add(new ArrayList<>());
    directedAdjacencyList.get(0).add(1);
    directedAdjacencyList.get(1).add(2);
    directedAdjacencyList.get(1).add(3);
    directedAdjacencyList.get(2).add(3);
    directedAdjacencyList.get(2).add(4);
    directedAdjacencyList.get(3).add(0);
    directedAdjacencyList.get(3).add(4);
    directedAdjacencyList.get(4).add(0);
    directedAdjacencyList.get(4).add(3);

    GraphUsingList graphUsingList = new GraphUsingList(directedAdjacencyList);
    System.out.println("===================================");
    System.out.println("- GraphUsingList -");
    System.out.println("- depthFirstSearch -");
    graphUsingList.clearVisited();
    graphUsingList.depthFirstSearch(0);
    System.out.println("- depthFirstSearchForAll -");
    graphUsingList.depthFirstSearchForAll();
    System.out.println("- depthFirstSearchForAllUsingStack -");
    graphUsingList.depthFirstSearchForAllUsingStack();
    System.out.println("- breadthFirstSearch -");
    graphUsingList.clearVisited();
    graphUsingList.breadthFirstSearch(0);
    System.out.println("- breadthFirstSearchForAll -");
    graphUsingList.breadthFirstSearchForAll();
    System.out.println("===================================");
    System.out.println("- check cycle -");
    System.out.println(graphUsingList.hasCycleForAll());
    System.out.println("- check cycle using stack -");
    graphUsingList.clearVisited();
    graphUsingList.clearVisitHistoryForCheckingCycle();
    System.out.println(graphUsingList.hasCycleUsingStack(0));
  }
}
