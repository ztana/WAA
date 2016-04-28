/*
 * Quiz has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

package app;

import java.util.ArrayList;

/**
 *
 * @author levi
 */
public class Quiz {
    private ArrayList<Problem> questions = new ArrayList<Problem>();
    private ArrayList<String> answers;
    private int numCorrect = 0;
    /* 0 based index for the current question */
    private int currentProblemIndex = 0;  
    private int numQuestions;
    private Problem currentProblem = null;
    
    /**
     * 
     */
    public int getNumQuestions() {
        return questions.size();
    }
    /**
     * Create a new Quiz with questions
     */
    public Quiz() {
        questions.add(new Problem("[3 1 4 1 5]", "9", "pi"));
        questions.add(new Problem("[1 1 2 3 5]", "8", "fibonacci"));
        questions.add(new Problem("[1, 4, 9, 16, 25]", "36", "squares"));
        questions.add(new Problem("[2, 3, 5, 7, 11]", "13", "primes"));
        questions.add(new Problem("[1 2 4 8 16]", "32", "2 powers"));
        numQuestions = getNumQuestions();
        currentProblem = questions.get(0);
    }
    
    /**
     * return true or false if answer is correct or false for current question
     * @param ans
     * @return
     */
    public boolean isCorrect(String ans) {
        if (ans.equals(questions.get(currentProblemIndex).getAnswer())) {
            return true;
        }
        else {
            return false;
        }
        
    }    
    
    /**
     * increment the currentQuestion index 
     * and also increment the score (should be called if
     * answer is correct.
     */
    public void scoreAnswer() { //String ans) {
            currentProblemIndex++;
            numCorrect++;
            if (currentProblemIndex < numQuestions) {
                setCurrentProblem(questions.get(currentProblemIndex));
            }        
    }

    /**
     * getter
     * @return
     */
    public int getNumCorrect() {
        return this.numCorrect;
    }

    /**
     * getter
     */ 
    public int getCurrentQuestionIndex() {
        return this.currentProblemIndex;
    }
    
    /**
     * return the text for the current question
     */
    public Problem getCurrentProblem(){
        return currentProblem;
    }

    private void setCurrentProblem(Problem currentProblem) {
        this.currentProblem = currentProblem;
    }
    
     

}
