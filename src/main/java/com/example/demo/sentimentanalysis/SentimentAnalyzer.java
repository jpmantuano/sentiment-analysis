package com.example.demo.sentimentanalysis;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class SentimentAnalyzer {
    public TweetWithSentiment findSentiment(String line) {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int mainSentiment = 0;
        if (line != null && line.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(line);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }
        }
//        if (mainSentiment == 2 || mainSentiment > 4 || mainSentiment < 0) {
//            return null;
//        }
        TweetWithSentiment tweetWithSentiment = new TweetWithSentiment(line, String.valueOf(mainSentiment));
        return tweetWithSentiment;

    }

    private String toCss(int sentiment) {
        switch (sentiment) {
            case 0:
                return "alert alert-danger";
            case 1:
                return "alert alert-danger";
            case 2:
                return "alert alert-warning";
            case 3:
                return "alert alert-success";
            case 4:
                return "alert alert-success";
            default:
                return "";
        }
    }

}
