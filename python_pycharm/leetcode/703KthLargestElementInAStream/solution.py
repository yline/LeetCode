import unittest


class Solution:

    def __init__(self, k: int, nums: list):
        pass

    def add(self, val: int) -> int:
        pass


class SolutionA(Solution):

    def __init__(self, k: int, nums: list):
        super().__init__(k, nums)
        self.num_array = sorted(nums)
        self.k = k

    def add(self, val: int) -> int:
        # 二分法插入
        index = lower(val, self.num_array)
        self.num_array.insert(index + 1, val)
        return self.num_array[-self.k]


def index_of(val: int, array: list) -> int:
    """
    使用二分法，从列表中查找index；不存在，则返回-1
    """
    if not array:
        return -1

    left = 0
    right = array.__len__() - 1
    while left <= right:
        mid = (left + right) >> 1
        if val > array[mid]:
            left = mid + 1
        elif val < array[mid]:
            right = mid - 1
        else:
            return mid
    return -1


def lower(val: int, array: list) -> int:
    """
    找到最后一个比它小的值；若不存在，则返回-1
    """
    if not array:
        return -1

    left = 0
    right = array.__len__() - 1
    while left <= right:
        mid = (left + right) >> 1
        if val > array[mid]:
            if mid == array.__len__() - 1 or array[mid + 1] >= val:
                return mid
            left = mid + 1
        else:
            right = mid - 1
    return -1


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        solution = SolutionA(3, [4, 5, 8, 2])

        # 实现具体的校验内容
        self.assertEqual(4, solution.add(3))
        self.assertEqual(5, solution.add(5))
        self.assertEqual(5, solution.add(10))
        self.assertEqual(8, solution.add(9))
        self.assertEqual(8, solution.add(4))
        pass


"""
Design a class to find the kth largest element in a stream. 
Note that it is the kth largest element in the sorted order, 
not the kth distinct element.

Your KthLargest class will have a constructor 
which accepts an integer k and an integer array nums, 
which contains initial elements from the stream. 

For each call to the method KthLargest.add, 
return the element representing the kth largest element in the stream.

Example:
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.

@author: yline
@time 2020/3/19 00:57
"""
