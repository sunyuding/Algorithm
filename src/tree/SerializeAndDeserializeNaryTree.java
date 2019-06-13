package tree;
// Serialization is the process of converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer,
// or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//        Design an algorithm to serialize and deserialize an N-ary tree.
// An N-ary tree is a rooted tree in which each node has no more than N children.
// There is no restriction on how your serialization/deserialization algorithm should work.
// You just need to ensure that an N-ary tree can be serialized to a string
// and this string can be deserialized to the original tree structure.
//
//        For example, you may serialize the following 3-ary tree
//        as [1 [3[5 6] 2 4]].
// You do not necessarily need to follow this format,
// so please be creative and come up with different approaches yourself.
//
//
//
//        Note:
//
//        N is in the range of [1, 1000]
//        Do not use class member/global/static variables to store states.
// Your serialize and deserialize algorithms should be stateless.


import java.util.*;

//public class SerializeAndDeserializeNaryTree {
//
//    // Encodes a tree to a single string.
//    public String serialize(Node root) {
//        if (root == null) return "";
//        return preOrder(root) + "#" + postOrder(root);
//    }
//
//    private String preOrder(Node root) {
//        if (root == null) return "";
//        StringBuilder sb = new StringBuilder();
//        // pre-order
//        sb.append(root.val).append(",");
//        if (root.children != null) {
//            for (Node child : root.children) {
//                sb.append(preOrder(child));
//            }
//        }
//        return sb.toString();
//    }
//
//    private String postOrder(Node root) {
//        if (root == null) return "";
//        StringBuilder sb = new StringBuilder();
//        // post-order
//        if (root.children != null) {
//            for (Node child : root.children) {
//                sb.append(postOrder(child));
//            }
//        }
//        sb.append(root.val).append(",");
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public Node deserialize(String data) {
//        if (data == null || data.length() <= 1) return null;
//        String[] sequences = data.split("#");
//
//        String[] pre = sequences[0].split(",");
//        String[] post = sequences[1].split(",");
//        int[] preIndex = new int[] {0};
//        int[] postIndex = new int[] {0};
//        return construct(pre, post, preIndex, postIndex);
//    }
//
//    private Node construct(String[] pre, String[] post, int[] preIndex, int[] postIndex) {
//        Node root = new Node(Integer.parseInt(pre[preIndex[0]]), new ArrayList<>());
////        root.val = Integer.parseInt(pre[preIndex]);
////        root.children = new ArrayList<>();
//        preIndex[0]++;
//        while(Integer.parseInt(post[postIndex[0]]) != (root.val)) {
//            root.children.add(construct(pre, post, preIndex, postIndex));
//        }
//        postIndex[0]++;
//        return root;
//    }
//
//    public static void main(String[] args) {
//        Node node1 = new Node(1, new ArrayList<>());
//        Node node2 = new Node(2, new ArrayList<>());
//        Node node3 = new Node(3, new ArrayList<>());
//        Node node4 = new Node(4, new ArrayList<>());
//        Node node5 = new Node(5, new ArrayList<>());
//        Node node6 = new Node(6, new ArrayList<>());
//
//
//        node1.children.add(node2);
//        node1.children.add(node3);
//        node1.children.add(node4);
//        node3.children.add(node5);
//        node3.children.add(node6);
//        SerializeAndDeserializeNaryTree ins = new SerializeAndDeserializeNaryTree();
//
////        System.out.println(ins.serialize(node1));
//        String sequence = ins.serialize(node1);
//
//        System.out.println(ins.deserialize(sequence));
//    }
//}

public class SerializeAndDeserializeNaryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list=new LinkedList<>();
        serializeHelper(root,list);
        return String.join(",",list);
    }

    private void serializeHelper(Node root, List<String> list){
        if(root==null){
            return;
        } else {
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for(Node child : root.children){
                serializeHelper(child,list);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())
            return null;

        String[] ss=data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(ss));
        return deserializeHelper(q);
    }

    private Node deserializeHelper(Queue<String> q){
        Node root=new Node();
        root.val=Integer.parseInt(q.poll());
        int size=Integer.parseInt(q.poll());
        root.children= new ArrayList<>(size);
        for(int i = 0;i < size; i++){
            root.children.add(deserializeHelper(q));
        }
        return root;
    }
}