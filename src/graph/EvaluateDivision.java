package graph;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

//Equations are given in the format A / B = k,
// where A and B are variables represented as strings,
// and k is a real number (floating point number).
// Given some queries, return the answers.
// If the answer does not exist, return -1.0.
//
//        Example:
//        Given a / b = 2.0, b / c = 3.0.
//        queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
//        return [6.0, 0.5, -1.0, 1.0, -1.0 ].
//
//        The input is: vector<pair<string, string>> equations,
// vector<double>& values,
// vector<pair<string, string>> queries ,
// where equations.size() == values.size(),
// and the values are positive.
// This represents the equations.
// Return vector<double>.
//
//        According to the example above:
//
//        equations = [ ["a", "b"], ["b", "c"] ],
//        values = [2.0, 3.0],
//        queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
//
//
//        The input is always valid.
// You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

/**
 * Runtime: 1 ms
 * Memory Usage: 34.1 MB
 * Time: O(V + E)
 * Space: O(V + E)
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // construct graph
        Map<String, List<String>> equationMap = new HashMap<>();
        Map<String, List<Double>> valueMap = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            if (!equationMap.containsKey(start)) {
                equationMap.put(start, new ArrayList<>());
            }
            if (!equationMap.containsKey(end)) {
                equationMap.put(end, new ArrayList<>());
            }
            if (!valueMap.containsKey(start)) {
                valueMap.put(start, new ArrayList<>());
            }
            if (!valueMap.containsKey(end)) {
                valueMap.put(end, new ArrayList<>());
            }
            equationMap.get(start).add(end);
            equationMap.get(end).add(start);
            valueMap.get(start).add(values[i]);
            valueMap.get(end).add(1 / values[i]); // corner case, 0.0
        }
        // query
        int m = queries.size();
        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = -1.0;
            Set<String> visited = new HashSet<>();
            visited.add(start);
            dfs(equationMap, valueMap, start, end, result, i, visited, 1.0);
        }
        return result;
    }

    private void dfs(Map<String, List<String>> equationMap, Map<String, List<Double>> valueMap, String start, String end, double[] result, int index, Set<String> visited, double cur) {
        if (!equationMap.containsKey(start)) {
            return;
        }
        if (start.equals(end)) {
            result[index] = cur;
            return;
        }
        List<String> nextList = equationMap.get(start);
        List<Double> valueList = valueMap.get(start);
        for (int i = 0; i < nextList.size(); i++) {
            if (!visited.contains(nextList.get(i))) {
                cur *= valueList.get(i);
                visited.add(nextList.get(i));
                dfs(equationMap, valueMap, nextList.get(i), end, result, index, visited, cur);
                cur /= valueList.get(i);
                visited.remove(nextList.get(i));
            }
        }
    }

//    [["a","b"],["b","c"]]
    public static void main(String[] args) {
        EvaluateDivision ins = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
//        "a","c"],["b","a"],["a","e"],["a","a"],["x","x"
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        System.out.println(Arrays.toString(ins.calcEquation(equations, values, queries)));
    }
}
