import unittest


class ListNode:
    """
    数据结构使用者：160、
    """

    def __init__(self, x):
        self.val = x
        self.next = None


def build_list_node(*array) -> ListNode:
    """
    创建一个链表
    :param array: 数据内容
    :return: 链表，返回头部
    """
    result = ListNode(-1)

    head = result
    for value in array:
        temp = ListNode(value)
        head.next = temp
        head = head.next
    return result.next


def print_list_node(node: ListNode):
    """
    打印一个链表
    :param node: 链表的头节点
    """
    data_list = list()

    temp = node
    while temp is not None:
        data_list.append(temp.val)
        temp = temp.next

    print(data_list)


def get_list_node_length(node: ListNode) -> int:
    if node is None:
        return 0
    count = 0
    temp = node
    while temp is not None:
        temp = temp.next
        count += 1
    return count


class ListNodeUtilsTest(unittest.TestCase):
    def test_utils(self):
        node_a = build_list_node(1, 2, 3, 4, 5, 6, 7)
        print_list_node(node_a)
        self.assertEqual(7, get_list_node_length(node_a))
