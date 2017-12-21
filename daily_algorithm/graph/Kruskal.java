package graph;

import java.util.*;

/**
 * 最小生成树是一副连通加权无向图中一棵权值最小的生成树(将图中所有点都连起来)
 *
 * Kruskal适用于无向图，用于生成最小生成树
 * PS: 生成的最小生成树不唯一，但是保证权值最低(原来的边中可能存在权值相等的边)
 *
 * 总体流程：从权值最低的边开始，加入集合中；如果形成环，就抛弃，否则加入。再从剩下
 * 的边中权值最低的开始，重复。直至考虑了所有的边。
 *
 * @create 2017-12-19 20:25
 */
public class Kruskal {
    // 并查集
    public static class UnionFind{
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> list) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : list) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findFather(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            int aSize = sizeMap.get(aFather);
            int bSize = sizeMap.get(bFather);
            if (aSize <= bSize) {
                fatherMap.put(aFather, bFather);
                sizeMap.put(bFather, aSize + bSize);
            } else {
                fatherMap.put(bFather, aFather);
                sizeMap.put(aFather, aSize + bSize);
            }

        }
    }

    // 使用了并查集
    public static Set<Edge> kruskal(Graph graph) {
        UnionFind uf = new UnionFind();
        uf.makeSets(graph.nodes.values());

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o->o.weight));
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!uf.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                uf.union(edge.from, edge.to);
            }
        }

        return result;
    }



}