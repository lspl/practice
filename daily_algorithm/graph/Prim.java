package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Prim适用于无向图，用于生成最小生成树。
 * PS: 生成的最小生成树不唯一，但是保证权值最低(原来的边中可能存在权值相等的边)
 *
 * 总体思路：一个点加入进来，解锁一些边。在所有被解锁的边中选一个没有使用
 * 并且权值最低的边，解锁新的点。再将新的点的新的边加入进来，再解锁新的边。
 * 重复，直至所有边都考虑过
 *
 * @create 2017-12-19 21:40
 */
public class Prim {
    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Edge> result = new HashSet<>();
        // 已经考虑过的结点
        Set<Node> set = new HashSet<>();

        // for循环用于解决多个连通分量的问题
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node to = edge.to;
                    if (!set.contains(to)) {
                        set.add(to);
                        result.add(edge);
                        priorityQueue.addAll(to.edges);
                    }
                }
            }
        }
        return result;
    }
}
