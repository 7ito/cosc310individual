package com.example;
import org.junit.Test;
import static org.junit.Assert.*;


public class sentimentTest {
    String positive = "I'm feeling well today!";
    String negative = "I'm feeling very bad today!";


    @Test public void testSentimentInt(){


        sentimentAnalyzer sa = new sentimentAnalyzer();

        int res = sa.getSentimentInt(negative);
        assertEquals(1, res);
    }

    @Test public void testSentimentInt2(){


        sentimentAnalyzer sa = new sentimentAnalyzer();

        int res = sa.getSentimentInt(positive);
        assertEquals(3, res);
    }

    @Test public void testSentimentString(){


        sentimentAnalyzer sa = new sentimentAnalyzer();

        String res = sa.getSentimentString(negative);
        assertEquals("Negative", res);
    }

    @Test public void testSentimentString2(){


        sentimentAnalyzer sa = new sentimentAnalyzer();

        String res = sa.getSentimentString(positive);
        assertEquals("Positive", res);
    }
}
