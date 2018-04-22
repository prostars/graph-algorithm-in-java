import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DirectedGraphUsingMatrix {

    public DirectedGraphUsingMatrix(int[][] matrix) {
        adjacencyMatrix = matrix;
        setVertexCount(adjacencyMatrix.length);
        visited = new boolean[getVertexCount()];
    }

    public void dfsMatrix() {
        clearVisited();
        for (int i = 0; i < getVertexCount(); i++)
            if (!visited[i])
                dfs(i);
    }

    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.println(vertex);

        for (int v = 0; v < getVertexCount(); v++)
            if (!visited[v] && getAdjacencyMatrix()[vertex][v] == 1)
                dfs(v);
    }

    public void dfsUsingStack() {
        Stack<Integer> stack = new Stack<Integer>();
        clearVisited();

        for (int i = 0; i < getVertexCount(); i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int vertex = stack.pop();
                    System.out.println(vertex);
                    for (int j = 0; j < getVertexCount(); j++) {
                        if (getAdjacencyMatrix()[i][j] == 1 && !visited[j]) {
                            stack.push(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    private int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    private void clearVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    private void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    private int vertexCount = 0;
    private boolean[] visited;
    private int[][] adjacencyMatrix;
}
