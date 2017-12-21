package graph;

import java.util.ArrayList;

/**
 * @create 2017-12-19 18:30
 */
public class Node {
    // 结点记号
    public int value;
    // 结点入度
    public int in;
    // 结点出度
    public int out;
    // 指向的结点
    public ArrayList<Node> nexts;
    // 相邻的边（不考虑方向）
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = 0;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
