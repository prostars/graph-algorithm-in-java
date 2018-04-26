import com.sun.istack.internal.NotNull;
import java.util.*;

public class GraphUsingMatrix {

  public GraphUsingMatrix(@NotNull final int[][] matrix) {
    adjacencyMatrix = matrix;
    setVertexCount(adjacencyMatrix.length);
    visited = new boolean[getVertexCount()];
    visitHistoryForCheckingCycle = new boolean[getVertexCount()];
  }

  public int getVertexCount() {
    return vertexCount;
  }

  public void clearVisited() {
    for (int i = 0; i < visited.length; i++)
      visited[i] = false;
  }

  public void clearVisitHistoryForCheckingCycle() {
    for (int i = 0; i < visitHistoryForCheckingCycle.length; i++)
      visitHistoryForCheckingCycle[i] = false;
  }

  public void depthFirstSearch(final int startVertex) {
    visited[startVertex] = true;
    System.out.println(startVertex);

    for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++)
      if (!visited[targetVertex] && getAdjacencyMatrix()[startVertex][targetVertex] == 1)
        depthFirstSearch(targetVertex);
  }

  public void depthFirstSearchForAll() {
    clearVisited();
    for (int i = 0; i < getVertexCount(); i++)
      if (!visited[i])
        depthFirstSearch(i);
  }

  public void depthFirstSearchForAllUsingStack() {
    Stack<Integer> stack = new Stack<>();
    clearVisited();

    for (int startVertex = 0; startVertex < getVertexCount(); startVertex++) {
      if (!visited[startVertex]) {
        stack.push(startVertex);
        visited[startVertex] = true;
        
        while (!stack.isEmpty()) {
          int currentVertex = stack.pop();
          System.out.println(currentVertex);
          for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++) {
            if (getAdjacencyMatrix()[startVertex][targetVertex] == 1 && !visited[targetVertex]) {
              stack.push(targetVertex);
              visited[targetVertex] = true;
            }
          }
        }
      }
    }
  }

  public void breadthFirstSearch(final int startVertex) {
    Queue<Integer> queue = new LinkedList<>();

    if (!visited[startVertex]) {
      queue.offer(startVertex);
      visited[startVertex] = true;
      while (!queue.isEmpty()) {
        int currentVertex = queue.poll();
        System.out.println(currentVertex);
        for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++) {
          if (getAdjacencyMatrix()[currentVertex][targetVertex] == 1 && !visited[targetVertex]) {
            queue.offer(targetVertex);
            visited[targetVertex] = true;
          }
        }
      }
    }
  }

  public void breadthFirstSearchForAll() {
    clearVisited();
    for (int startVertex = 0; startVertex < getVertexCount(); startVertex++)
      breadthFirstSearch(startVertex);
  }

  public boolean hasCycle(final int startVertex) {
    if (!visited[startVertex]) {
      visited[startVertex] = true;
      visitHistoryForCheckingCycle[startVertex] = true;

      for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++) {
        if (!visited[targetVertex] && getAdjacencyMatrix()[startVertex][targetVertex] == 1 && hasCycle(targetVertex))
          return true;
        else if (visitHistoryForCheckingCycle[targetVertex])
          return true;
      }
    }
    visitHistoryForCheckingCycle[startVertex] = false;
    return false;
  }

  public boolean hasCycleForAll() {
    clearVisited();
    clearVisitHistoryForCheckingCycle();
    for (int startVertex = 0; startVertex < getVertexCount(); startVertex++)
      if (hasCycle(startVertex))
        return true;

    return false;
  }

  public boolean hasCycleUsingStack(final int startVertex) {
    Stack<Integer> stack = new Stack<>();

    if (!visited[startVertex]) {
      stack.push(startVertex);

      while(!stack.isEmpty()) {
        int currentVertex = stack.pop();
        visited[currentVertex] = true;
        visitHistoryForCheckingCycle[currentVertex] = true;

        if (Arrays.stream(getAdjacencyMatrix()[currentVertex]).noneMatch(v -> v == 1)) {
          visitHistoryForCheckingCycle[currentVertex] = false;
          return false;
        }

        for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++) {
          if (!visited[targetVertex] && getAdjacencyMatrix()[startVertex][targetVertex] == 1)
            stack.push(targetVertex);
          else if (visitHistoryForCheckingCycle[targetVertex])
            return true;
        }
      }
    }
    visitHistoryForCheckingCycle[startVertex] = false;
    return false;
  }

  public int countInDirectedCycleOfDistanceN(final int distance) {
    clearVisited();
    cycleCount = 0;

    if (distance < 1)
      return 0;

    for (int startVertex = 0; startVertex < getVertexCount() - (distance - 1); startVertex++) {
      countInDirectedCycleOfDistanceN(distance - 1, startVertex, startVertex);
      visited[startVertex] = true;
    }

    return cycleCount;
  }

  private void countInDirectedCycleOfDistanceN(final int remainDistance, final int currentVertex, final int startVertex) {
    visited[currentVertex] = true;

    if (remainDistance == 0) {
      visited[currentVertex] = false;
      if (getAdjacencyMatrix()[currentVertex][startVertex] == 1)
        cycleCount++;
      return;
    }

    for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++)
      if (!visited[targetVertex] && getAdjacencyMatrix()[currentVertex][targetVertex] == 1)
        countInDirectedCycleOfDistanceN(remainDistance - 1, targetVertex, startVertex);

    visited[currentVertex] = false;
  }

  private void setVertexCount(final int vertexCount) {
    this.vertexCount = vertexCount;
  }

  private int[][] getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

  private int vertexCount = 0;
  private int cycleCount = 0;
  private boolean[] visited;
  private boolean[] visitHistoryForCheckingCycle;
  private int[][] adjacencyMatrix;
}
