import java.util.*;
//A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
//        A = {}, B = {3, 1, 4}, return []

public class CommonNumbersOfTwoArray {

        public List<Integer> common(List<Integer> a, List<Integer> b) {
            // Write your solution here
            Set<Integer> set = new HashSet<>();
            List<Integer> result = new ArrayList<>();

            set.addAll(a);
            for (int i = 0; i < b.size(); i++) {
                if (set.contains(b.get(i))) {
                    result.add(b.get(i));
                }
            }

            Collections.sort(result);

            return result;
        }
}

