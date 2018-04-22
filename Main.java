import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] matrix =
                {
                        {0, 1, 1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 1},
                        {0, 0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0}
                };

        DirectedGraphUsingMatrix graph = new DirectedGraphUsingMatrix(matrix);
        graph.dfs(0);
        System.out.println("-----------------------------------");
        graph.dfsMatrix();
        System.out.println("-----------------------------------");
        graph.dfsUsingStack();
    }
}
