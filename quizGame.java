import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    List<String> options;
    int correctAnswerIndex;

    public Question(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizGame {

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        // Sample questions
        questions.add(new Question("What is the capital of France?", 
            List.of("1. Berlin", "2. Madrid", "3. Paris", "4. Rome"), 2));
        questions.add(new Question("What is 2 + 2?", 
            List.of("1. 3", "2. 4", "3. 5", "4. 6"), 1));
        questions.add(new Question("What is the largest planet in our Solar System?", 
            List.of("1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"), 2));
        
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You will receive 1 point for each correct answer.\n");

        for (Question q : questions) {
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Enter the number of your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userAnswer - 1 == q.correctAnswerIndex) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (q.correctAnswerIndex + 1) + ". " + q.options.get(q.correctAnswerIndex));
            }
            System.out.println();
        }

        System.out.println("Quiz Over! Your total score is: " + score + "/" + questions.size());
        scanner.close();
    }
}
