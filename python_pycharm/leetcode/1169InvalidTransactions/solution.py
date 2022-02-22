import unittest


class Solution:
    # List[str]
    def invalidTransactions(self, transactions: list) -> list:
        pass


class SolutionA(Solution):

    def invalidTransactions(self, transactions: list) -> list:
        result = set()

        # 第一层过滤，超过1000，就过滤
        filter_list = []  # 保存分解过的内容
        name_map = dict()  # 保存，name - index的映射
        for i in range(transactions.__len__()):
            temp = transactions[i].split(',')
            temp[1] = int(temp[1])
            temp[2] = int(temp[2])

            if temp[2] > 1000:
                result.add(i)
            filter_list.append(temp)
            if temp[0] not in name_map:
                name_map[temp[0]] = [i]
            else:
                name_map[temp[0]].append(i)

        # 排序
        for key in name_map:
            val_list = name_map[key]
            val_list.sort(key=lambda x: filter_list[x][1])

            _last_queue = list()  # 这里要自己注意移除方向
            _last_queue.append(val_list[0])  # 右侧添加进去
            for j in range(1, val_list.__len__()):
                _this = val_list[j]

                # 遍历对比 _last 和 _this
                temp_list = list(_last_queue)
                for _last in temp_list:
                    if filter_list[_this][1] - filter_list[_last][1] <= 60:
                        if filter_list[_this][3] != filter_list[_last][3]:
                            result.add(_last)
                            result.add(_this)
                    else:
                        _last_queue.pop(0)  # 左侧移除
                _last_queue.append(_this)  # 右侧添加

        # 相同的名字，在60分钟内，出现在不同的城市。则错误
        return_list = []
        for index in result:
            return_list.append(transactions[index])

        return return_list


