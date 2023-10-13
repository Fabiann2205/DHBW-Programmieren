package de.dhbwka.java.exams.unsereKlausur.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListAnswerGenerator implements AnswerGenerator {
    private List<Evasion> evasions = new ArrayList<>();

    public ListAnswerGenerator(List<Evasion> evasions) {
        this.evasions = evasions;
    }

    @Override
    public String generateAnswer(Question q, String topic) {
        Random rnd = new Random();
        int random;
        int i = 0;
        List<QuestionType> standard = new ArrayList<>();
        standard.add(QuestionType.YES_NO);
        standard.add(QuestionType.GENERAL);
        standard.add(QuestionType.WITNESS);
        Evasion current = new Evasion("Keine Antwort ist auch eine Antwort", standard);
        while (i < 10) {
            random = rnd.nextInt(evasions.size());
            if (evasions.get(random).isEvasionFor(q)) {
                current = evasions.get(random);
                break;
            }
            i++;
        }
        String answer = "";
        answer = Evasionator.replaceTopic(current.getText(), topic);
        return answer;
    }

    @Override
    public Evasion getRandomEvasion() {
        Random rnd = new Random();
        int random = rnd.nextInt(evasions.size());
        return evasions.get(random);
    }
}
