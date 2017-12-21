package graph;

/**
 * @create 2017-12-19 18:42
 */
public class GraphGenerator {
    // from to weight
    public static Graph generateGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Node from = graph.nodes.get(matrix[i][0]);
            Node to = graph.nodes.get(matrix[i][1]);
            Integer weight = matrix[i][2];
            if (from == null) {
                from = new Node(matrix[i][0]);
                from.value = matrix[i][0];
                graph.nodes.put(matrix[i][0], from);
            }
            if (to == null) {
                to = new Node(matrix[i][1]);
                to.value = matrix[i][1];
                graph.nodes.put(matrix[i][1], to);
            }
            Edge edge = new Edge(from, to, weight);
            graph.edges.add(edge);
            from.out++;
            from.nexts.add(to);
            from.edges.add(edge);
            to.in++;
            to.edges.add(edge);
        }

        return graph;
    }
}
