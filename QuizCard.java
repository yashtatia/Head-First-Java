import java.util.*;
import java.io.*;

public class QuizCard{
private String question;
private String answer;

public QuizCard(String q, String a){
answer = a;
question = q;
}

public String getAnswer(){
return answer;
}

public String getQuestion(){
return question;
}
}
