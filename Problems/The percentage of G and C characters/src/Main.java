import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        sequence = sequence.toLowerCase();
        int gc = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'g' || sequence.charAt(i) == 'c') {
                gc++;
            }
        }

        double result = (double) gc / sequence.length() * 100;

        System.out.println(result);
    }
}