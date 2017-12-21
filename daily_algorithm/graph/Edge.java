package graph;

/**
 * @create 2017-12-19 18:35
 */
public class Edge {
    public Node from;
    public Node to;
    // 权重
    public int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
