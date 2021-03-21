/**
 * Documentation is purposely left blank.
 */
public class Vector2D extends VectorND {

  public Vector2D(double x, double y) {
    super(new double[]{x, y});
  }

  @Override
  public Vector2D add2D(final Vector2D otherVector) {
    return (Vector2D) super.add2D(otherVector);
  }

  public static void main(String[] args) {
    Vector2D point = new Vector2D(1, 3);
    VectorND newPoint = point.add(new Vector2D(-1, 2));
    newPoint.print();
  }
}
