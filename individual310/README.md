# 310 Individual Project

### Documentation from individual iteration
Chatbot Methods:

askWiki(Scanner in): Asks the user if there's anything from the conversation they would like to look up.

askTranslate(Scanner in): Asks the user if there's anything from the conversation they would like to translate.

getLanguageCode(String language): Switch statement method to convert language names (e.g. English, Chinese) into language codes (e.g. en, zh-CH) recognizable by the translation API.

### Documentation from last group iteration
This system is meant as a chatbot that helps people learn english, it will ask the users questions and expects the users to understand and answer the questions.

Our chatbot code contains two folders Chatbot, init: Chatbot: contains all the methods used to ask and check the answers from the user init: used to initialize the chatbot

Chatbot Methods:

Chatbot(): This method contains all the questions the users will be asked

randomQuestion(): this method returns an unasked question to the users and if all questions arr returns "Oops, I ran out of questions!"

answerList(): this method takes every question and provides a set of valid answers to the question, and if the answer is not in the set of answers it tells the user the it doesn't know.

endConversation(): Closes the session and prints a goodbye message

POSTagger Methods:

POSTagger(): Initializes pipeline to CoreNLP

tag(): takes a string and returns the nouns in the string
