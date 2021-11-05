// 예제 2-13
public class GradeSwitch {
    /*
    학점이 A, B 인 학생에게는 "참 잘하였습니다.",
    학점이 C, D 인 학생에게는 "좀 더 노력하세요.",
    학점이 F 인 학생에게는 "다음 학기에 다시 수강하세요."
    를 출력하는 프로그램을 switch 문의 break 를 잘 활용하여 작성하라.
    예외 처리는 "잘못된 학점입니다." 로 작성하기.
     */
    public static void main(String[] args) {
        String message = printMessage(30);
        System.out.println(message);
    }

    private static String printMessage(int score) {
        String message;
        char grade;

        if (score > 90) {
            grade = 'A';
        } else if (score > 80) {
            grade = 'B';
        } else if (score > 70) {
            grade = 'C';
        } else if (score > 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        message = switch (grade) {
            case 'A', 'B' -> "참 잘하였습니다.";
            case 'C', 'D' -> "좀 더 노력하세요.";
            case 'F' -> "다음 학기에 다시 수강하세요.";
            default -> "잘못된 학점입니다.";
        };

        return message;
    }
}
