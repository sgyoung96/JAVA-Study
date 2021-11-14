public class ArrayTest {
    public static void main(String[] args) {
        int intArray []; // 배열에 대한 레퍼런스 변수 선언
        // int intArray [10]; // Compile Error : 레퍼런스 변수는 크기를 할당할 수 없음
        intArray = new int[10]; // 배열 생성 : 생성된 배열의 주소 값(레퍼런스 값)을 레퍼런스 변수에 저장
        // intArray = new int[]; // Compile Error!

        /* 배열에 대한 레퍼런스 변수 선언 다음 방식도 가능 */
        int intArray2[];
        int[] intArray3;

        /* 배열의 초기화 */
        // intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Compile Error
        String[] stringArray = {""};

        /* for-each 문 */
        int[] num = {1,2,3,4,5};
        int sum = 0;
        for (int k : num) {
            sum += k;
        }

        /* enum class 에 대한 for-each 문 */
        enum Weekday {
            월,
            화,
            수,
            목,
            금,
            토,
            일
        }
        for (Weekday day : Weekday.values()) {
            System.out.print(day + "요일 ");
        }
    }
}
