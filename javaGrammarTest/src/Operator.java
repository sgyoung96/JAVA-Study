public class Operator {
    public static void main(String[] args) {
        Boolean isTablet = true;

        String first = isTablet ? "A" : "B";
        String second = !isTablet ? "A" : "B";

        System.out.println("first" + first);
        System.out.println("second" + second);
    }
}
