"""

Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key
if the key exists in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

@author: yline
@time 2020/1/9 08:57
"""
import queue
import unittest
from collections import OrderedDict


class ValueNode:
    def __init__(self, key, value) -> None:
        super().__init__()

        self.pre = None  # 前一个节点
        self.next = None  # 后一个节点
        self.key = key  # key
        self.val = value  # value


class Solution:
    def __init__(self, capacity: int):
        pass

    def get(self, key: int) -> int:
        pass

    def put(self, key: int, value: int) -> None:
        pass


class SolutionA(Solution):
    def __init__(self, capacity: int):
        super().__init__(capacity)
        self.map = dict()
        self.capacity = capacity

        self.left = None  # 左边节点，首，最新
        self.right = None  # 右边节点，尾，最旧

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1

        value_node = self.map[key]
        self.__update_order(value_node)  # 将目标节点，移动到左边第一个
        return value_node.val

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            value_node = self.map[key]
            value_node.val = value  # 更新值
            self.__update_order(value_node)  # 将目标节点，移动到左边第一个
            return

        # 存入值
        value_node = ValueNode(key, value)
        self.map[key] = value_node

        # 空的情况
        if self.left is None:
            self.left = value_node
            self.right = value_node
            return

        # 其他情况
        self.left.pre = value_node
        value_node.next = self.left
        self.left = value_node

        # 溢出处理
        if self.map.__len__() > self.capacity:
            last_node = self.right  # 获取溢出数据
            self.right = last_node.pre
            self.right.next = None  # 清空链表
            del self.map[last_node.key]
        pass

    def __update_order(self, value_node: ValueNode):
        _pre = value_node.pre
        if _pre is None:  # 已经是最左边了
            return

        _next = value_node.next

        # 删除当前节点
        _pre.next = _next
        value_node.pre = None

        value_node.next = None
        if _next is not None:
            _next.pre = _pre
        else:
            self.right = _pre

        # 充当首节点
        value_node.next = self.left
        self.left.pre = value_node

        # 首节点移动
        self.left = value_node
        pass


class SolutionB(OrderedDict, Solution):
    def __init__(self, capacity: int):
        super().__init__()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]

    def put(self, key: int, value: int) -> None:
        if key in self:
            self.move_to_end(key)
        else:
            if len(self) == self.capacity:
                self.popitem(last=False)
        self[key] = value


# OrderedDict:'Dictionary that remembers insertion order'
# OrderedDict.move_to_end:
# Move an existing element to the end (or beginning if last==False).
# Raises KeyError if the element does not exist.
# When last=True, acts like a fast version of self[key]=self.pop(key).

# OrderedDict.popitem:
# Remove and return a (key, value) pair from the dictionary.
# Pairs are returned in LIFO order if last is true or FIFO order if false.


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA(2)
        self.__assert_equal()

        self.solution = SolutionA(1)
        self.__assert_equal_2()
        pass

    def test_solution_b(self):
        self.solution = SolutionB(2)
        self.__assert_equal()

        self.solution = SolutionB(1)
        self.__assert_equal_2()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        solution.put(1, 1)
        solution.put(2, 2)
        self.assertEqual(1, solution.get(1))

        # 溢出 2
        solution.put(3, 3)
        self.assertEqual(-1, solution.get(2))

        # 溢出 1
        solution.put(4, 4)
        self.assertEqual(-1, solution.get(1))

        self.assertEqual(3, solution.get(3))
        self.assertEqual(4, solution.get(4))
        pass

    def __assert_equal_2(self):
        solution = self.solution

        # 实现具体的校验内容
        solution.put(2, 1)
        self.assertEqual(1, solution.get(2))

        # 溢出 2
        solution.put(3, 2)
        self.assertEqual(-1, solution.get(2))

        # 溢出 1
        self.assertEqual(2, solution.get(3))
        pass

