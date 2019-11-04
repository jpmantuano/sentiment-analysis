package com.example.demo.sentimentanalysis;

import edu.stanford.nlp.io.IOUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentimentAnalysisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SentimentAnalysisApplication.class, args);
//        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
//
//
//        TweetWithSentiment tweetWithSentiment = sentimentAnalyzer.findSentiment("This movie doesn't care about cleverness, wit or any other kind of intelligent humor.\n" +
//                "Those who find ugly meanings in beautiful things are corrupt without being charming.\n" +
//                "There are slow and repetitive parts, but it has just enough spice to keep it interesting.");
//
//        System.out.println(tweetWithSentiment);


        val content = IOUtils.slurpFile("")

        val dfCounter = loadDfCounter()

        val summarizer = Summarizer(dfCounter)
        val result = summarizer.summarize(content, 2)

        println(result)
    }

}
