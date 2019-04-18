import java.util.ArrayList;
import java.util.List;

public class Binbin {
    private static final int DIFF = 5;// 5 is just an example
    public List<Integer> parseList(List<Integer> input, int diff) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.size() == 0) return result;
        int pre = input.get(0);
        result.add(pre);
        for (int cur : input) {
            if (cur - pre > diff) {
                pre = cur;// update the starting element
                result.add(cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add(i);
        }
        System.out.println(input);
        Binbin obj = new Binbin();
        List<Integer> result = obj.parseList(input, DIFF);
        System.out.println(result);
    }
}
