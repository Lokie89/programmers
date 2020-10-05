package level0.k3;


public class Test {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"
        };
        int[] result = new Solution().solution(info, query);
        for(int a : result){
            System.out.println(a);
        }
    }
}