// 예제 3-1
// for 문을 이용하여 1부터 10까지 덧셈을 표시하고 합을 구하라.
public class ForSample {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                System.out.print(i + " + ");
            }
            if (i == 10) {
                System.out.print(i);
            }
            sum = sum + i;
        }
        System.out.print(" = " + sum);
    }
}
