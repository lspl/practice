package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 权值不能为负
 * 解决的问题：从源结点到图中所有结点的最短路径值，具体的最短路径
 * 大致思路：源结点因为自己的边解锁一些结点。对于这些结点，选择最短路径尚未确定的点中边最短的结点，就
 * 可以确定其最短路径。对于这个指向的结点，如果使与其到源结点的距离更小，就更新它们的最短距离。
 * （到孤立点的距离为无穷大）
 *
 * ps: 此处边的权重等价于两点间的距离
 * @create 2017-12-20 9:49
 */
public class Dijkstra {
    // 方法一
    public static HashMap<Node, Integer> dijkstra1(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge e : minNode.edges) {
                Node to = e.to;
                if (!distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance + e.weight);
                } else {
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + e.weight));
                }
            }
            // minNode的距离已经确定，以后不用更改
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(distanceMap, selectedNodes);
        }

        return distanceMap;
    }

    public static Node getMinDistanceAndUnSelectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        Node target = null;
        int distance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> me : distanceMap.entrySet()) {
            if (!selectedNodes.contains(me.getKey()) && me.getValue() < distance) {
                target = me.getKey();
                distance = me.getValue();
            }
        }
        return target;
    }

    public static class NodeRecord {
        Node node;
        int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        Node[] nodes;
        HashMap<Node, Integer> heapIndex;
        HashMap<Node, Integer> distanceMap;
        int size;

        public NodeHeap(int size) {
            this.nodes = new Node[size];
            this.heapIndex = new HashMap<>();
            this.distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEntered(Node node) {
            return heapIndex.containsKey(node);
        }

        public boolean inHeap(Node node) {
            return isEntered(node) && heapIndex.get(node) != -1;
        }

        public void swap(int i, int j) {
            heapIndex.put(nodes[i], j);
            heapIndex.put(nodes[j], i);
            Node t = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = t;
        }

        public void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index, int size) {
            int left = 2 * index + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
                if (distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index])) {
                    swap(index, smallest);
                    left = smallest;
                } else {
                    break;
                }
            }
        }

        public NodeRecord pop() {
            NodeRecord node = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndex.put(node.node, -1);
            heapify(0, --size);
            return node;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (!isEntered(node)) {
                distanceMap.put(node, distance);
                heapIndex.put(node, size);
                nodes[size] = node;
                insertHeapify(node, size++);
            }

            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndex.get(node));
            }
        }
    }

    // 方法二：更改堆的调整方式(如果不知道结点个数size，可以先用bfs或dfs求出)
    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap heap = new NodeHeap(size);
        heap.addOrUpdateOrIgnore(head, 0);
        while (heap.size > 0) {
            NodeRecord record = heap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                heap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
        }
        return heap.distanceMap;
    }
}
