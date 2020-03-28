/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio
 *     Slater Muñoz</a>.
 * @since
 */
class User {
  String username, gender;

  public static void main(String[] args) {
    int[] ints = new int[5];
    ints[0] = 100;
    System.out.println(ints[0]); // Imprime 100
    System.out.println(ints[1]); // Imprime 0
  }

  User(String username, String gender) {
    this.username = username;
    this.gender = gender;
  }

  User(String username) {
    this(username, "Non specified");
  }
}
