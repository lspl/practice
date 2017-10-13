import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lishunpu
 * @create 2017-09-23 14:36
 */
public class Main37 {
    public static int process(int N, int M) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        int k = 0;
        for (int i = 0; list.size() != 1;) {
            k++;
            if (k == M) {
                System.out.print(list.get(i) + " ");
                list.remove(list.remove(i));
                k = 0;
            } else {
                i++;
            }
            if (i == list.size()) {
                i = 0;
            }
        }

        System.out.print("------");
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int N = input.nextInt();
            int M = input.nextInt();
            System.out.println(process(N, M));
        }
    }
}
