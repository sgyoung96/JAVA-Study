public class CalcAngle {

    /* 기준점 A */
    public static double lShoulderX; // 왼쪽 어깨 x
    public static double lShoulderY; // 왼족 어깨 y
    /* 변하는 좌표 = A 에 대하여 (x, y) 만큼 움직이는 B 좌표 */
    public static double rShoulderX; // 오른쪽 어깨 x
    public static double rShoulderY; // 오른쪽 어깨 y
    /* 각도 계산 */
    public static double deltaX;     // atan2 에 대입할 x
    public static double deltaY;     // atan2 에 대입할 y
    public static double angle;      // 각도

    public static void main(String[] args) {

        /* 1사분면 */
        lShoulderX = 0;
        lShoulderY = 0;
        rShoulderX = 2;
        rShoulderY = 2;
        test45Degree(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
        System.out.println("***************************************");

        /* 4사분면 */
        rShoulderX = -2;
        rShoulderY = -2;
        test135Degree(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
        System.out.println("***************************************");

        /* 음수 ~ 음수 */
        lShoulderX = -2;
        lShoulderY = -2;
        rShoulderX = -4;
        rShoulderY = -4;
        testMinusPoints(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
        System.out.println("***************************************");

        /* 계산식 절댓값(양수)로 치환 */
        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
        System.out.println("***************************************");
    }

    /**
     * 추론 : 45 도 각도가 나와야 함
     * 결과 : 45.0
     * 결론 :
     * lShoulder = A = 기준이 되는 고정 값
     * rShoulder = B = A 를 기준으로 (x, y) 만큼 이동하는 변화하는 값
     * 프로젝트 적용 :
     * lShoulder = 화면상 좌측에 위치한, 사람으로서는 오른쪽 어깨이지만 화면상으로는 좌측에 위치한 값
     * rShoulder = 화면상 우측에 위치한, 사람으로서는 왼쪽 어깨이지만 화면상으로는 우측에 위치한 값
     */
    private static void test45Degree (double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = rShoulderX - lShoulderX;
        deltaY = rShoulderY - lShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        System.out.println(angle);          // 45
        System.out.println(180 - angle);    // 135
    }

    /**
     * 추론 : 135 도 각도가 나와야 함
     * 결과 : -135
     */
    private static void test135Degree(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = rShoulderX - lShoulderX;
        deltaY = rShoulderY - lShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        /* 음수 값 보정 */
        double result = Math.abs(angle);

        System.out.println(angle);          // -135
        System.out.println(180 - angle);    // 315 (180 --135 = 180 + 135 = 315)
        System.out.println("result-----");
        System.out.println(result);         // 135
        System.out.println(180 - result);   // 45
    }

    /**
     * 추론 : 45 도 각도가 나와야 함
     */
    private static void testMinusPoints(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = rShoulderX - lShoulderX;
        deltaY = rShoulderY - lShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        /* 음수 값 보정 */
        double result = Math.abs(angle);

        System.out.println(result);         // 135
        System.out.println(180 - result);   // 45
    }

    /**
     * delta 값 보정 - 음수에 대하여 대응
     */
    private static void testFixDelta(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = Math.abs(rShoulderX) - Math.abs(lShoulderX);
        deltaY = Math.abs(rShoulderY) - Math.abs(lShoulderY);

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        /* 음수 값 보정 */
        double result = Math.abs(angle);

        System.out.println(result);         // 45
        System.out.println(180 - result);   // 135
    }
}
