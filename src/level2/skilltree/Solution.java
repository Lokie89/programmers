package level2.skilltree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/49993?language=java
public class Solution {
    public int solution(String skill, String[] skill_trees) {
        validateSkill(skill);
        validateSkillTreesLength(skill_trees);

        int answer = 0;
        for (String skillTree : skill_trees) {
            validateSkillTree(skillTree);
            if (isPossibleSkill(skill, skillTree)) {
                answer++;
            }
        }
        return answer;
    }

    boolean isPossibleSkill(String skill, String skillTree) {
        char[] skillArray = skill.toCharArray();
        int beforeIndex = 0;
        for (int i = 0; i < skillArray.length; i++) {
            char c = skillArray[i];
            int afterIndex = skillTree.indexOf(c);
            if (beforeIndex != -1 && afterIndex == -1) {

            } else if (beforeIndex == -1 && afterIndex != -1) {
                return false;
            } else if (beforeIndex > afterIndex) {
                return false;
            }
            beforeIndex = afterIndex;
        }
        return true;
    }

    // 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
    void validateUpperCase(String skill) {
        for (char s : skill.toCharArray()) {
            if (!Character.isUpperCase(s)) {
                throw new RuntimeException();
            }
        }
    }

    // 스킬 순서와 스킬트리는 문자열로 표기합니다.
    // 예를 들어, C → B → D 라면 CBD로 표기합니다
    // 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
    void validateSkill(String skill) {
        if (skill.length() < 1 || 26 < skill.length()) {
            throw new RuntimeException();
        }
        if (isDuplicateElements(skill)) {
            throw new RuntimeException();
        }
        validateUpperCase(skill);
    }

    //skill_trees는 길이 1 이상 20 이하인 배열입니다.
    void validateSkillTreesLength(String[] skill_trees) {
        if (skill_trees.length < 1 || 20 < skill_trees.length) {
            throw new RuntimeException();
        }
    }

    //skill_trees의 원소는 스킬을 나타내는 문자열입니다.
    //skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
    void validateSkillTree(String skillTree) {
        if (skillTree.length() < 2 || 26 < skillTree.length()) {
            throw new RuntimeException();
        }
        if (isDuplicateElements(skillTree)) {
            throw new RuntimeException();
        }
        validateUpperCase(skillTree);
    }

    // String str = "testString";
    // Character[] charObjectArray =
    //    str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    boolean isDuplicateElements(String s) {
        Character[] characters = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Set<Character> cSet = new HashSet<>(Arrays.asList(characters));
        return cSet.size() != s.length();
    }

    // 해답
//    public int solution(String skill, String[] skill_trees) {
//        int answer = 0;
//        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
//        //ArrayList<String> skillTrees = new ArrayList<String>();
//        Iterator<String> it = skillTrees.iterator();
//
//        while (it.hasNext()) {
//            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
//                it.remove();
//            }
//        }
//        answer = skillTrees.size();
//        return answer;
//    }
}