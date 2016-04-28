<%-- 
    Document   : quiz
    Created on : Jan 10, 2008, 2:28:44 PM
    Author     : levi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>NumberQuiz</title>
</head>
<body>
	<form method='post'>
		<h3>Have fun with NumberQuiz!</h3>
<p>Your current score is: </p>
${quiz.numCorrect}
<p>Guess the next number in the sequence!  ${quiz.currentProblem.question} </p>

<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> 

<p style = 'color:red;visibility:${errorVisibility}'> Your last answer was not correct! Please try again.</p> 

<p style = 'visibility:${hintVisibility}'>${quiz.currentProblem.hint}</p>
<p><input type='submit' name='btnNext' value='Hint' /></p> 
<p><input type='submit' name='btnNext' value='Next' /></p> 

</form>
</body></html>