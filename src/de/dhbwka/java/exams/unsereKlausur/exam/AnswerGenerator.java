package de.dhbwka.java.exams.unsereKlausur.exam;

public interface AnswerGenerator {
    String generateAnswer(Question q, String topic);

    Evasion getRandomEvasion();
}
