/**
 * Documentation is purposely left blank.
 */
public class Vector2D extends VectorND {

  public Vector2D(double x, double y) {
    super(new double[]{x, y});
  }

  public static void main(String[] args) {
    Vector2D point = new Vector2D(1, 3);
    VectorND newPoint = point.add(new Vector2D(-1, 2));
    newPoint.print();
  }
}
