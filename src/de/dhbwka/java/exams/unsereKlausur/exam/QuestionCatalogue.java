package de.dhbwka.java.exams.unsereKlausur.exam;

import java.util.*;

public class QuestionCatalogue {
    private Set<Question> questions = new HashSet<>();
    private Set<Question> startQuestions = new HashSet<>();

    public void addQuestion(Question q) {
        if (q.isStart()) {
            startQuestions.add(q);
        } else {
            questions.add(q);
        }
    }

    public List<Question> getStartQuestions() {
        return startQuestions.stream().toList();
    }

    public List<Question> getQuestions() {
        return questions.stream().toList(); // falls nicht geht nicht mehr casten
    }

    public List<Question> getQuestions(int n) throws EvasionException {
        if (startQuestions.isEmpty() || questions.size() < n - 1) {
            throw new EvasionException("zu wenige Fragen im Katalog");
        }
        List<Question> answer = new ArrayList<>();
        Random rnd = new Random();
        answer.add(startQuestions.stream().toList().get(rnd.nextInt(startQuestions.size()))); // Achtung hier!!
        int i = 0;


        Set<Integer> doubles = new HashSet<>();
        while (doubles.size() <= n - 2) {
            doubles.add(rnd.nextInt(questions.size()));
        }

        while (i < n - 1) {
            answer.add(questions.stream().toList().get(doubles.stream().toList().get(i))); // Achtung hier!! //Duplikate!!
            i++;
        }
        return answer;
    }
}
