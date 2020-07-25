import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = line + " ";
        int number = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(line.charAt(0));

        for (int i = 0; i < line.length() - 1; i++) {
            number++;
            if (line.charAt(i) != line.charAt(i + 1)) {
                sb.append(number);
                number = 0;
                sb.append(line.charAt(i + 1));
            }

        }

        System.out.println(sb);
    }
}