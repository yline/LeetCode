import unittest


class Solution:
    # List[int]
    def mincostToHireWorkers(self, quality: list, wage: list, K: int) -> float:
        pass


class SolutionA(Solution):
    """
    执行超时了，应该是每次移除位置 + 计算求和的原因
    """

    def mincostToHireWorkers(self, quality: list, wage: list, K: int) -> float:
        source_list = [[0, 0] for i in range(wage.__len__())]
        for i in range(wage.__len__()):
            source_list[i] = [wage[i], quality[i]]

        # 对熵进行排序, 升序排序
        source_list.sort(key=lambda node: node[0] / node[1])

        # 计算连续k个值
        dynamic_list = [0 for i in range(wage.__len__())]
        for i in range(wage.__len__()):
            dynamic_list[i] = quality[i]
        dynamic_list.sort()

        index = wage.__len__() - 1

        obj_quality = source_list[index][1]
        dynamic_list.remove(obj_quality)
        _result = (source_list[index][0] / source_list[index][1]) * (obj_quality + self.sum_by_k(dynamic_list, K))

        index = index - 1
        while index >= K - 1:
            obj_quality = source_list[index][1]
            dynamic_list.remove(obj_quality)
            _result = min(_result, (source_list[index][0] / source_list[index][1])
                          * (obj_quality + self.sum_by_k(dynamic_list, K)))

            index = index - 1

        return _result

    def sum_by_k(self, dynamic_list: list, k):
        _sum = 0
        for i in range(k - 1):
            _sum += dynamic_list[i]
        return _sum


class SolutionB(Solution):
    """
    基本思路和 SolutionA相同，只是每次计算求和，用了之前的值
    """

    def mincostToHireWorkers(self, quality: list, wage: list, K: int) -> float:
        if K == 1:
            return min(wage)

        source_list = [[0, 0] for i in range(wage.__len__())]
        for i in range(wage.__len__()):
            source_list[i] = [wage[i], quality[i]]

        # 对熵进行排序, 升序排序
        source_list.sort(key=lambda node: node[0] / node[1])

        # 计算连续k个值
        dynamic_list = [0 for i in range(wage.__len__())]
        for i in range(wage.__len__()):
            dynamic_list[i] = quality[i]
        dynamic_list.sort()

        _removed = [False for i in range(wage.__len__())]
        _sum = self.sum_by_k(dynamic_list, K)  # k-1的值
        _right_index = K - 2

        index = wage.__len__() - 1

        obj_quality = source_list[index][1]
        obj_index = self.find_index(dynamic_list, _removed, obj_quality)

        if obj_index > _right_index:
            _removed[obj_index] = True
        else:
            _removed[obj_index] = True
            _right_index = self.find_next_right(_removed, _right_index + 1)
            _sum = _sum + (dynamic_list[_right_index] - obj_quality)

        _result = (source_list[index][0] / source_list[index][1]) * (obj_quality + _sum)

        index = index - 1
        while index >= K - 1:
            obj_quality = source_list[index][1]
            obj_index = self.find_index(dynamic_list, _removed, obj_quality)

            if obj_index > _right_index:
                _removed[obj_index] = True
            else:
                _removed[obj_index] = True
                _right_index = self.find_next_right(_removed, _right_index + 1)
                _sum = _sum + (dynamic_list[_right_index] - obj_quality)

            _result = min(_result, (source_list[index][0] / source_list[index][1]) * (obj_quality + _sum))

            index = index - 1

        return _result

    def sum_by_k(self, dynamic_list: list, k):
        _sum = 0
        for i in range(k - 1):
            _sum += dynamic_list[i]
        return _sum

    def find_next_right(self, _remove: list, start) -> int:
        for i in range(start, _remove.__len__()):
            if not _remove[i]:
                return i
        return -1

    # 利用二分法，找到下标，还有防止重复
    def find_index(self, dynamic_list: list, removed_list, val):
        left = 0
        right = dynamic_list.__len__() - 1
        while left <= right:
            mid = (left + right) >> 1
            if val > dynamic_list[mid]:
                left = mid + 1
            elif val < dynamic_list[mid]:
                right = mid - 1
            else:
                # 还有可能是相等，然后就需要找到任意一个没有被移除过的
                if not removed_list[mid]:
                    return mid
                else:
                    temp_mid = mid + 1
                    while temp_mid < dynamic_list.__len__() and dynamic_list[temp_mid] == val:
                        if not removed_list[temp_mid]:
                            return temp_mid
                        temp_mid = temp_mid + 1

                    temp_mid = mid - 1
                    while temp_mid >= 0 and dynamic_list[temp_mid] == val:
                        if not removed_list[temp_mid]:
                            return temp_mid
                        temp_mid = temp_mid - 1
        return -1


