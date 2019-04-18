public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        int res = 0;
        boolean isEmpty = false;
        while(!isEmpty) {
            isEmpty = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] > 0) {
                    res++;
                    map[i]--;
                    isEmpty = false;
                }
            }
            res++;
        }
        res--;
        return res;
    }

    public static void main(String[] args) {
        TaskScheduler ins = new TaskScheduler();
        ins.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
