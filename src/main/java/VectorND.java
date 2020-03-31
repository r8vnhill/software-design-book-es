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
    v2.print();
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
    if (bigger.length - smaller.length >= 0) {
      System.arraycopy(bigger, smaller.length, components, smaller.length,
                       bigger.length - smaller.length);
    }
    return new VectorND(components);
  }

  void print() {
    String result = "(";
    for (int idx = 0; idx < tail.length; idx++) {
      result += tail[idx];
      if (idx < tail.length - 1) {
        result += ", ";
      }
    }
    System.out.println(result + ")");
  }
}
  