package level1.caesarcipher;

public class Test {
    public static void main(String[] args) {
        String s1 = "AB";
        int n1 = 1;
        System.out.println(new Solution().solution(s1,n1));
        String s2 = "z";
        int n2 = 1;
        System.out.println(new Solution().solution(s2,n2));
        String s3 = "a B z";
        int n3 = 4;
        System.out.println(new Solution().solution(s3,n3));
    }
}
