import unittest


class Solution:
    # List[List[str]]
    def minPushBox(self, grid: list) -> int:
        pass


class State:
    """
    一个状态的决定因素：
    1，盒子的位置：行、列决定：key = 行 + 列*总行数
    2，人所能到达的位置：一共有左=1、右=2、上=4、下=8：key = bin(左 | 右 | 上 | 下)
    """

    def __init__(self, box_pos: int, player_pos: int, person_array: list, step: int) -> None:
        super().__init__()
        self.box_pos = box_pos
        self.player_pos = player_pos
        self.step = step
        self.person_array = person_array

    def __hash__(self) -> int:
        return self.box_pos

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, State):
            return False

        for i in range(4):
            if o.person_array[i] != self.person_array[i]:
                return False

        return o.box_pos == self.box_pos


class EmptyControl:
    """
    建立所有  . T S的空白链表，只要把所有点连接起来即可。双向的
    作用：
        1，判断人是否能达到某个点
        2，判断T的下一个可能的位置
    """

    def __init__(self, grid: list) -> None:
        super().__init__()

        # 保存原有的值
        self.grid = grid
        self.row_size = grid.__len__()
        self.column_size = grid[0].__len__()

        # 创建所有节点「box_pos - set{上、下、左、右}」
        self.node_map = dict()
        for row in range(self.row_size):
            for column in range(self.column_size):
                if '#' == grid[row][column]:
                    continue

                # 创建并添加node
                _key = row + column * self.row_size
                self.node_map[_key] = [-1, -1, -1, -1]

        # 遍历给所有key赋值
        for _key in self.node_map:
            row = _key % self.row_size
            column = _key // self.row_size
            self.__compute_border(row, column, _key)

        # 用来临时记录，哪些位置已经遍历过了
        self.temp_map = dict()
        self.temp_num = 0
        for key in self.node_map:
            self.temp_map[key] = False

    def init_temp_map(self, target_array):
        # 全部清空标记
        for key in self.temp_map:
            self.temp_map[key] = False

        # 需要尝试访问的目标
        self.temp_num = 0
        for i in range(target_array.__len__()):
            if target_array[i] != -1:
                self.temp_num = self.temp_num + 1

    def __compute_border(self, row: int, column: int, _key: int) -> list:
        _value = self.node_map[_key]  # 左、上、下、右

        # 左
        left_key = _key - self.row_size
        if column > 0 and left_key in self.node_map:
            _value[0] = left_key

        # 上
        top_key = _key - 1
        if row > 0 and top_key in self.node_map:
            _value[1] = top_key

        # 下
        bottom_key = _key + 1
        if row < self.row_size - 1 and bottom_key in self.node_map:
            _value[2] = bottom_key

        # 右
        right_key = _key + self.row_size
        if column < self.column_size - 1 and right_key in self.node_map:
            _value[3] = right_key
        return _value

    def get_start_key(self):
        """
        0 - target_key 目标位置
        1 - box_key 盒子开始的位置
        2 - player_key 人员开始的位置
        """
        size = 0
        result = [-1, -1, -1]
        for row in range(self.row_size):
            for column in range(self.column_size):
                ch = self.grid[row][column]
                if '#' == ch or '.' == ch:
                    continue

                # 赋值
                _key = row + column * self.row_size
                if 'T' == ch:
                    result[0] = _key
                    size = size + 1
                elif 'B' == ch:
                    result[1] = _key
                    size = size + 1
                else:  # 'S'
                    result[2] = _key
                    size = size + 1

                # 返回结果
                if size == 3:
                    return result
        return None

    def arrive_pos(self, box_pos: int, player_pos: int):
        """
        计算人能到达盒子边上的位置
        @:param box_pos 盒子的位置
        @:param player_box 人的起点位置
        :return: [True, True, True, True] - [左、上、下、右] 都能到达
        """
        target_array = self.node_map[box_pos]
        self.init_temp_map(target_array)

        self.temp_map[box_pos] = True  # 盒子的位置，不允许被访问

        result_array = [False, False, False, False]
        self.arrive_pos_dfs(target_array, result_array, player_pos)
        return result_array

    def arrive_pos_dfs(self, target_array, result_array, this_pos):
        # 不需要再次遍历
        if self.temp_map[this_pos]:
            return
        self.temp_map[this_pos] = True

        # 结束
        if self.temp_num == 0:
            return

        for i in range(target_array.__len__()):
            if target_array[i] == this_pos:
                result_array[i] = True
                self.temp_num = self.temp_num - 1

        next_post_array = self.node_map[this_pos]
        for next_post in next_post_array:
            if next_post != -1:
                self.arrive_pos_dfs(target_array, result_array, next_post)

    def get_state(self, box_pos: int, player_pos: int, step: int) -> State:
        """
        盒子位置、人员位置共同决定当前的状态；
        通过位置，计算得到State的结果
        """
        # [左、上、下、右]
        result_array = self.arrive_pos(box_pos, player_pos)

        return State(box_pos, player_pos, result_array, step)

    def push(self, last_state: State) -> list:
        """
        执行推的动作
        """
        box_pos = last_state.box_pos

        new_step = last_state.step + 1
        person_array = last_state.person_array

        # 获取到人能到达箱子周围的位置 [左、上、下、右]
        box_array = self.node_map[box_pos]

        result_array = []

        # 左 -> 右
        if person_array[0] and box_array[3] != -1:
            new_state = self.get_state(box_array[3], box_pos, new_step)
            result_array.append(new_state)

        # 上 -> 下
        if person_array[1] and box_array[2] != -1:
            new_state = self.get_state(box_array[2], box_pos, new_step)
            result_array.append(new_state)

        # 下 -> 上
        if person_array[2] and box_array[1] != -1:
            new_state = self.get_state(box_array[1], box_pos, new_step)
            result_array.append(new_state)

        # 右 -> 左
        if person_array[3] and box_array[0] != -1:
            new_state = self.get_state(box_array[0], box_pos, new_step)
            result_array.append(new_state)

        return result_array


