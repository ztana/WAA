/**
 * Question has a question and associated (correct) answer
 */

package app;

/**
 *
 * @author levi
 */
public class Problem {
    private String question;
    private String answer;
    private String hint;
    
    public Problem(String question, String answer, String hint) {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
