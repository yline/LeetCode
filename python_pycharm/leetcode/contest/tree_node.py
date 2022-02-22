from queue import Queue


class TreeNode:
    """
    数据结构使用者：144、145
    """

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def is_equal(a: TreeNode, b: TreeNode):
    """
    判断两个结构是否相等
    """
    if a is None and b is None:
        return True

    if a is None or b is None:
        return False

    return a.val == b.val and is_equal(a.left, b.left) \
           and is_equal(a.right, b.right)


def build(*array):
    if array is None or array.__len__() == 0:
        return None

    # 计算层数
    level_total = 0
    length = array.__len__()
    while length != 0:
        length >>= 1
        level_total += 1
    total = 1 << level_total  # 总个数
    print('build level = {}, total = {}'.format(level_total, total))

    root = TreeNode(array[0])
    queue = Queue()  # 先进先出，队列
    queue.put(root)

    index = 1
    while index < total:
        temp = queue.get()

        if temp is None:
            # 空后面是两个空
            queue.put(None)
            queue.put(None)
        else:
            temp.left = __get_tree_node(array, index)
            temp.right = __get_tree_node(array, index + 1)

            queue.put(temp.left)
            queue.put(temp.right)

        index += 2
    return root


def print_tree(root: TreeNode):
    if root is None:
        print('root is none')
        return

    result = ''
    level_queue = Queue()  # 先进先出，队列
    level_queue.put(root)

    while not level_queue.empty():
        node = level_queue.get()
        if node is None:
            result += 'null, '
        else:
            result += str(node.val)
            result += ', '

            level_queue.put(node.left)
            level_queue.put(node.right)
    print('root = ', result)


def __get_tree_node(array, index):
    if index < array.__len__() and array[index] is not None:
        return TreeNode(array[index])
    return None


"""

@author: yline
@time 2020/1/18 11:16
"""
