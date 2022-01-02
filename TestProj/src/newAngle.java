public class newAngle {

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

    public static double result;     // 보정값

    public static double lShoulderX2;
    public static double lShoulderY2;
    public static double midShoulderX;
    public static double midShoulderY;

    public static void main(String[] args) {

//        lShoulderX = 136.16776;
//        lShoulderY = 98.033356;
//        rShoulderX = 115.96721;
//        rShoulderY = 102.60439;

//        lShoulderX = 0;
//        lShoulderY = 0;
//        rShoulderX = 2;
//        rShoulderY = 2;

        midShoulderX = 125.0;
        midShoulderY = 83.0;
        lShoulderX2 = 133.0;
        lShoulderY2 = 87.0;

//        calcAngle(lShoulderX, lShoulderY, rShoulderX, rShoulderY);
        calcAngle2(midShoulderX, midShoulderY, lShoulderX2, lShoulderY2);
    }

    private static void calcAngle(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = rShoulderX - lShoulderX;
        deltaY = rShoulderY - lShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        System.out.println(angle);
        // 절댓값이 180보다 클 때 ---> 절대 안 탐 (max = 180, min = -180)
        if (angle <= 180 && angle > 0) {             // 양수
            if (angle == 180) {
                result = angle;
                System.out.println(result);
            } else {
                result = 180 - angle;
                System.out.println(result);
            }
        } else if (angle >= -180 && angle < 0) {     // 음수
            if (angle >= -90) {
                result = 360 - Math.abs(angle);
                System.out.println(result);
            } else {
                result = 360 - angle;
                System.out.println(result);
            }
        } else if (angle == 0) {
            result = 360;
            System.out.println(result);
        } else {
            result = 0;
            System.out.println(result);
        }

        /*
            결과 값이 45 / 315 가 나왔으므로, lShoulder 가 기준이 맞고, lShoulder 가 화면상 오른쪽에 위치한, 인체로써는 왼쪽 어깨가 맞음
            우리가 원하는 보정값은 315
         */
    }

    private static void calcAngle2(double lShoulderX, double lShoulderY, double rShoulderX, double rShoulderY) {
        /* radian 구할 x, y 좌표 */
        deltaX = rShoulderX - lShoulderX;
        deltaY = rShoulderY - lShoulderY;

        /* 구한 radian(theta(세타)) 를 각도로 변환 */
        angle = Math.toDegrees(Math.atan2(deltaY, deltaX));

        System.out.println(angle);
    }
}
