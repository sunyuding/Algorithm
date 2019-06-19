package doomsday_fuel;

import java.util.LinkedList;
import java.util.Queue;

//Write a function solution(m) that takes an array of array of nonnegative ints
// representing how many times that state has gone to the next state
// and return an array of ints for each terminal state giving the exact probabilities of each terminal state,
// represented as the numerator for each state,
// then the denominator for all of them at the end and in simplest form.
// The matrix is at most 10 by 10.
// It is guaranteed that no matter which state the ore is in,
// there is a path from that state to a terminal state.
// That is, the processing will always eventually end in a stable state.
// The ore starts in state 0.
// The denominator will fit within a signed 32-bit integer during the calculation,
// as long as the fraction is simplified regularly.
//For example, consider the matrix m:
//       [
//        [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
//        [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
//        [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
//        [0,0,0,0,0,0],  # s3 is terminal
//        [0,0,0,0,0,0],  # s4 is terminal
//        [0,0,0,0,0,0],  # s5 is terminal
//       ]
//So, we can consider different paths to terminal states, such as:
//        s0 -> s1 -> s3
//        s0 -> s1 -> s0 -> s1 -> s0 -> s1 -> s4
//        s0 -> s1 -> s0 -> s5
//        Tracing the probabilities of each, we find that
//        s2 has probability 0
//        s3 has probability 3/14
//        s4 has probability 1/7
//        s5 has probability 9/14
//        So, putting that together, and making a common denominator, gives an answer in the form of
//        [s2.numerator, s3.numerator, s4.numerator, s5.numerator, denominator] which is
//        [0, 3, 2, 9, 14].
public class Solution {
    public static int[] solution(int[][] m) {
        // Your code here
        StateNode[] stateNodes = new StateNode[m.length];
        for(int i = 0; i < m.length; i++) {
            stateNodes[i] = new StateNode(m[i]);
        }

        boolean[] isTerminalState = new boolean[m.length];
        int numTerminalStates = 0;
        for(int i = 0; i < stateNodes.length; i++) {
            if( stateNodes[i].isTerminal() ) {
                isTerminalState[i] = true;
                numTerminalStates++;
            }
        }

        Fraction[] endStateProbability = new Fraction[stateNodes.length];
        for(int i = 0; i < endStateProbability.length; i++) {
            endStateProbability[i] = new Fraction(0,1);
        }
        int currState = 0;
        Fraction factor;
        Fraction currFactor = new Fraction(1,1);
        Queue<Integer> stateQueue = new LinkedList<>();
        Queue<Fraction> factorQueue = new LinkedList<>();
        stateQueue.add(currState);
        factorQueue.add(currFactor);

        while( !stateQueue.isEmpty() && !factorQueue.isEmpty() ) {
            currState = stateQueue.remove();
            currFactor = factorQueue.remove();
            if( !isTerminalState[currState] && !currFactor.lessThan(0.005) ) {
                for(int i = 0; i < stateNodes.length; i++) {
                    factor = stateNodes[currState].getTransformChance( i );
                    if( !factor.isZero() ) {
                        factor = factor.getCopy();
                        factor.times(currFactor);
                        if( !isTerminalState[i] ) {
                            stateQueue.add(i);
                            factorQueue.add( factor );
                        } else {
                            endStateProbability[i].plus(factor);
                        }
                    }
                }
            }
        }


        int denom = 1;
        int hsetIndex = 0;
        Fraction[] helperSet = new Fraction[numTerminalStates];
        for(int i = 0; i < isTerminalState.length; i++){
            if( isTerminalState[i] ) {
                helperSet[hsetIndex] =  endStateProbability[i];
                denom = Fraction.lcm( denom, helperSet[hsetIndex].getDenominator() );
                hsetIndex++;
            }
        }

        int multiple = 1;
        int[] resultSet = new int[numTerminalStates + 1];
        for( int i = 0; i < resultSet.length-1; i++) {
            multiple = denom / helperSet[i].getDenominator();
            resultSet[i] = helperSet[i].getNumerator() * multiple;
        }
        resultSet[resultSet.length-1] = denom;

        return resultSet;
    }

    static class Fraction{
        private int numerator = 0;
        private int denominator = 1;

        public Fraction(int num, int denom){
            if(denom != 0) {
                numerator = num;
                denominator = denom;
            }
        }

        public Fraction getCopy() {
            return new Fraction(numerator, denominator);
        }

        public boolean lessThan(double ratio){
            double value = ((double) numerator / ( (double) denominator));
            return ratio > value;
        }

        public int getNumerator() {
            return numerator;
        }
        public int getDenominator() {
            return denominator;
        }
        public boolean isZero() {
            return numerator == 0;
        }

        public void plus( Fraction b ) {
            numerator = denominator * b.getNumerator() + numerator * b.getDenominator();
            denominator = denominator * b.getDenominator();

            reduce();
        }

        public void times( Fraction b ) {
            numerator *= b.getNumerator();
            denominator *= b.getDenominator();

            reduce();
        }

        public void reduce() {
            int gcd = gcm(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        public static int gcm(int a, int b) {
            return b == 0 ? a : gcm(b, a % b);
        }
        public static int lcm(int a, int b){
            return (a * b) / gcm(a, b);
        }
    }

    static class StateNode{
        private int denominator = 0;
        private int[] numerators = null;
        private Fraction[] transformChance= null;
        private static Fraction zeroFraction;
        static {
            zeroFraction = new Fraction(0, 1);
        };

        public StateNode(int[] nextStateMap) {
            int length = nextStateMap.length;
            numerators = new int[length];
            transformChance = new Fraction[length];
            for(int i = 0; i < length; i++ ){
                numerators[i] = nextStateMap[i];
            }

            processMap();
        }

        private void processMap() {
            denominator = 0;
            for(int i : numerators) {
                denominator += i;
                if( i < 0 ) {
                    denominator = 0;
                    return;
                }
            }

            if( !isTerminal() ) {
                for(int i = 0; i < numerators.length; i++) {
                    transformChance[i] = new Fraction(numerators[i], denominator);
                }
            }
        }

        public boolean isTerminal() {
            return denominator == 0;
        }

        public Fraction getTransformChance(int state) {
            if( state < 0 || state > numerators.length || isTerminal() ) {
                return zeroFraction;
            }
            return transformChance[state];
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][]{{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}}));
    }
}




