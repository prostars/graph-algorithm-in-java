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

    public void dfsForAll() {
        clearVisited();
        for (int i = 0; i < getVertexCount(); i++)
            if (!visited[i])
                dfs(i);
    }

    public void dfs(int startVertex) {
        visited[startVertex] = true;
        System.out.println(startVertex);

        for (int targetVertex = 0; targetVertex < getVertexCount(); targetVertex++)
            if (!visited[targetVertex] && getAdjacencyMatrix()[startVertex][targetVertex] == 1)
                dfs(targetVertex);
    }

    public void dfsForAllUsingStack() {
        Stack<Integer> stack = new Stack<Integer>();
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
