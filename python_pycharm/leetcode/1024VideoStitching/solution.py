import unittest


class Solution:
    def videoStitching(self, clips: list, T: int) -> int:
        pass


class SolutionA(Solution):
    # List[List[int]
    def videoStitching(self, clips: list, T: int) -> int:
        # 排序
        clips.sort(key=lambda x: x[0])

        step = 0
        right = 0
        index = 0
        while True:
            if right >= T:
                return step

            _max, index = self.find_next(clips, right, index)
            # 说明没有被赋值过
            if _max == -1:
                return -1
            step = step + 1
            right = _max

    def find_next(self, clips: list, right: int, index: int):
        _max = -1
        for i in range(index, clips.__len__()):
            if clips[i][0] > right:
                break
            index = i + 1
            _max = max(_max, clips[i][1])
        return _max, index


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
        self.assertEqual(3, solution.videoStitching([[0, 2], [4, 6], [8, 10], [1, 9], [1, 5], [5, 9]], 10))
        self.assertEqual(-1, solution.videoStitching([[0, 1], [1, 2]], 5))
        self.assertEqual(3, solution.videoStitching(
            [[0, 1], [6, 8], [0, 2], [5, 6], [0, 4], [0, 3], [6, 7], [1, 3], [4, 7], [1, 4], [2, 5], [2, 6], [3, 4],
             [4, 5], [5, 7], [6, 9]], 9))
        self.assertEqual(2, solution.videoStitching([[0, 4], [2, 8]], 5))
        pass


"""
You are given a series of video clips from a sporting event that lasted T seconds.  
These video clips can be overlapping with each other and have varied lengths.

Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1]. 
 We can cut these clips into segments freely: for example, 
 a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

Return the minimum number of clips needed so that we can cut the clips into segments 
that cover the entire sporting event ([0, T]). 

If the task is impossible, return -1.

 

Example 1:
Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
Output: 3
Explanation: 
We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
Then, we can reconstruct the sporting event as follows:
We cut [1,9] into segments [1,2] + [2,8] + [8,9].
Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].

Example 2:
Input: clips = [[0,1],[1,2]], T = 5
Output: -1
Explanation: 
We can't cover [0,5] with only [0,1] and [0,2].

Example 3:
Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
Output: 3
Explanation: 
We can take clips [0,4], [4,7], and [6,9].

Example 4:
Input: clips = [[0,4],[2,8]], T = 5
Output: 2
Explanation: 
Notice you can have extra video after the event ends.
 

Note:
1 <= clips.length <= 100
0 <= clips[i][0], clips[i][1] <= 100
0 <= T <= 100

@author: yline
@time 2020/3/19 12:00
"""
