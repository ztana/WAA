package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz {
	private int correctCounter;
	private int questionNum;
        private int attempt;
        private int score;
	private final ArrayList<ArrayList<Integer>> questions;
	
	public Quiz() {
		questionNum = correctCounter = score = 0;
                attempt = 1;
		questions = new ArrayList<>();
		questions.add(new ArrayList<>(Arrays.asList(3,1,4,1,5,9)));
		questions.add(new ArrayList<>(Arrays.asList(1,1,2,3,5,8)));
		questions.add(new ArrayList<>(Arrays.asList(1,4,9,16,25,36)));
		questions.add(new ArrayList<>(Arrays.asList(2,3,5,7,11,13)));
		questions.add(new ArrayList<>(Arrays.asList(1,2,4,8,16,32)));
	}
	
        public int scoreAnswer() {
		correctCounter++;
                switch(attempt) {
                    case 1:
                        score += 10;
                        break;
                    case 2:
                        score += 5;
                        break;
                    case 3:
                        score += 2;
                        break;
                    default: 
                }
                attempt = 1;
		if (questionNum == (questions.size() - 1))
			questionNum = 0;
		else
			questionNum++;
                return questionNum;
	}
        public void skipQuestion() {
            attempt = 1;
            if (questionNum == (questions.size() - 1))
		questionNum = 0;
            else
		questionNum++;
        }
        
        public String computeGrade() {
            if (score >= 45)
                return "A";
            else if (score >= 35)
                return "B";
            else if (score >= 25)
                return "C";
            else
                return "NC";
        }
        public int getScore() {
            return score;
        }
	public int getNumCorrect() {
		return correctCounter;
	}

	public String getCurrentQuestion() {
		ArrayList<Integer> question = questions.get(questionNum);
		StringBuilder m = new StringBuilder();
		m.append("[");
		for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                            m.append(question.get(i));
                            m.append(", ?]");
                    }
				
                    else {
			m.append(question.get(i));
                        m.append(", ");
                    }
		}		
		return m.toString();
	}
        
        public String getCurrentQuestionPartial() {
            String m = getCurrentQuestion();
            return m.substring(0, m.length()-2);
        }

        public String getHint() {
            String hint;
            switch(getCurrentQuestionIndex()) {
                case 0:
                    hint = "Pi";
                    break;
                case 1:
                    hint = "Fibonacci";
                    break;
                case 2:
                    hint = "Squares";
                    break;
                case 3:
                    hint = "Primes";
                    break;
                default:
                    hint = "You're on your own on this one ...";
            }
            return hint;
        }
        
        public String getAnswer() {
            ArrayList fullString =  questions.get(questionNum);
            return fullString.get(fullString.size() - 1).toString();
        }
        public String getPrevAnswer() {
            ArrayList fullString;
            if (questionNum == 0)
                fullString =  questions.get(questionNum);
            else
                fullString =  questions.get(questionNum - 1);
            return fullString.get(fullString.size() - 1).toString();
        }
	public boolean isCorrect(String answer) throws NumberFormatException {
		try {
			int ans = Integer.parseInt(answer);
			ArrayList<Integer> temp = questions.get(questionNum);
			boolean correct = ans == temp.get(temp.size() - 1);
                        if (correct)
                            return true;
                        else {
                            attempt++;
                            return false;
                        }
		}
                //no further exception handling need here
                //suffice to state the answer is incorrect
		catch (NumberFormatException e) {
                        return false;
		}
	}
        public int getAttempt() {
            return attempt;
        }
      
	public int getNumQuestions() {
		return questions.size();
	}

	public int getCurrentQuestionIndex() {
		return questionNum;
	} 
}
