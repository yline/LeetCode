import unittest


class Solution:
    # List[str]
    def readBinaryWatch(self, num: int) -> list:
        pass


class SolutionA(Solution):

    def readBinaryWatch(self, num: int) -> list:
        if num >= 9:
            return []

        result = []
        for i in range(num + 1):
            hours = self.get_hour(i)
            minutes = self.get_min(num - i)

            for hour in hours:
                for minute in minutes:
                    result.append(hour + ':' + minute)
            pass

        return result

    def get_hour(self, size: int) -> list:
        if size == 0:
            return ['0']

        if size == 1:
            return ['1', '2', '4', '8']

        if size == 2:
            return ['3', '5', '9', '6', '10']

        if size == 3:
            return ['7', '11']

        # 不合法
        return []

    def get_min(self, size: int):
        if size == 0:  # 1
            return ['00']

        if size == 1:  # 6
            return ['01', '02', '04', '08', '16', '32']

        if size == 2:  # 15
            return ['03', '05', '09', '17', '33',
                    '06', '10', '18', '34',
                    '12', '20', '36',
                    '24', '40',
                    '48']

        if size == 3:  # 19
            return ['07', '11', '19', '35',
                    '13', '21', '37',
                    '25', '41',
                    '49',
                    '14', '22', '38',
                    '26', '42',
                    '28', '44',
                    '52',
                    '56', '50']

        if size == 4:  # 14
            return ['58', '54', '46', '30',
                    '57', '53', '45', '29',
                    '51', '43', '27',
                    '39', '23',
                    '15']

        if size == 5:  # 4
            return ['59', '55', '47', '31']

        # None
        return []


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
        print(solution.readBinaryWatch(1))
        pass


"""

A binary watch has 4 LEDs on the top which represent the hours (0-11), 
and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25". # 这个图，看不到，只能从案例中推断

Given a non-negative integer n which represents 
the number of LEDs that are currently on, 
return all possible times the watch could represent.

2^4 > 12.
2^6 > 60.
因此，应该是一个位数，导致结果的不同

Example:
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

Note:
The order of output does not matter.

The hour must not contain a leading zero, 
for example "01:00" is not valid, it should be "1:00".

The minute must be consist of two digits 
and may contain a leading zero, 
for example "10:2" is not valid, it should be "10:02".

@author: yline
@time 2020/5/5 00:15
"""
