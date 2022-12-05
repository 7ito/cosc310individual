package com.example;
import java.util.Properties;

import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class sentimentAnalyzer {

    StanfordCoreNLP pipeline;

    public sentimentAnalyzer() {

        //initializes corenlp instance, set properties for sentiment analysis
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public int getSentimentInt(String input){

        // returns a sentiment score between 3-1. 3 = positive, 1 = negative, 0 = netural.
        Annotation annotation = pipeline.process(input);

        CoreMap in = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
        Tree tree = in.get(SentimentAnnotatedTree.class);
        int sentimentInt = RNNCoreAnnotations.getPredictedClass(tree);

        return sentimentInt;
    }

    public String getSentimentString(String input){

            // returns a sentiment score between positive, negative, or netural.
        Annotation annotation = pipeline.process(input);
        
        CoreMap in = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
        String sentimentString = in.get(SentimentCoreAnnotations.SentimentClass.class);

        return sentimentString;
    }
}
