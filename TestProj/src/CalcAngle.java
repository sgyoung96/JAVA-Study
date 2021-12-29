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

//        /* 1사분면 */
//        lShoulderX = 0;
//        lShoulderY = 0;
//        rShoulderX = 2;
//        rShoulderY = 2;
////        test45Degree(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
////        System.out.println("***************************************");
//        System.out.println("***************fixDelta****************");
//        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);   // 135
//        System.out.println("***************************************");
//
//        /* 3사분면 */
//        lShoulderX = 0;
//        lShoulderY = 0;
//        rShoulderX = -2;
//        rShoulderY = -2;
////        test135Degree(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
////        System.out.println("***************************************");
//        System.out.println("***************fixDelta****************");
//        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);   // 45
//        System.out.println("***************************************");
//
//        /* 음수 ~ 음수 */
//        lShoulderX = -2;
//        lShoulderY = -2;
//        rShoulderX = -4;
//        rShoulderY = -4;
////        testMinusPoints(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
////        System.out.println("***************************************");
//        System.out.println("***************fixDelta****************");
//        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);   // 45
//        System.out.println("***************************************");
//
//        /* 계산식 절댓값(양수)로 치환 */
////        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
////        System.out.println("***************************************");
//
//        /* 2사분면 */
//        lShoulderX = 0;
//        lShoulderY = 0;
//        rShoulderX = 2;
//        rShoulderY = -2;
//        testFixDelta(lShoulderX, lShoulderY, rShoulderX, rShoulderY);   // 315
//        System.out.println("***************************************");

        // ************************************************************************************
        // 양수 및 음수에 대하여 각각 예외 처리
        // ************************************************************************************
        testFixMinus(0,0,2,2); // 135       -135
        testFixMinus(0,0,2,-2); // 315      135
        testFixMinus(0,0,-2,-2); // 45      45
        testFixMinus(0,0,-2,2); // 45       -45

        testFixMinus(2,2,4,4); // 135       -135
        testFixMinus(2,2,4,-2); // 315      116.xxx <- ?
        testFixMinus(2,2,-2,-2); // 45      45
        testFixMinus(-2,-2,-4,-4); // 45    45
    }

    /**
     * 추론 : 45 도 각도가 나와야 함
     * 결과 : 45.0
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
//        deltaX = rShoulderX - lShoulderX;
//        deltaY = rShoulderY - lShoulderY;
//        deltaX = Math.abs(rShoulderX) - Math.abs(lShoulderX);
//        deltaY = Math.abs(rShoulderY) - Math.abs(lShoulderY);
//        deltaX = Math.abs(rShoulderX - lShoulderX);
//        deltaY = Math.abs(rShoulderY - lShoulderY);

        deltaX = lShoulderX - rShoulderX;
        deltaY = lShoulderY - rShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        /* 음수 값 보정 */
        double result = Math.abs(angle);

        System.out.println(result);         // 45 // --------> 가 나와야 함
        // System.out.println(180 - result);   // 135
    }

    /**
     * 음수 값 예외 처리 : 기준좌표 = rShoulder (A)
     */
    private static void testFixMinus(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        deltaX = lShoulderX - rShoulderX;
        deltaY = lShoulderY - rShoulderY;

//        if (rShoulderX < lShoulderX && rShoulderY < lShoulderY) { // 135
//            angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
//            System.out.println("135 : " + Math.abs(angle));
//        } else if (rShoulderX < lShoulderX && rShoulderY > lShoulderY) { // 315
//            angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
//            System.out.println("135 : " + Math.abs(angle));
//        } else if (rShoulderX > lShoulderX && rShoulderY > lShoulderY) { // 45
//            angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
//            System.out.println("45 : " + Math.abs(angle));
//        } else if (rShoulderX > lShoulderX && rShoulderY < lShoulderY) { // 45
//            angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
//            System.out.println("45 : " + Math.abs(angle));
//        }

        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
        /* 음수 값 보정 */
        double result = Math.abs(angle);

        System.out.println(result);
    }
}
