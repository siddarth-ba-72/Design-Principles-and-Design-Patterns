package design.principles.open.closed;

public class OCPMain {
    public static void main(String[] args) {

        InterviewQuestionProcessor.process(new FinanceInterviewQuestion());
        InterviewQuestionProcessor.process(new AiInterviewQuestion());
        InterviewQuestionProcessor.process(new AlgorithmsInterviewQuestion());

    }
}
