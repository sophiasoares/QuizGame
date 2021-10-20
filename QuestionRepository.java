package de.thu.quizgame;
import java.util.ArrayList;
import java.util.Random;

public class QuestionRepository {

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private int myQuestionNumber;
    Question myQuestion;

    public int getMyQuestionNumber() {
        return myQuestionNumber;
    }

    public void createRepository() {
        questionList.add(new Question("How many time zones are there in Russia?", new String[]{"11", "7", "13", "9"}, 0));
        questionList.add(new Question("Which of the following empires had no written language?", new String[]{"Incan", "Aztec", "Egyptian", "Roman"}, 0));
        questionList.add(new Question("What’s the smallest country in the world?", new String[]{"Monaco", "Tuvalu", "The Vatican", "Nauru"}, 2));
        questionList.add(new Question("What city do The Beatles come from?", new String[]{"London", "Cambridge", "Oxford", "Liverpool"}, 3));
        questionList.add(new Question("When was Netflix founded?", new String[]{"1994", "1997", "2005", "2009"}, 1));
    }

    public Question randomQuestion() {

        Random rand = new Random();

        // Generates a random number between 0 and 4
        int questionNumber = rand.nextInt(questionList.size()) - 1;

        Question chosenQuestion = questionList.get(questionNumber);
        this.myQuestionNumber = questionNumber;
        this.myQuestion = chosenQuestion;

        return chosenQuestion;
    }
}