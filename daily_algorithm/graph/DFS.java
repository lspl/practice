package graph;

import java.util.*;

/**
 * @create 2017-12-19 19:36
 */
public class DFS {
    // 返回包含某节点的连通分量的所有节点（如果是多个连通分量，则不适用）
    public static List<Node> dfs(Node node) {
        if (node == null) {
            return null;
        }

        List<Node> result = new ArrayList<>();
        result.add(node);
        HashSet<Node> set = new HashSet<>();
        set.add(node);
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            for (Node n0 : n.nexts) {
                if (!set.contains(n0)) {
                    stack.push(n);
                    stack.push(n0);
                    set.add(n0);
                    result.add(n0);
                    break;
                }
            }
        }

        return result;
    }
}
