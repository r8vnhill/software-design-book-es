import java.util.Arrays;

/**
 * Documentation intentionally left blank.
 */
class VectorND {
  double[] tail;

  VectorND(double[] tail) {
    this.tail = tail;
  }

  public static void main(String[] args) {
    VectorND v1 = new VectorND(new double[]{0, 1, 2});
    VectorND v2 = v1.add(new VectorND(new double[]{1}));
    System.out.println(Arrays.toString(v2.tail));
  }

  VectorND add(VectorND otherVector) {
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
    for (int i = smaller.length; i < bigger.length; i++) {
      components[i] = bigger[i];
    }
    return new VectorND(components);
  }
}
  