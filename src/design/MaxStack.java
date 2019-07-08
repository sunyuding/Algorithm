package design;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

//Design a max stack that supports push, pop, top, peekMax and popMax.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Remove the element on top of the stack and return it.
//        top() -- Get the element on the top.
//        peekMax() -- Retrieve the maximum element in the stack.
//        popMax() -- Retrieve the maximum element in the stack, and remove it.
// If you find more than one maximum elements, only remove the top-most one.
//
//        Example 1:
//        MaxStack stack = new MaxStack();
//        stack.push(5);
//        stack.push(1);
//        stack.push(5);
//        stack.top(); -> 5
//        stack.popMax(); -> 5
//        stack.top(); -> 1
//        stack.peekMax(); -> 5
//        stack.pop(); -> 1
//        stack.top(); -> 5
//        Note:
//        -1e7 <= x <= 1e7
//        Number of operations won't exceed 10000.
//        The last four operations won't be called when stack is empty.
//public class MaxStack {
//    Deque<Integer> stack = new ArrayDeque<>();
//    Deque<Integer> maxStack = new ArrayDeque<>();
//
//    /** initialize your data structure here. */
//    public MaxStack() {
//        this.maxStack = new ArrayDeque<>();
//        this.stack = new ArrayDeque<>();
//    }
//
//    //O(1)
//    public void push(int x) {
//        if (maxStack.isEmpty()) {
//            maxStack.push(x);
//        } else {
//            maxStack.push(Math.max(maxStack.peek(), x));
//        }
//        stack.push(x);
//    }
//
//    //O(1)
//    public int pop() {
//        maxStack.pop();
//        return stack.pop();
//    }
//
//    //O(1)
//    public int top() {
//        return stack.peek();
//    }
//
//    //O(1)
//    public int peekMax() {
//        return maxStack.peek();
//    }
//
//    //O(n)
//    public int popMax() {
//        int max = peekMax();
//        Deque<Integer> tmpStack = new ArrayDeque<>();
//        while(top() != max) {
//            tmpStack.push(pop());
//        }
//        //top() == max
//        pop();
//        while(!tmpStack.isEmpty()) {
//            push(tmpStack.pop());
//        }
//        return max;
//    }
//}

public class MaxStack {
    private class Node {
        Node prev, next;
        int val;

        Node(int x) {
            val = x;
        }
    }

    Node head, tail;
    TreeMap<Integer, List<Node>> map;

    /** initialize your data structure here. */
    public MaxStack() {
        this.map = new TreeMap<>();
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    //O(logn)
    public void push(int x) {
        if (!map.containsKey(x)) {
            map.put(x, new LinkedList<>());
        }

        Node newNode = new Node(x);
        newNode.next = tail;
        newNode.prev = tail.prev;
        newNode.next.prev = newNode;
        newNode.prev.next= newNode;
        map.get(x).add(newNode);
    }

    //O(logn)
    public int pop() {
        int val = tail.prev.val;

        tail = tail.prev;
        tail.next = null;

        List<Node> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(val);
        }

        return val;
    }

    //O(logn)
    public int top() {
        return tail.prev.val;
    }

    //O(logn)
    public int peekMax() {
        return map.lastKey();
    }

    //O(logn)
    public int popMax() {
        int max = map.lastKey();
        List<Node> list = map.get(max);

        Node maxNode = list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(max);
        }

        Node prev = maxNode.prev;
        Node next = maxNode.next;
        prev.next = next;
        next.prev = prev;

        return max;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(6);
        int param_2 = obj.peekMax();
        int param_3 = obj.popMax();
        int param_4 = obj.popMax();
        int param_5 = obj.top();
    }
}
