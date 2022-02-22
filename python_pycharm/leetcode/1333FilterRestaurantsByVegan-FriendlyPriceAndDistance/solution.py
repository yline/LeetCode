import unittest


class Solution:
    # restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> List[int]
    def filterRestaurants(self, restaurants: list, veganFriendly: int, maxPrice: int, maxDistance: int) -> list:
        pass


class Key:

    def __init__(self, _id, _rating) -> None:
        self._id = _id
        self._rating = _rating


class SolutionA(Solution):
    # [id=1, rating=4, veganFriendly=1, price=40, distance=10]
    def filterRestaurants(self, restaurants: list, veganFriendly: int, maxPrice: int, maxDistance: int) -> list:
        from operator import itemgetter

        filter_list = list()

        for item in restaurants:
            if item[2] < veganFriendly:
                continue
            if item[3] > maxPrice:
                continue
            if item[4] > maxDistance:
                continue
            filter_list.append(item)

        filter_list.sort(key=itemgetter(1, 0), reverse=True)

        result_list = [item[0] for item in filter_list]
        return result_list


class Example(unittest.TestCase):

    def setUp(self) -> None:
        super().setUp()

    def test_solution_a(self):
        self.solution = SolutionA()
        self.__assert_equal()
        pass

    def __assert_equal(self):
        solution = self.solution

        restaurants_a = [[1, 4, 1, 40, 10],
                         [2, 8, 0, 50, 5],
                         [3, 8, 1, 30, 4],
                         [4, 10, 0, 10, 3],
                         [5, 1, 1, 15, 1]]
        list_a = solution.filterRestaurants(restaurants_a, 1, 50, 10)
        list_b = solution.filterRestaurants(restaurants_a, 0, 50, 10)
        print(list_a)
        print(list_b)

        # 实现具体的校验内容
        pass


"""
Given the array restaurants where restaurants[i] = [id.i, rating.i, veganFriendly.i, price.i, distance.i]. 
You have to filter the restaurants using three filters.

The veganFriendly filter will be either 
true (meaning you should only include restaurants with veganFriendly.i set to true) or 
false (meaning you can include any restaurant). 

In addition, you have the filters maxPrice and maxDistance 
which are the maximum value for price and distance of restaurants you should consider respectively.

Return the array of restaurant IDs after filtering, 
ordered by rating from highest to lowest. 

For restaurants with the same rating, order them by id from highest to lowest. 
For simplicity veganFriendly.i and veganFriendly take value 1 when it is true, and 0 when it is false.

true「1」false「0」

Example 1:
Input: restaurants = [
[1,4,1,40,10],
[2,8,0,50,5],
[3,8,1,30,4],
[4,10,0,10,3],
[5,1,1,15,1]], 
veganFriendly = 1, maxPrice = 50, maxDistance = 10
Output: [3,1,5] 

Explanation: 
The restaurants are:
Restaurant 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
Restaurant 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
Restaurant 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
Restaurant 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
Restaurant 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1] 
After filter restaurants with veganFriendly = 1, maxPrice = 50 and maxDistance = 10 
we have restaurant 3, restaurant 1 and restaurant 5 (ordered by rating from highest to lowest). 

Example 2:
Input: restaurants = [
[1,4,1,40,10],
[2,8,0,50,5],
[3,8,1,30,4],
[4,10,0,10,3],
[5,1,1,15,1]], 
veganFriendly = 0, maxPrice = 50, maxDistance = 10
Output: [4,3,2,1,5]

Explanation: The restaurants are the same as in example 1, 
but in this case the filter veganFriendly = 0, 
therefore all restaurants are considered.

Example 3:
Input: restaurants = [
[1,4,1,40,10],
[2,8,0,50,5],
[3,8,1,30,4],
[4,10,0,10,3],
[5,1,1,15,1]], 
veganFriendly = 0, maxPrice = 30, maxDistance = 3
Output: [4,5]

Constraints:
1 <= restaurants.length <= 10^4
restaurants[i].length == 5
1 <= idi, rating.i, price.i, distance.i <= 10^5
1 <= maxPrice, maxDistance <= 10^5
veganFriendly.i and veganFriendly are 0 or 1.
All id.i are distinct.

@author: yline
@time 2020/2/26 16:29
"""
