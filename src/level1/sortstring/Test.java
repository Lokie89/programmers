package level1.sortstring;

public class Test {
    public static void main(String[] args) {
        final String[] strings = new String[]{
                "cber", "abeq", "cdx"
        };
        final int n = 2;
        String[] answer = new Solution().solution(strings, n);
        for (String s : answer) {
            System.out.print(s + " ");
        }
    }
}
