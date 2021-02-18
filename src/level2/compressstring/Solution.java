package level2.compressstring;

import java.util.*;

public class Solution {
    public int solution(String s) {
        validateS(s);
        List<Integer> compress = compress(s);
        compress.sort(Integer::compareTo);
        if (s.length() == 1) {
            return 1;
        }
        return compress.get(0);
    }

    List<Integer> compress(String s) {
        List<Integer> sumList = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            List<String> list = new ArrayList<>();
            Queue<String> sQueue = new LinkedList<>(Arrays.asList(cut(s, i)));
            int count = 1;
            String beforeS = null;
            while (!sQueue.isEmpty()) {
                String afterS = sQueue.poll();
                if (beforeS == null) {
                    beforeS = afterS;
                } else if (beforeS.equals(afterS)) {
                    count++;
                } else {
                    String add = (count > 1 ? count + "" : "") + "" + beforeS;
                    list.add(add);
                    beforeS = afterS;
                    count = 1;
                }
            }
            String add = (count > 1 ? count + "" : "") + "" + beforeS;
            list.add(add);
            sumList.add(list.stream().mapToInt(String::length).sum());
        }
        return sumList;
    }

    String[] cut(String s, int index) {
        String[] arr = new String[s.length() / index + (s.length() % index == 0 ? 0 : 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(index * i, (index * (i + 1) > s.length()) ? s.length() : index * (i + 1));
        }
        return arr;
    }

    // s의 길이는 1 이상 1,000 이하입니다.
    // s는 알파벳 소문자로만 이루어져 있습니다.
    void validateS(String s) {
        if (s.length() < 1 || 1000 < s.length()) {
            throw new RuntimeException();
        }
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            if (!Character.isLowerCase(c)) {
                throw new RuntimeException();
            }
        }
    }


}