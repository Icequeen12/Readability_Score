import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.next());
        double b = Double.parseDouble(scanner.next());
        double c = Double.parseDouble(scanner.next());

        double delta = Math.pow(b, 2) - 4 * a * c;
        double s1 = (-b - Math.sqrt(delta)) / (2 * a);
        double s2 = (-b + Math.sqrt(delta)) / (2 * a);

        if (s1 > s2) {
            System.out.println(s2 + " " + s1);
        } else {
            System.out.println(s1 + " " + s2);
        }


    }
}