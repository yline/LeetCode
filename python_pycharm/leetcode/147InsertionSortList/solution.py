import unittest

import list_node
from list_node import ListNode


class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        pass

    pass


class SolutionA(Solution):

    def insertionSortList(self, head: ListNode) -> ListNode:
        # 不用排序
        if head is None or head.next is None:
            return head

        result = ListNode(-1)
        result.next = head

        _right = head
        while _right.next is not None:
            _left = result.next
            _value = _right.next  # 加入的值

            # 大于，最大的值，直接度过
            if _right.val <= _value.val:
                _right = _value
                continue

            # 寻找，temp.next > _value
            temp = result
            while temp.next.val <= _value.val:
                temp = temp.next
                pass

            # 插入值
            _right.next = _value.next

            _value.next = temp.next
            temp.next = _value

        return result.next


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        root_a = list_node.build_list_node(6, 5, 3, 1, 8, 7, 2, 4)
        result_a = solution.insertionSortList(root_a)
        list_node.print_list_node(result_a)

        root_b = list_node.build_list_node(4, 2, 1, 3)
        result_b = solution.insertionSortList(root_b)
        list_node.print_list_node(result_b)

        # 实现具体的校验内容
        pass