class SolutionA(Solution):

    def minPushBox(self, grid: list) -> int:
        import queue

        empty_control = EmptyControl(grid)

        visited_set = set()
        target_pos, box_pos, player_pos = empty_control.get_start_key()
        now_state = empty_control.get_state(box_pos, player_pos, 0)

        # 开始bfs遍历
        task_queue = queue.Queue()
        task_queue.put(now_state)

        while not task_queue.empty():
            last_state = task_queue.get()
            visited_set.add(last_state)

            # 通过当前状态，找到下一个可能的状态
            possible_state_list = empty_control.push(last_state)

            # 把所有状态添加进去即可
            for state in possible_state_list:
                # 到达某个位置
                if state.box_pos == target_pos:
                    return state.step

                # 已经访问过的
                if state in visited_set:
                    continue

                task_queue.put(state)

        return -1


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
        grid_a = [["#", "#", "#", "#", "#", "#"],
                  ["#", "T", "#", "#", "#", "#"],
                  ["#", ".", ".", "B", ".", "#"],
                  ["#", ".", "#", "#", ".", "#"],
                  ["#", ".", ".", ".", "S", "#"],
                  ["#", "#", "#", "#", "#", "#"]]
        self.assertEqual(3, solution.minPushBox(grid_a))

        grid_b = [["#", "#", "#", "#", "#", "#"],
                  ["#", "T", "#", "#", "#", "#"],
                  ["#", ".", ".", "B", ".", "#"],
                  ["#", "#", "#", "#", ".", "#"],
                  ["#", ".", ".", ".", "S", "#"],
                  ["#", "#", "#", "#", "#", "#"]]
        self.assertEqual(-1, solution.minPushBox(grid_b))

        grid_c = [["#", "#", "#", "#", "#", "#"],
                  ["#", "T", ".", ".", "#", "#"],
                  ["#", ".", "#", "B", ".", "#"],
                  ["#", ".", ".", ".", ".", "#"],
                  ["#", ".", ".", ".", "S", "#"],
                  ["#", "#", "#", "#", "#", "#"]]
        self.assertEqual(5, solution.minPushBox(grid_c))

        grid_d = [["#", "#", "#", "#", "#", "#", "#"],
                  ["#", "S", "#", ".", "B", "T", "#"],
                  ["#", "#", "#", "#", "#", "#", "#"]]
        self.assertEqual(-1, solution.minPushBox(grid_d))

        grid_e = [["#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "#", "#", "#", "#"],
                  ["#", ".", "#", "#", "#", "#", ".", "#", "#", "#", "#", ".", "#", "#", "#", "."],
                  ["#", ".", ".", ".", ".", ".", ".", "#", "T", "#", ".", ".", "#", "#", "#", "."],
                  ["#", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", ".", "#", "#", "#", "."],
                  ["#", ".", ".", ".", ".", ".", "B", ".", ".", ".", ".", ".", "#", "#", "#", "."],
                  ["#", ".", "#", "#", "#", "#", "#", "#", "#", "#", "#", ".", "#", "#", "#", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."],
                  ["#", ".", ".", ".", ".", ".", ".", ".", "S", ".", ".", ".", ".", ".", ".", "."],
                  ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"]]
        self.assertEqual(-1, solution.minPushBox(grid_e))
        pass


"""
Storekeeper is a game in which the player pushes boxes around in a warehouse 
trying to get them to target locations.

The game is represented by a grid of size m x n, 
where each element is a wall, floor, or a box.

Your task is move the box 'B' to the target position 'T' under the following rules:

Player is represented by character 'S' and 
can move up, down, left, right in the grid if it is a floor (empy cell).

Floor is represented by character '.' that means free cell to walk.

Wall is represented by character '#' that means obstacle  (impossible to walk there). 

There is only one box 'B' and one target cell 'T' in the grid.

The box can be moved to an adjacent free cell by standing next to the box 
and then moving in the direction of the box. This is a push.

The player cannot walk through the box.

Return the minimum number of pushes to move the box to the target. 
If there is no way to reach the target, return -1.

Example 1:
Input: grid = [["#","#","#","#","#","#"],
               ["#","T","#","#","#","#"],
               ["#",".",".","B",".","#"],
               ["#",".","#","#",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: 3
Explanation: We return only the number of times the box is pushed.

Example 2:
Input: grid = [["#","#","#","#","#","#"],
               ["#","T","#","#","#","#"],
               ["#",".",".","B",".","#"],
               ["#","#","#","#",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: -1

Example 3:
Input: grid = [["#","#","#","#","#","#"],
               ["#","T",".",".","#","#"],
               ["#",".","#","B",".","#"],
               ["#",".",".",".",".","#"],
               ["#",".",".",".","S","#"],
               ["#","#","#","#","#","#"]]
Output: 5
Explanation:  push the box down, left, left, up and up.

Example 4:
Input: grid = [["#","#","#","#","#","#","#"],
               ["#","S","#",".","B","T","#"],
               ["#","#","#","#","#","#","#"]]
Output: -1

Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 20
1 <= n <= 20
grid contains only characters '.', '#',  'S' , 'T', or 'B'.
There is only one character 'S', 'B' and 'T' in the grid.

最小路径问题

结束条件：
往某个方向推动，只要达到即可结束

推送条件：
1，下一个位置为空白
2，下一个位置的相反方向上，人必须能过去到那个位置

优化：
1，若已经到达过某个节点，则pass；

人能到达哪个位置，没有什么特别好的办法。只能是动态规划式了

@author: yline
@time 2020/3/21 22:32
"""
