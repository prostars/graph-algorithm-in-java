import java.util.List;
import java.util.Stack;

public class DirectedGraphUsingList {

  public DirectedGraphUsingList(List<List<Integer>> adjacencyList) {
    this.adjacencyList = adjacencyList;
    setVertexCount(adjacencyList.size());
    visited = new boolean[getVertexCount()];
  }

  public void dfsForAll() {
    clearVisited();
    for (int vertex = 0; vertex < getVertexCount(); vertex++)
      if (!visited[vertex])
        dfs(vertex);
  }

  public void dfs(int startVertex) {
    visited[startVertex] = true;
    System.out.println(startVertex);

    List<Integer> adj = getAdjacencyList().get(startVertex);
    adj.forEach(targetVertex -> {
      if (!visited[targetVertex])
        dfs(targetVertex);
    });
  }

  public void dfsForAllUsingStack() {
    Stack<Integer> stack = new Stack<>();
    clearVisited();

    for (int startVertex = 0; startVertex < getVertexCount(); startVertex++) {
      if (!visited[startVertex]) {
        stack.push(startVertex);
        visited[startVertex] = true;
        while (!stack.isEmpty()) {
          int currentVertex = stack.pop();
          System.out.println(currentVertex);
          List<Integer> adj = getAdjacencyList().get(currentVertex);
          adj.forEach(targetVertex -> {
            if (!visited[targetVertex]) {
              stack.push(targetVertex);
              visited[targetVertex] = true;
            }
          });
        }
      }
    }
  }

  public int getVertexCount() {
    return vertexCount;
  }

  private List<List<Integer>> getAdjacencyList() {
    return adjacencyList;
  }

  private void clearVisited() {
    for (int i = 0; i < visited.length; i++)
      visited[i] = false;
  }

  private void setVertexCount(int vertexCount) {
    this.vertexCount = vertexCount;
  }

  private int vertexCount;
  private boolean[] visited;
  private List<List<Integer>> adjacencyList;
}
