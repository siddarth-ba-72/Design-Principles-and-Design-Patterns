package design.principles.open.closed;

public class InterviewQuestionProcessor {
    public static void process(InterviewQuestion question) {
        //this is a typical implementation of the loosely coupled system
        //this class know nothing about the interview question and its type (!!!)
        //THIS  IS PURE ABSTRACTION
        question.execute();
    }
}
