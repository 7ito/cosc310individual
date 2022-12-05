package com.example;

import java.util.*;
import java.util.ArrayList;

public class Chatbot {

    private ArrayList<String> questions;

    public Chatbot(){
        //initializes question list
        questions = new ArrayList<String>();
        questions.add("What's your favorite form of social media?");
        questions.add("What was the last good book you read?");
        questions.add("Have you done anything exciting lately?");
        questions.add("Have you been on any interesting trips lately?");
        questions.add("Are you a cat person or a dog person?");
    }

    public String randomQuestion(){
        //pick a random question from the questionlist
        if (!questions.isEmpty()) {
            int index = new Random().nextInt(questions.size());
			String question = questions.get(index);
            System.out.println(question);
            questions.remove(index);
			return question;
        } else {
            System.out.println("Oops, I ran out of questions!");
            endConversation();
			return "Oops, I ran out of questions!";
        }
    }
    
    public void answerList(String answer, String question) {
    	//laying out answers for each question by question index
    	switch (question) {
    	  case "What's your favorite form of social media?":
    		  if (answer.toLowerCase().equals("facebook")) {
    	    	System.out.println("Cool, this used to be the king of all social medias");
    	    } else if (answer.toLowerCase().equals("instagram")) {
    	    	System.out.println("Cool, you must like pictures, this is the go to platform for great photographs");
    	    }else if (answer.toLowerCase().equals("tiktok")) {
    	    	System.out.println("Cool, this started out as a fun rythem lip singing and dancing platform, it has been super popular these recent years ");
    	    }else if (answer.toLowerCase().equals("snapchat")) {
    	    	System.out.println("Cool, this is a fun chating app with features such as delete after seen, they started out small but quickly became popular among young people");
    	    }else {
    	    	System.out.println("Sorry, I don't know that one, but it sounds like fun");
    	    }
    	    break;
    	  case "What was the last good book you read?":
    		  if (answer.toLowerCase().equals("harry potter")) {
      	    	System.out.println("Wow, a classic");
      	    } else if (answer.toLowerCase().equals("1984")) {
      	    	System.out.println("Wow, a political classic");
      	    }else if (answer.toLowerCase().equals("one hundred years of solitude")) {
      	    	System.out.println("Wow, you must be a deep thinker");
      	    }else if (answer.toLowerCase().equals("pride and prejudice")) {
      	    	System.out.println("Wow, a timeless classic");
      	    }else {
      	    	System.out.println("Sorry, I don't know that one, but it sounds like fun");
      	    }
    		  break;
    	  case "Have you done anything exciting lately?":
    		  if (answer.toLowerCase().equals("i made a chatbot")) {
      	    	System.out.println("Good to see you made a coding project");
      	    } else if (answer.toLowerCase().equals("i have been studying")) {
      	    	System.out.println("Good to see you are being a good student, but do remember that you still need to have some fun");
      	    }else if (answer.toLowerCase().equals("i took a girl out for a date")) {
      	    	System.out.println("Good for you, say hi to her for me");
      	    }else {
      	    	System.out.println("Sorry, I don't know this kind of activity, hope you had fun");
      	    }    	    
    		  break;
    	  case "Have you been on any interesting trips lately?":
    		  if (answer.toLowerCase().equals("vancouver")) {
        	    	System.out.println("Nice, it is such a diverse city");
        	    } else if (answer.toLowerCase().equals("toronto")) {
        	    	System.out.println("Cool, hopefully it has not been too cold for you there");
        	    }else if (answer.toLowerCase().equals("seattle")) {
        	    	System.out.println("Cool, that city has been artsy and tech savvy");
        	    }else {
        	    	System.out.println("Sorry, I don't know this place, hope you had fun");
        	    }    	        	    
    		  break;
    	  case "Are you a cat person or a dog person?":
    		  if (answer.toLowerCase().equals("dog")) {
        	    	System.out.println("Nice, there is a saying that dogs are human's best friend");
        	    } else if (answer.toLowerCase().equals("cat")) {
        	    	System.out.println("Nice, The road to my heart is paved with paw prints");
        	    }else {
        	    	System.out.println("Sorry, I didn't get that");
        	    }    	    
    		  break;
    	}
    }

    public void endConversation() {
		askForFeedBack();
		System.out.println("It was nice talking to you. Hope your study goes well!");
        System.exit(0);
    }
    
	public void askForFeedBack(){
		System.out.println("Please describe your experience!");
		Scanner in  = new Scanner(System.in);
		String ans = in.nextLine();
		sentimentAnalyzer SA = new sentimentAnalyzer();
		int sentScore = SA.getSentimentInt(ans);
		if(sentScore <= 1){
			System.out.println("I'm sorry to hear that! your feedbacks will be provided to the developers to further improve my performances.");
		}
		else{
			System.out.println("I'm glad to hear that! Hope I'm able to better assist you in the future!");
		}
		in.close();
	}
}