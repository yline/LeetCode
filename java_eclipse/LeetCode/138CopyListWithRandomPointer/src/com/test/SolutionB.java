package com.test;

import java.util.HashMap;
import java.util.Map;

import com.test.base.Node;
import com.test.base.Solution;

public class SolutionB implements Solution
{
    @Override
    public Node copyRandomList(Node head)
    {
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;
        while (ptr != null)
        {
            map.put(ptr, new Node(ptr.val, null, null));
            ptr = ptr.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet())
        {
            Node currNewNode = entry.getValue();
            Node currOldNode = entry.getKey();
            currNewNode.next = map.get(currOldNode.next);
            currNewNode.random = map.get(currOldNode.random);
        }
        return map.get(head);
    }
}
