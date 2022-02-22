import unittest


class Solution:
    def __init__(self, capacity: int):
        pass

    def push(self, val: int) -> None:
        pass

    def pop(self) -> int:
        pass

    def popAtStack(self, index: int) -> int:
        pass


class SolutionA(Solution):

    def __init__(self, capacity: int):
        super().__init__(capacity)
        self.capacity = capacity
        self.data_list = []  # 列表中，内容
        self.rest_list = []  # 记录列表，有空余的位置

    def push(self, val: int) -> None:
        # 没有空余位置了，则创造一个
        if not self.rest_list:
            self.rest_list.append(self.data_list.__len__())
            self.data_list.append([])

        # 获取到最左边的空余位置，并填充数据
        index = self.rest_list[0]
        self.data_list[index].append(val)

        # 填充完成，需要判断位置是否填满，若填满，则移除
        if self.data_list[index].__len__() == self.capacity:
            self.rest_list.pop(0)

    def pop(self) -> int:
        """
        若最后一个移除之后，内容为空，还是要移除列表的
        :return:
        """
        # 检测到，右边开始，有内容的index
        index = self.data_list.__len__() - 1
        while index >= 0:
            # 如果有内容，则退出循环
            if self.data_list[index].__len__() != 0:
                break
            index = index - 1
            # 没有内容，则要移除最后一个列表
            self.data_list.pop()
            # 空余位置，最后一个也要删掉
            self.rest_list.pop()

        # 没有位置
        if index == -1:
            return -1

        # 空闲列表为空，或者，最后一个和index不同，则添加index
        if not self.rest_list or index != self.rest_list[-1]:
            self.rest_list.append(index)

        return self.data_list[index].pop()

    def popAtStack(self, index: int) -> int:
        # 越界
        if index < 0 or index >= self.data_list.__len__():
            return -1
        # 没有值
        if self.data_list[index].__len__() == 0:
            return -1

        result = self.data_list[index].pop()

        # 对空闲列表处理，若存在在列表中，则不管；若不存在，则插入[可以采取二分法]
        exist_index = index_of(index, self.rest_list)
        # 已经有值，则不村里
        if exist_index != -1:
            return result

        lower_index = lower(index, self.rest_list)
        if lower_index == -1:
            self.rest_list.insert(0, index)
        else:
            self.rest_list.insert(lower_index + 1, index)

        return result


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

    def test_solution_b(self):
        data = [1, 2, 3]
        print(data.pop())

        data.append(3)
        print(data)

        print(data.pop(0))
        print(data)
        pass

    def test_solution_e(self):
        solution = SolutionA(2)

        solution.push(472)  # [[472]]
        solution.push(106)  # [[472, 106]]
        solution.push(497)  # [[472, 106],[497]]
        solution.push(498)  # [[472, 106],[497,498]]
        solution.push(73)  # [[472, 106],[497,498], [73]]

        solution.push(115)  # [[472, 106],[497,498], [73, 115]]
        solution.push(437)  # [[472, 106],[497,498], [73, 115], [437]]
        solution.push(461)  # [[472, 106],[497,498], [73, 115], [437, 461]]

        self.assertEqual(461, solution.popAtStack(3))  # [[472, 106],[497,498], [73, 115], [437]]
        self.assertEqual(437, solution.popAtStack(3))  # [[472, 106],[497,498], [73, 115]]]

        self.assertEqual(498, solution.popAtStack(1))  # [[472, 106],[497], [73, 115]]]
        self.assertEqual(-1, solution.popAtStack(3))  # [[472, 106],[497], [73, 115]]]
        self.assertEqual(106, solution.popAtStack(0))  # [[472],[497], [73, 115]]]

        self.assertEqual(115, solution.popAtStack(2))  # [[472],[497], [73]]]
        self.assertEqual(73, solution.popAtStack(2))  # [[472],[497]]]
        self.assertEqual(497, solution.popAtStack(1))  # [[472]]
        self.assertEqual(-1, solution.popAtStack(1))  # [[472]]
        self.assertEqual(-1, solution.popAtStack(3))  # [[472]]

        solution.push(197)  # [[472, 197]]
        solution.push(239)  # [[472, 197], [239]]
        solution.push(129)  # [[472, 197], [239, 129]]
        solution.push(449)  # [[472, 197], [239, 129], [449]]
        solution.push(460)  # [[472, 197], [239, 129], [449, 460]]
        solution.push(240)  # [[472, 197], [239, 129], [449, 460], [240]]
        solution.push(386)  # [[472, 197], [239, 129], [449, 460], [240, 386]]
        solution.push(343)  # [[472, 197], [239, 129], [449, 460], [240, 386], [343]]

        self.assertEqual(343, solution.pop())  # [[472, 197], [239, 129], [449, 460], [240, 386]]
        self.assertEqual(386, solution.pop())
        self.assertEqual(240, solution.pop())
        self.assertEqual(460, solution.pop())
        self.assertEqual(449, solution.pop())

        self.assertEqual(129, solution.pop())
        self.assertEqual(239, solution.pop())
        self.assertEqual(197, solution.pop())
        self.assertEqual(472, solution.pop())
        self.assertEqual(-1, solution.pop())
        pass

    def test_solution_d(self):
        solution = SolutionA(1)

        solution.push(1)
        solution.push(2)

        self.assertEqual(2, solution.popAtStack(1))
        self.assertEqual(1, solution.pop())

        solution.push(1)
        solution.push(2)
        self.assertEqual(2, solution.pop())
        self.assertEqual(1, solution.pop())
        pass

    def test_solution_c(self):
        solution = SolutionA(1)

        solution.push(1)
        solution.push(2)
        solution.push(3)
        self.assertEqual(2, solution.popAtStack(1))
        self.assertEqual(3, solution.pop())
        self.assertEqual(1, solution.pop())

    def test_solution_a(self):
        solution = SolutionA(2)

        # 实现具体的校验内容
        solution.push(1)
        solution.push(2)
        solution.push(3)
        solution.push(4)
        solution.push(5)
        #                    // The stacks are now:  2  4
        #                                            1  3  5
        #                                            ﹈ ﹈ ﹈

        self.assertEqual(2, solution.popAtStack(0))
        # D.popAtStack(0);   // Returns 2.  The stacks are now:     4
        #                                                        1  3  5
        #                                                        ﹈ ﹈ ﹈

        solution.push(20)
        # D.push(20);        // The stacks are now: 20  4
        #                                            1  3  5
        #                                            ﹈ ﹈ ﹈

        solution.push(21)
        # D.push(21);        // The stacks are now: 20  4 21
        #                                            1  3  5
        #                                            ﹈ ﹈ ﹈

        self.assertEqual(20, solution.popAtStack(0))
        # D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
        #                                                         1  3  5
        #                                                         ﹈ ﹈ ﹈

        self.assertEqual(21, solution.popAtStack(2))
        # D.popAtStack(2);   // Returns 21.  The stacks are now:     4
        #                                                         1  3  5
        #                                                         ﹈ ﹈ ﹈

        self.assertEqual(5, solution.pop())
        # D.pop()            // Returns 5.  The stacks are now:      4
        #                                                         1  3
        #                                                         ﹈ ﹈

        self.assertEqual(4, solution.pop())
        # D.pop()            // Returns 4.  The stacks are now:   1  3
        #                                                         ﹈ ﹈

        self.assertEqual(3, solution.pop())
        # D.pop()            // Returns 3.  The stacks are now:   1
        #                                                         ﹈

        self.assertEqual(1, solution.pop())
        # D.pop()            // Returns 1.  There are no stacks.

        self.assertEqual(-1, solution.pop())
        # D.pop()            // Returns -1.  There are still no stacks.
        pass


"""
You have an infinite「无限大」 number of stacks arranged in a row and 
numbered (left to right) from 0, 
each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:
1，DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
2，void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
3，int pop() returns the value at the top of the rightmost non-empty stack and 
removes it from that stack, and returns -1 if all stacks are empty.
4，int popAtStack(int index) returns the value at the top of the stack with the given index and 
removes it from that stack, and returns -1 if the stack with that given index is empty.

Example:
Input: 
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output: 
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation: 
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
                                                       1  3  5
                                                       ﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
                                                        1  3  5
                                                        ﹈ ﹈ ﹈ 
D.pop()            // Returns 5.  The stacks are now:      4
                                                        1  3 
                                                        ﹈ ﹈  
D.pop()            // Returns 4.  The stacks are now:   1  3 
                                                        ﹈ ﹈   
D.pop()            // Returns 3.  The stacks are now:   1 
                                                        ﹈   
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.
 

Constraints:
1 <= capacity <= 20000
1 <= val <= 20000
0 <= index <= 100000
At most 200000 calls will be made to push, pop, and popAtStack.

@author: yline
@time 2020/3/16 12:00
"""
