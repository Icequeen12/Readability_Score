/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int result = Integer.parseInt(args[1]);

        if (operator.equals("MAX")) {
            for (int i = 2; i < args.length; i++) {
                if (Integer.parseInt(args[i]) > result)
                    result = Integer.parseInt(args[i]);
            }
        } else if (operator.equals("MIN")) {
            for (int i = 2; i < args.length; i++) {
                if (Integer.parseInt(args[i]) < result)
                    result = Integer.parseInt(args[i]);
            }
        } else {
            for (int i = 2; i < args.length; i++) {
                result += Integer.parseInt(args[i]);
            }
        }
        System.out.println(result);
    }
}