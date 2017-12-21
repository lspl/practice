package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序存在的前提：有向无环图
 * 拓扑排序的大致流程：
 * 	  首先找出所有入度为0的点，然后随机选择一个打印。将其指向的点的入度减1.
 * 再从入度为0的点中随机选择一个，重复，直至结束。
 *
 * @create 2017-12-19 20:09
 */
public class TopologySort {
    public static ArrayList<Node> topologySort(Graph graph){
        if (graph == null) {
            return null;
        }

        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        for(Node n : graph.nodes.values()) {
            if (n.in == 0) {
                q.add(n);
            }
        }

        while (!q.isEmpty()) {
            Node n = q.poll();
            list.add(n);
            for (Node n0 : n.nexts) {
                if(n0.in-- == 1) {
                    q.add(n0);
                }
            }
        }
        return list;
    }
}
