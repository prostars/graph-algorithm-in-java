import java.util.Stack;

public class DirectedGraphUsingMatrix {

  public DirectedGraphUsingMatrix(int[][] matrix) {
    adjacencyMatrix = matrix;
    setVertexCount(adjacencyMatrix.length);
    visited = new boolean[getVertexCount()];
  }

  public void depthFirstSearchForAll() {
    clearVisited();
    for (int i = 0; i < getVertexCount(); i++)
      if (!visited[i])
        depthFirstSearch(i);
  }

  public void depthFirstSearch(int startVertex) {
    visited[startVertex] = true;
    System.out.println(startVertex);

    for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++)
      if (!visited[targetVertex] && getAdjacencyMatrix()[startVertex][targetVertex] == 1)
        depthFirstSearch(targetVertex);
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

  public int getVertexCount() {
    return vertexCount;
  }

  private void setVertexCount(int vertexCount) {
    this.vertexCount = vertexCount;
  }

  private int[][] getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

  private void clearVisited() {
    for (int i = 0; i < visited.length; i++)
      visited[i] = false;
  }
  
  private int vertexCount = 0;
  private boolean[] visited;
  private int[][] adjacencyMatrix;
}
