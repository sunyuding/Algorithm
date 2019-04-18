import java.util.ArrayList;
import java.util.List;

public class InvalidParenthese {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[] { '(', ')' });
        return ans;
    }
    public void remove(String s, List<String> ans, int last_i, int last_j,
                       char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0])
                stack++;
            if (s.charAt(i) == par[1])
                stack--;
            if (stack >= 0)
                continue;
            for (int j = last_j; j <= i; ++j)//从上个去除位置开始找
                if (s.charAt(j) == par[1]
                        && (j == last_j || s.charAt(j - 1) != par[1]))//是要去除的符号且（是起始位置或前面不是“）”，以免重复）。
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()),
                            ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove(reversed, ans, 0, 0, new char[] { ')', '(' });//反过来时，正反括号也反
        else
            ans.add(reversed);//正反都完成，得到答案
    }

    public static void main(String[] args) {
        InvalidParenthese ins = new InvalidParenthese();
        ins.removeInvalidParentheses("(a)())()");
    }
}
