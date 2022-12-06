package com.example;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import io.github.fastily.jwiki.core.*;
import io.github.fastily.jwiki.dwrap.*;

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

    public String randomQuestion(Scanner in) throws IOException{
        //pick a random question from the questionlist
        if (!questions.isEmpty()) {
            int index = new Random().nextInt(questions.size());
			String question = questions.get(index);
            System.out.println(question);
            questions.remove(index);
			return question;
        } else {
            System.out.println("Oops, I ran out of questions!");
            endConversation(in);
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

    public void endConversation(Scanner in) throws IOException {
		askTranslate(in);
		askWiki(in);
		askForFeedBack(in);
		System.out.println("It was nice talking to you. Hope your study goes well!");
        System.exit(0);
    }
    
	public void askForFeedBack(Scanner in){
		System.out.println("Please describe your experience!");
		//Scanner in  = new Scanner(System.in);
		String ans = in.nextLine();
		sentimentAnalyzer SA = new sentimentAnalyzer();
		int sentScore = SA.getSentimentInt(ans);
		if(sentScore <= 1){
			System.out.println("I'm sorry to hear that! your feedbacks will be provided to the developers to further improve my performances.");
		}
		else{
			System.out.println("I'm glad to hear that! Hope I'm able to better assist you in the future!");
		}
		//in.close();
	}

	public void askWiki(Scanner in) {
		System.out.println("Is there anything from our conversation that you would like to look up?");
		Wiki wiki = new Wiki.Builder().build();
		//Scanner in = new Scanner(System.in);
		String ans = in.nextLine();
		sentimentAnalyzer SA = new sentimentAnalyzer();
		int sentScore = SA.getSentimentInt(ans);
		if(sentScore <= 1) {
			System.out.println("I see, let's move on then.");
		} else {
			System.out.println("What would you like to look up?");
			System.out.println(wiki.getTextExtract(in.nextLine()));
		}
		//in.close();
	}

	public void askTranslate(Scanner in) throws IOException {
		System.out.println("In our conversation, was there anything that you wanted to translate?");
		//Scanner in  = new Scanner(System.in);
		String ans = in.nextLine();
		sentimentAnalyzer SA = new sentimentAnalyzer();
		int sentScore = SA.getSentimentInt(ans);
		if (sentScore <= 1) {
			System.out.println("I see, then let's move on.");
		} else {
			System.out.println("What language would you like to translate to?");
			String language = in.nextLine().toLowerCase();
			System.out.println("What would you like to translate?");
			String toTranslate = in.nextLine().toLowerCase();
			Translate translate = TranslateOptions.newBuilder().setApiKey("AIzaSyDIZeJpy5mQYMGX6pXyWMOPdTvYYlHfi8g").build().getService();
			Translation translation = translate.translate(toTranslate, TranslateOption.sourceLanguage("en"), TranslateOption.targetLanguage(getLanguageCode(language)));
			System.out.println("That means: " + translation.getTranslatedText());
		}
		//in.close();
	}

	public String getLanguageCode(String language) {
		switch (language) {
			case "english":
				return "en";
			case "chinese":
				return "zh-CH";
			case "french":
				return "fr";
			case "german":
				return "de";
			case "hindi":
				return "hi";
			case "indonesian":
				return "id";
			case "italian":
				return "it";
			case "japanese":
				return "ja";
			case "korean":
				return "ko";
			case "latin":
				return "la";
			case "malay":
				return "ms";
			case "polish":
				return "pl";
			case "russian":
				return "ru";
			case "spanish":
				return "es";
			case "vietnamese":
				return "vi";
			default:
				return "en";
		}
	}
}