"""
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4

Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

实现一个并归排序

@author: yline
@time 2020/1/7 20:12
"""

import unittest

import list_node
from list_node import ListNode


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        pass


class SolutionB(Solution):
    def sortList(self, head: ListNode) -> ListNode:
        """
        这个方案感觉不太对，貌似申请了一个列表的大小。容器大小
        不过，作为平时的解决方案，这个是可以的
        """
        # constant space rules out merge sort

        # hacky solv: convert to list, randomized quicksort, convert that to linked list
        tmp = head
        arr = []
        while tmp:
            arr.append(tmp.val)
            tmp = tmp.next
        arr = sorted(arr)

        tmp = head
        i = 0
        while tmp:
            tmp.val = arr[i]
            i += 1
            tmp = tmp.next
        return head


class SolutionA(Solution):
    def sortList(self, head: ListNode) -> ListNode:
        # 长度为1或0的情况，直接排除
        if head is None or head.next is None:
            return head

        result = ListNode(-1)
        result.next = head

        # 获取长度
        length = get_list_node_length(head)

        # log(n) 的效率，遍历
        size = 1
        while size < length:
            merge_link(result, size)
            size = size << 1
        return result.next


def merge_link(left: ListNode, size: int):
    # 已经为空，直接返回
    if left is None:
        return

    # 第一条链表已经结束
    first = left.next
    if first is None:
        return

    # 第二条链表头，还没移动到，就已经结束了
    second = move_to(first, size)
    if second is None:
        return

    # 合并两条链表，同时返回链表的结尾
    next_left = merge_by_size(left, first, second, size)
    merge_link(next_left, size)


def move_to(head: ListNode, size: int) -> ListNode:
    temp = head
    while size > 0 and temp is not None:
        temp = temp.next
        size -= 1
    return temp


def merge_by_size(left: ListNode, first: ListNode, second: ListNode, size: int) -> ListNode:
    """
    对两个链表进行排序
    原始顺序为：left -> first -> second -> right
    :param left:    first前一个链表，用来存储排序后内容
    :param first:   链表头，长度为length，则满足：length = 2^n
    :param second:  链表头，长度为length，则满足：2^(n-1) < length <= 2^n
    :param size:    first的长度
    :return: 返回两个链表融合后的尾部
    """
    first_size = size
    second_size = size

    end = move_to(second, second_size)  # 移动到最后

    head = left
    while (first_size != 0 or second_size != 0) and head is not None:
        # 第一条已经结束
        if first_size == 0:
            head.next = second
            head = head.next
            if second is not None:
                second = second.next
            second_size -= 1
            continue

        # 第二条已经结束
        if second_size == 0 or second is None:
            head.next = first
            first = first.next
            head = head.next
            first_size -= 1
            continue

        # 两条链表，依次取数据
        if first.val < second.val:
            head.next = first
            first = first.next
            first_size -= 1
        else:
            head.next = second
            second = second.next
            second_size -= 1
        head = head.next
        pass

    if head is not None:
        head.next = end
    return head


def get_list_node_length(node: ListNode) -> int:
    if node is None:
        return 0
    count = 0
    temp = node
    while temp is not None:
        temp = temp.next
        count += 1
    return count


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
        node_a = list_node.build_list_node(4, 2, 1, 3)
        result_a = solution.sortList(node_a)
        list_node.print_list_node(result_a)

        node_b = list_node.build_list_node(-1, 5, 3, 4, 0)
        result_b = solution.sortList(node_b)
        list_node.print_list_node(result_b)

        node_c = list_node.build_list_node(-1, -2, -3, -4, 0, 6, 5, 3, 8, 9, 13, 2)
        result_c = solution.sortList(node_c)
        list_node.print_list_node(result_c)
        pass