class SolutionB(Solution):
    def invalidTransactions(self, transactions: list) -> list:
        if len(transactions) is 0:
            return []

        invalid_transactions = []

        for i in range(len(transactions)):
            first_parts = transactions[i].split(',')

            if int(first_parts[2]) > 1000:
                invalid_transactions.append(transactions[i])

            for j in range(len(transactions)):
                second_parts = transactions[j].split(',')
                if i is not j:
                    if first_parts[0] == second_parts[0] and abs(int(first_parts[1]) - int(second_parts[1])) <= 60 and \
                            first_parts[3] != second_parts[3]:
                        invalid_transactions.append(transactions[i])
                        invalid_transactions.append(transactions[j])

        return list(set(invalid_transactions))


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
        # Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
        # Output: ["alice,20,800,mtv","alice,50,100,beijing"]
        transactions_a = ["alice,20,800,mtv", "alice,50,100,beijing"]
        print(solution.invalidTransactions(transactions_a))

        # Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
        # Output: ["alice,50,1200,mtv"]
        transactions_b = ["alice,20,800,mtv", "alice,50,1200,mtv"]
        print(solution.invalidTransactions(transactions_b))

        # Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
        # Output: ["bob,50,1200,mtv"]
        transactions_c = ["alice,20,800,mtv", "bob,50,1200,mtv"]
        print(solution.invalidTransactions(transactions_c))

        transactions_d = ["xnova,261,1949,chicago", "bob,206,1284,chicago", "xnova,420,996,bangkok",
                          "chalicefy,704,1269,chicago", "iris,124,329,bangkok", "xnova,791,700,amsterdam",
                          "chalicefy,572,697,budapest", "chalicefy,231,310,chicago", "chalicefy,763,857,chicago",
                          "maybe,837,198,amsterdam", "lee,99,940,bangkok", "bob,132,1219,barcelona",
                          "lee,69,857,barcelona", "lee,607,275,budapest", "chalicefy,709,1171,amsterdam"]
        # ["xnova,261,1949,chicago","bob,206,1284,chicago","chalicefy,704,1269,chicago","chalicefy,763,857,chicago",
        # "lee,99,940,bangkok","bob,132,1219,barcelona","lee,69,857,barcelona","chalicefy,709,1171,amsterdam"]
        print(solution.invalidTransactions(transactions_d))

        transactions_e = [
            "bob,649,842,prague",
            "alex,175,1127,mexico",
            "iris,164,119,paris",
            "lee,991,1570,mexico",
            "lee,895,1876,taipei",
            "iris,716,754,moscow",
            "chalicefy,19,592,singapore",
            "chalicefy,820,71,newdelhi",
            "maybe,231,1790,paris",
            "lee,158,987,mexico",
            "chalicefy,415,22,montreal",
            "iris,803,691,milan",
            "xnova,786,804,guangzhou",
            "lee,734,1915,prague",
            "bob,836,1904,dubai",
            "iris,666,231,chicago",
            "iris,677,1451,milan",
            "maybe,860,517,toronto",
            "iris,344,1452,bangkok",
            "lee,664,463,frankfurt",
            "chalicefy,95,1222,montreal",
            "lee,293,1102,istanbul",
            "maybe,874,36,hongkong",
            "maybe,457,1802,montreal",
            "xnova,535,270,munich",
            "iris,39,264,istanbul",
            "chalicefy,548,363,barcelona",
            "lee,373,184,munich",
            "xnova,405,957,mexico",
            "chalicefy,517,266,luxembourg",
            "iris,25,657,singapore",
            "bob,688,451,beijing",
            "bob,263,1258,tokyo",
            "maybe,140,222,amsterdam",
            "xnova,852,330,barcelona",
            "xnova,589,837,budapest",
            "lee,152,981,mexico",
            "alex,893,1976,shenzhen",
            "xnova,560,825,prague",
            "chalicefy,283,399,zurich",
            "iris,967,1119,guangzhou",
            "alex,924,223,milan",
            "chalicefy,212,1865,chicago",
            "alex,443,537,taipei",
            "maybe,390,5,shanghai",
            "bob,510,1923,madrid",
            "bob,798,343,hongkong",
            "iris,643,1703,madrid",
            "bob,478,928,barcelona",
            "maybe,75,1980,shanghai",
            "xnova,293,24,newdelhi",
            "iris,176,268,milan",
            "alex,783,81,moscow",
            "maybe,560,587,milan",
            "alex,406,776,istanbul",
            "lee,558,727,paris",
            "maybe,481,1504,munich",
            "maybe,685,602,madrid",
            "iris,678,788,madrid",
            "xnova,704,274,newdelhi",
            "chalicefy,36,1984,paris",
            "iris,749,200,amsterdam",
            "lee,21,119,taipei",
            "iris,406,433,bangkok",
            "bob,777,542,taipei",
            "maybe,230,1434,barcelona",
            "iris,420,1818,zurich",
            "lee,622,194,amsterdam",
            "maybe,545,608,shanghai",
            "xnova,201,1375,madrid",
            "lee,432,520,dubai",
            "bob,150,1634,singapore",
            "maybe,467,1178,munich",
            "iris,45,904,beijing",
            "maybe,607,1953,tokyo",
            "bob,901,815,tokyo",
            "maybe,636,558,milan",
            "bob,568,1674,toronto",
            "iris,825,484,madrid",
            "iris,951,930,dubai",
            "bob,465,1080,taipei",
            "bob,337,593,chicago",
            "chalicefy,16,176,rome",
            "chalicefy,671,583,singapore",
            "iris,268,391,chicago",
            "xnova,836,153,jakarta",
            "bob,436,530,warsaw",
            "alex,354,1328,luxembourg",
            "iris,928,1565,paris",
            "xnova,627,834,budapest",
            "xnova,640,513,jakarta",
            "alex,119,16,toronto",
            "xnova,443,1687,taipei",
            "chalicefy,867,1520,montreal",
            "alex,456,889,newdelhi",
            "lee,166,3,madrid",
            "bob,65,1559,zurich",
            "alex,628,861,moscow",
            "maybe,668,572,mexico",
            "bob,402,922,montreal"
        ]
        # ["bob,649,842,prague","alex,175,1127,mexico","iris,164,119,paris","lee,991,1570,mexico","lee,895,1876,taipei",
        # "iris,716,754,moscow","chalicefy,19,592,singapore","chalicefy,820,71,newdelhi","maybe,231,1790,paris",
        # "lee,158,987,mexico","iris,803,691,milan","xnova,786,804,guangzhou","lee,734,1915,prague","bob,836,1904,dubai",
        # "iris,666,231,chicago","iris,677,1451,milan","maybe,860,517,toronto","iris,344,1452,bangkok",
        # "lee,664,463,frankfurt","chalicefy,95,1222,montreal","lee,293,1102,istanbul","maybe,874,36,hongkong",
        # "maybe,457,1802,montreal","xnova,535,270,munich","iris,39,264,istanbul","chalicefy,548,363,barcelona",
        # "lee,373,184,munich","xnova,405,957,mexico",
        # "chalicefy,517,266,luxembourg","iris,25,657,singapore",
        # "bob,688,451,beijing","bob,263,1258,tokyo",
        # "xnova,852,330,barcelona","xnova,589,837,budapest","lee,152,981,mexico","alex,893,1976,shenzhen",
        # "xnova,560,825,prague","iris,967,1119,guangzhou","alex,924,223,milan","chalicefy,212,1865,chicago",
        # "alex,443,537,taipei","bob,510,1923,madrid"...
        print(solution.invalidTransactions(transactions_e).__len__())

        pass


"""
A transaction is possibly invalid if:
1，the amount exceeds $1000, or;
2，if it occurs within (and including) 60 minutes of another transaction 
with the same name in a different city.

Each transaction string transactions[i] consists of comma separated values 
representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, 
return a list of transactions that are possibly invalid.  

You may return the answer in any order.


Example 1:
Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid 
because the second transaction occurs within a difference of 60 minutes, 
have the same name and is in a different city. Similarly the second one is invalid too.

Example 2:
Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]

Example 3:
Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]

Constraints:
transactions.length <= 1000
Each transactions[i] takes the form "{name},{time},{amount},{city}"
Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
Each {time} consist of digits, and represent an integer between 0 and 1000.
Each {amount} consist of digits, and represent an integer between 0 and 2000.

@author: yline
@time 2020/3/28 14:15
"""
