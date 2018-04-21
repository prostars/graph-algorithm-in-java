import java.util.ArrayList;
import java.util.List;

public class GraphUsingList {
  public int getVertex() {
    return vertex;
  }

  public void setVertex(int vertex) {
    this.vertex = vertex;
  }

  public int getEdge() {
    return edge;
  }

  public void setEdge(int edge) {
    this.edge = edge;
  }

  public List<List<Integer>> getAdjacencyList() {
    return adjacencyList;
  }

   private int vertex = 0;
  private int edge = 0;
  private List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
}
