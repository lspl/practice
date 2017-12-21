package graph;

import java.util.*;

/**
 * @create 2017-12-19 19:02
 */
public class BFS {
    // 返回包含某节点的连通分量中的所有节点（如果是多个连通分量，则不适用）
    public static List<Node> bfs(Node node) {
        if (node == null) {
            return null;
        }

        HashSet<Node> set = new HashSet<>();
        List<Node> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        set.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            result.add(n);
            for (Node n0 : n.nexts) {
                if (!set.contains(n0)) {
                    q.add(n0);
                    set.add(n0);
                }
            }
        }
        return result;
    }
}
