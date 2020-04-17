package level1.cannotfinishrunner;

import java.util.Arrays;

public class Solution {

    public String solution(String[] participants, String[] completions) {
        String answer = "";
        validateParticipantLength(participants);
        validateCompletionLength(participants, completions);
        validateParticipantName(participants);

        Arrays.sort(participants);
        Arrays.sort(completions);
        try {
            for (int i = 0; i < participants.length; i++) {
                if (!isSameString(participants[i], completions[i])) {
                    answer = participants[i];
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            answer = participants[participants.length - 1];
        }
        return answer;
    }

    private boolean isSameString(String a, String b) {
        return a.equals(b);
    }

    private void validateParticipantLength(String[] participant) {
        if (participant.length < 1) {
            throw new RuntimeException();
        }
        if (participant.length > 100000) {
            throw new RuntimeException();
        }
    }

    private void validateCompletionLength(String[] participant, String[] completion) {
        if (completion.length != participant.length - 1) {
            throw new RuntimeException();
        }
    }

    private void validateParticipantName(String[] participant) {
        for (String part : participant) {
            validateStringLengthOver(part, 20);
            validateStringLengthUnder(part, 1);
        }
    }

    private void validateStringLengthOver(String str, int length) {
        if (str.length() > length) {
            throw new RuntimeException();
        }
    }

    private void validateStringLengthUnder(String str, int length) {
        if (str.length() < length) {
            throw new RuntimeException();
        }
    }
}
