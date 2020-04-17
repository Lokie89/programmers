package level1.cannotfinishrunner;

public class Test {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(new Solution().solution(participant, completion)); // leo

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(new Solution().solution(participant2, completion2)); // vinko

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(new Solution().solution(participant3, completion3)); // mislav
    }
}
