import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingMatrix {

  public GraphUsingMatrix(int[][] matrix) {
    adjacencyMatrix = matrix;
    setVertexCount(adjacencyMatrix.length);
    visited = new boolean[getVertexCount()];
  }

  public void clearVisited() {
    for (int i = 0; i < visited.length; i++)
      visited[i] = false;
  }

  public void depthFirstSearch(int startVertex) {
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

  public void breadthFirstSearch(int startVertex) {
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

  public int getVertexCount() {
    return vertexCount;
  }

  private void setVertexCount(int vertexCount) {
    this.vertexCount = vertexCount;
  }

  private int[][] getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

  private int vertexCount = 0;
  private boolean[] visited;
  private int[][] adjacencyMatrix;
}
