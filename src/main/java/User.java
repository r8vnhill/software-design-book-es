/**
 * Documentation intentionally left blank.
 */
class User {
  String username, gender;

  User(String username, String gender) {
    this.username = username;
    this.gender = gender;
  }

  User(String username) {
    this(username, "Non specified");
  }
}
