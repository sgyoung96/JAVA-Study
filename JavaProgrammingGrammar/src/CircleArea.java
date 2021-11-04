// 예제 2-1
// 원의 면적을 구하는 프로그램을 작성해 보자
public class CircleArea {
    // 원의 면적 = 반지름 * 반지름 * 3.14
    public static void main(String[] args) {
        Double halfCircle = 13.5;
        final Double PI = 3.14;

        double circleSize = halfCircle * halfCircle * PI;
        System.out.print("circleSize : " + circleSize);
    }
}