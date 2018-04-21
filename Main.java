import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.get(0).add(0);
        matrix.get(0).add(1);
        matrix.get(0).add(1);
        matrix.get(0).add(0);
        matrix.get(0).add(0);
        matrix.get(0).add(0);
        matrix.get(0).add(0);

        matrix.get(1).add(1);
        matrix.get(1).add(0);
        matrix.get(1).add(0);
        matrix.get(1).add(0);
        matrix.get(1).add(1);
        matrix.get(1).add(0);
        matrix.get(1).add(0);

        matrix.get(2).add(1);
        matrix.get(2).add(0);
        matrix.get(2).add(0);
        matrix.get(2).add(0);
        matrix.get(2).add(0);
        matrix.get(2).add(1);
        matrix.get(2).add(0);

        matrix.get(3).add(1);
        matrix.get(3).add(0);
        matrix.get(3).add(0);
        matrix.get(3).add(0);
        matrix.get(3).add(0);
        matrix.get(3).add(0);
        matrix.get(3).add(0);

        matrix.get(4).add(0);
        matrix.get(4).add(1);
        matrix.get(4).add(0);
        matrix.get(4).add(0);
        matrix.get(4).add(0);
        matrix.get(4).add(1);
        matrix.get(4).add(1);

        matrix.get(5).add(0);
        matrix.get(5).add(0);
        matrix.get(5).add(1);
        matrix.get(5).add(0);
        matrix.get(5).add(1);
        matrix.get(5).add(0);
        matrix.get(5).add(0);

        matrix.get(6).add(0);
        matrix.get(6).add(0);
        matrix.get(6).add(0);
        matrix.get(6).add(0);
        matrix.get(6).add(0);
        matrix.get(6).add(1);
        matrix.get(6).add(0);

        GraphUsingMatrix graph = new GraphUsingMatrix(matrix);
        graph.dfs(0);
        System.out.println("-----------------------------------");
        graph.dfsMatrix();
        System.out.println("-----------------------------------");
        graph.dfsUsingStack();
    }
}
