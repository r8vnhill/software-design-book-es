class Point2D:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def add(self, other_point):
        return Point2D(self.x + other_point.x,
                       self.y + other_point.y)

    def print(self):
        print(f"({self.x}, {self.y})")


if __name__ == "__main__":
    point = Point2D(1, 3)
    new_point = point.add(Point2D(-1, 2))
    new_point.print()
