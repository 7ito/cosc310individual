package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class POSTest {
    
    @Test
    public void testTag1() {
        POSTagger tagger = new POSTagger();

        String toTag = "I use Instagram";
        String tagged = tagger.tag(toTag);

        assertEquals("Instagram", tagged);
    }

    public void testTag2() {
        POSTagger tagger = new POSTagger();

        String toTag = "I read Harry Potter";
        String tagged = tagger.tag(toTag);

        assertEquals("I read Harry Potter", tagged);
    }

    public void testTag3() {
        POSTagger tagger = new POSTagger();

        String toTag = "I am a cat person";
        String tagged = tagger.tag(toTag);

        assertEquals("cat", tagged);
    }

}
