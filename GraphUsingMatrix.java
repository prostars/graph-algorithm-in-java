import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GraphUsingMatrix {

    public GraphUsingMatrix(List<List<Integer>> matrix) {
        adjacencyMatrix = matrix;
        setVertexCount(adjacencyMatrix.size());
        visited = new ArrayList<Boolean>(Collections.nCopies(getVertexCount(), false));
    }

    public void dfsMatrix() {
        clearVisited();
        for (int i = 0; i < getVertexCount(); i++)
            if (!visited.get(i))
                dfs(i);
    }

    public void dfs(int vertexIndex) {
        visited.set(vertexIndex, true);
        System.out.println(vertexIndex);

        for (int v = 0; v < getVertexCount(); v++)
            if (!visited.get(v) && getAdjacencyMatrix().get(vertexIndex).get(v) == 1)
                dfs(v);
    }

    public void dfsUsingStack() {
        Stack<Integer> stack = new Stack<Integer>();
        clearVisited();

        for (int i = 0; i < getVertexCount(); i++) {
            if (!visited.get(i)) {
                stack.push(i);
                visited.set(i, true);
                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    System.out.println(vertex);
                    for (int j = 0; j < getVertexCount(); j++) {
                        if (getAdjacencyMatrix().get(i).get(j) == 1 && !visited.get(j)) {
                            stack.push(j);
                            visited.set(j, true);
                        }
                    }
                }
            }
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    private List<List<Integer>> getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    private void clearVisited() {
        for (int i = 0; i < visited.size(); i++)
            visited.set(i, false);
    }

    private void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    private int vertexCount = 0;
    private List<Boolean> visited;
    private List<List<Integer>> adjacencyMatrix;
}
