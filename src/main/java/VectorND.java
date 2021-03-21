import java.util.Arrays;

/**
 * Documentation intentionally left blank.
 */
public class VectorND {
  protected double[] tail;

  public VectorND(double[] tail) {
    this.tail = tail;
  }

 
  public VectorND add(VectorND otherVector) {
    double[] bigger, smaller;
    if (tail.length > otherVector.tail.length) {
      bigger = tail;
      smaller = otherVector.tail;
    } else {
      bigger = otherVector.tail;
      smaller = tail;
    }
    double[] components = new double[bigger.length];
    for (int i = 0; i < smaller.length; i++) {
      components[i] = bigger[i] + smaller[i];
    }
    if (bigger.length - smaller.length >= 0) {
      System.arraycopy(bigger, smaller.length, components, smaller.length,
                       bigger.length - smaller.length);
    }
    return new VectorND(components);
  }

  public VectorND add2D(Vector2D otherVector) {
    return null;
  }
  
  public void print() {
    String result = "";
    for (int idx = 0; idx < tail.length; idx++) {
      result += tail[idx];
      if (idx < tail.length - 1) {
        result += ", ";
      }
    }
    System.out.println("(" + result + ")");
  }
}
  