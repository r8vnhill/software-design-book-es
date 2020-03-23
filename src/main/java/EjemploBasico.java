import java.util.Scanner;

public class EjemploBasico {

  public static void main(String[] args) {
    System.out.println("Write your name: ");
    String name = new Scanner(System.in).nextLine();
    System.out.println("My name is " + name + ", and I have a dream.");
  }
}