from heapq import *


class SolutionC(Solution):
    """
    利用了堆，python数据结构不熟悉的锅
    """
    def mincostToHireWorkers(self, quality: list, wage: list, K: int) -> float:
        n = len(quality)
        worker = sorted(zip(quality, wage), key=lambda x: x[1] / x[0])
        heap, ratio, q = [], 0, 0
        for i in range(K):
            heappush(heap, -worker[i][0])
            q += worker[i][0]
            ratio = worker[i][1] / worker[i][0]
        ans = q * ratio

        for i in range(K, n):
            heappush(heap, -worker[i][0])
            q += worker[i][0]
            ratio = worker[i][1] / worker[i][0]

            tmp = -heappop(heap)
            q -= tmp
            ans = min(ans, q * ratio)
        return ans


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def test_solution_b(self):
        self.solution = SolutionB()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        # 实现具体的校验内容
        # Input: quality = [10,20,5], wage = [70,50,30], K = 2
        # Output: 105.00000
        quality_a = [10, 20, 5]
        wage_a = [70, 50, 30]
        K_a = 2
        self.assertEqual(105, solution.mincostToHireWorkers(quality_a, wage_a, K_a))

        # Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
        # Output: 30.66667
        quality_b = [3, 1, 10, 10, 1]
        wage_b = [4, 8, 2, 2, 7]
        K_b = 3
        self.assertAlmostEqual(30.6666, solution.mincostToHireWorkers(quality_b, wage_b, K_b), delta=0.001)

        # [25,68,35,62,52,57,35,83,40,51]
        # [147,97,251,129,438,443,120,366,362,343]
        # 6
        quality_c = [25, 68, 35, 62, 52, 57, 35, 83, 40, 51]
        wage_c = [147, 97, 251, 129, 438, 443, 120, 366, 362, 343]
        k_c = 6
        self.assertAlmostEqual(1979.314285, solution.mincostToHireWorkers(quality_c, wage_c, k_c), delta=0.00001)
        pass


"""
There are N workers.  
The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  
When hiring a group of K workers, we must pay them according to the following rules:

1, Every worker in the paid group should be paid 
in the ratio[比率] of their quality compared to other workers in the paid group.
2，Every worker in the paid group must be paid at least their minimum wage expectation.

1，他们的工资比率，和，quality比率相同
2，他们工资的单量 大于 期待值

Return the least amount of money needed to form a paid group satisfying the above conditions.

Example 1:
Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.

==> 基础比率
10: 20: 5   --> 不能调整的
70: 50: 30  --> 可以调整的

==> 
min( 7*(10+5), 6*(20+5) ) 
min( 105, 150 )

Example 2:
Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 

3:  1: 10: 10: 1
4:  8: 2:  2:  7
1.3 8  0.2 0.2 7

==>
min( 8*(1+1+3), 7*(1+3+10), 1.3333*(3+10+10) )
min( 40, 98, 30.66666)

1，求的熵
2，对熵进行排序
3，排序取连续的k值
4，取最少的连续的情况

Note:
1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.

@author: yline
@time 2020/3/26 18:12
"""
