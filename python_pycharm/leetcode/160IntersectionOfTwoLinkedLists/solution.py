"""
Write a program to find the node at
which the intersection of two singly linked lists begins.

For example, the following two linked lists:
begin to intersect at node c1.

Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

node: 这里判断的是全等，而不是内容「val」的相等

@author: yline
@time 2019/12/30 08:38
"""
import unittest

import list_node
from list_node import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        pass


class SolutionA(Solution):
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None

        set_cache = set()
        temp = headA
        while temp is not None:
            set_cache.add(temp)
            temp = temp.next

        temp = headB
        while temp is not None:
            if temp in set_cache:
                return temp
            temp = temp.next

        return None


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        end_a = list_node.build_list_node(8, 4, 5)
        node_aa = list_node.build_list_node(4, 1)
        node_aa.next = end_a

        node_ab = list_node.build_list_node(5, 0, 1)
        node_ab.next = end_a
        self.assertEqual(8, solution.getIntersectionNode(node_aa, node_ab).val)

        end_b = list_node.build_list_node(2, 4)
        node_ba = list_node.build_list_node(0, 9, 1)
        node_ba.next = end_b

        node_bb = list_node.build_list_node(3, 2, 4)
        node_bb.next = end_b
        self.assertEqual(2, solution.getIntersectionNode(node_ba, node_bb).val)

        node_ca = list_node.build_list_node(2, 6, 4)
        node_cb = list_node.build_list_node(1, 5)
        self.assertEqual(None, solution.getIntersectionNode(node_ca, node_cb))
        pass
