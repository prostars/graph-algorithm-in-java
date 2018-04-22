import com.sun.istack.internal.NotNull;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

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
