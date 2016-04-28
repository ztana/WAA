package controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Quiz;

@Named("quiz")
@SessionScoped

public class TakeQuiz implements Serializable {
    private Quiz quiz;
    
    private String age; //used string because validation is done here.
    private String answer;  //answer supplied by user
    private boolean hintReq;    //check if user has clicked the hint button
    private boolean wrong;  //check if we need to show the wrong answer text
    private boolean correction; //check if correction answer needs to show
    private boolean isNew;  //checker to stop checks for first load
    private String ageErrorText;    //display one of 2 age error messages
    
    public TakeQuiz() {
        quiz = new Quiz();
        isNew = true;
    }
    
    public String getAge() {
        return age;
    }
    public String getAnswer() {
        return answer;
    }
    public boolean isWrong() {
        return wrong;
    }
    public String getCurrentQuestionPartial() {
        return quiz.getCurrentQuestionPartial();
    }
    public int getCurrentQuestionIndex() {
        return quiz.getCurrentQuestionIndex();
    }
    public String getHint() {
        return quiz.getHint();
    }
    public int getScore() {
        return quiz.getScore();
    }
    public int getAttempt() {
        return quiz.getAttempt();
    }
    public String getAgeErrorText() {
        return ageErrorText;
    }
    public String getCorrectionText() {
        return "You missed 3 times. The correct answer was " 
                + quiz.getPrevAnswer() + ".";
    }
    public String getGrade() {
        return quiz.computeGrade();
    }
    public boolean isHintReq() {
        return hintReq;
    }
    public boolean isCorrection() {
        return correction;
    }
    public boolean isAgeError() {
        if (isNew)
            return false;
        try {
            int numAge = Integer.parseInt(age);
            if (numAge < 4 || numAge > 100) {
                ageErrorText = "Age must be between 4 and 100. (Inclusive)";
                return true;
            }
            return false;
        }
        catch (NumberFormatException e) {
            ageErrorText = "Age must be an integer.";
                return true;
        }
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String onHint() {
        hintReq = true;
        return "QuizPage.xhtml";
    }
    public String onNext() {
        if (isNew == true)
            isNew = false;
        correction = false;
        hintReq = false;
        if (isAgeError())   //do not process answer if there is an age error.
            return "QuizPage.xhtml";
        if (quiz.isCorrect(answer)) {
            wrong = false;
            answer = "";//Erase the answer textbox.
            if (getCurrentQuestionIndex() == quiz.getNumQuestions() - 1) {
                quiz.scoreAnswer();
                return "QuizOverPage.xhtml";
            }          
            quiz.scoreAnswer();
            return "QuizPage.xhtml"; 
        }
        else {
            answer = "";//Erase the answer textbox.
            wrong = true;
            if (quiz.getAttempt() > 3) {
                correction = true;
                if (getCurrentQuestionIndex() == quiz.getNumQuestions() - 1)
                    return "QuizOverPage.xhtml";
                quiz.skipQuestion();
            }                  
            return "QuizPage.xhtml";
        }
    }
    public String onRestart() {
        hintReq = false;
        correction = false;
        answer = ""; //Erase the answer textbox.
        quiz = new Quiz();
        return "QuizPage.xhtml";
    }
}
