## 代码运行

&ensp;&ensp;&ensp;&ensp;下面以下图运行代码(其中左侧的图为无向图，红线部分为最小生成树的边，右侧为有向图):

![图](https://raw.githubusercontent.com/lspl/practice/temp/images/%E5%9B%BE%E7%A4%BA%E4%BE%8B.png)

&ensp;&ensp;&ensp;&ensp;为了方便表示结点，为每个结点（Node）增加了一个value属性，比如0号结点的value就是0,5号结点的value就是5。

&ensp;&ensp;&ensp;&ensp;图的输入为二维矩阵，其中每个一维矩阵包含三个元素，分别是(from, to, weight), 表示（起点，终点，权重）。在dijkstra算法中，此处的权重表示路径长度。（图的生成代码在GraphGenerator类中）

&ensp;&ensp;&ensp;&ensp;详细代码如下：
```java
package graph;

import java.util.*;

/**
 * @create 2017-12-20 17:10
 */
public class Main {
    public static void main(String[] args) {
        // matrix1和graph1对应左图，matrix2和graph2对应右图
        int[][] matrix1 = {
                {4, 7, 7},  {7, 4, 7},  {2, 8, 8},  {8, 2, 8},  {0, 1, 10}, {1, 0, 10}, {0, 5, 11}, {5, 0, 11},
                {1, 8, 12}, {8, 1, 12}, {3, 7, 16}, {7, 3, 16}, {1, 6, 16}, {6, 1, 16}, {5, 6, 17}, {6, 5, 17},
                {1, 2, 18}, {2, 1, 18}, {6, 7, 19}, {7, 6, 19}, {3, 4, 20}, {4, 3, 20}, {3, 8, 21}, {8, 3, 21},
                {2, 3, 22}, {3, 2, 22}, {3, 6, 24}, {6, 3, 24}, {4, 5, 26}, {5, 4, 26},
        };

        int[][] matrix2 = {
                {4, 7, 7}, {2, 8, 8}, {0, 1, 10}, {0, 5, 11}, {1, 8, 12}, {3, 7, 16}, {1, 6, 16}, {5, 6, 17},
                {1, 2, 18}, {6, 7, 19}, {3, 4, 20}, {3, 8, 21}, {2, 3, 22}, {3, 6, 24}, {4, 5, 26},
        };

        Graph graph1 = GraphGenerator.generateGraph(matrix1);
        Graph graph2 = GraphGenerator.generateGraph(matrix2);

        // bfs
        System.out.print("bfs运行结果：");
        List<Node> list1 = BFS.bfs(graph1.nodes.get(0));
        for (Node n : list1) {
            System.out.print(n.value + " ");
        }
        // 运行结果：0 1 5 8 6 2 4 3 7

        // dfs
        System.out.print("\ndfs运行结果：");
        List<Node> list2 = DFS.dfs(graph1.nodes.get(0));
        for (Node n : list2) {
            System.out.print(n.value + " ");
        }
        // 运行结果：0 1 8 2 3 7 4 5 6

        // 拓扑排序
        System.out.print("\n拓扑排序运行结果：");
        List<Node> list3 = TopologySort.topologySort(graph2);
        for (Node n : list3) {
            System.out.print(n.value + " ");
        }
        // 运行结果：0 1 2 3 4 8 5 6 7

        // Kruskal算法
        System.out.print("\nkruskal运行结果：");
        Set<Edge> set1 = Kruskal.kruskal(graph1);
        for (Edge e : set1) {
            System.out.print(e.weight + " ");
        }
        // 运行结果：12 16 16 11 7 8 10 19

        // prim算法
        System.out.print("\nprim运行结果：");
        Set<Edge> set2 = Prim.prim(graph1);
        for (Edge e : set2) {
            System.out.print(e.weight + " ");
        }
        // 运行结果：10 12 16 16 11 19 7 8

        // dijkstra算法
        System.out.print("\ndijkstra1运行结果：");
        HashMap<Node, Integer> map1 = Dijkstra.dijkstra1(graph1.nodes.get(0));
        for (Map.Entry<Node, Integer> me : map1.entrySet()) {
            System.out.print("[" + me.getKey().value + ":" + me.getValue() + "] ");
        }
        // 运行结果：[5:11] [6:26] [8:22] [2:28] [7:44] [4:37] [0:0] [1:10] [3:43]

        System.out.print("\ndijkstra2运行结果：");
        HashMap<Node, Integer> map2 = Dijkstra.dijkstra2(graph2.nodes.get(0), graph2.nodes.size());
        for (Map.Entry<Node, Integer> me : map2.entrySet()) {
            System.out.print("[" + me.getKey().value + ":" + me.getValue() + "] ");
        }
        // 运行结果：[5:11] [6:26] [8:22] [2:28] [4:70] [7:45] [0:0] [1:10] [3:50]
    }
}
```