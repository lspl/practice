package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @create 2017-12-19 18:38
 */
public class Graph {
    // 图中所有的点
    public HashMap<Integer, Node> nodes;
    // 图中所有的边
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
