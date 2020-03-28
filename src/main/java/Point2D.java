/**
 * Documentation is purposely left blank.
 */
class Point2D {
  double x, y;

  Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static void main(String[] args) {
    Point2D point = new Point2D(1, 3);
    Point2D newPoint = point.add(new Point2D(-1, 2));
    newPoint.print();
  }

  Point2D add(Point2D otherPoint) {
    return new Point2D(x + otherPoint.x, y + otherPoint.y);
  }

  void print() {
    System.out.println("(" + x + ", " + y + ")");
  }
}
