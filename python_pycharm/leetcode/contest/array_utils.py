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
