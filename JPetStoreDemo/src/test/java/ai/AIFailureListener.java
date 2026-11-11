package ai;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseFinished;
 
public class AIFailureListener implements EventListener {
 
    private final EventHandler<TestCaseFinished> testCaseFinishedHandler =
            event -> {
 
                if (event.getResult().getError() != null) {
 
                    Throwable error = event.getResult().getError();
 
                    System.out.println();
                    System.out.println("====================================");
                    System.out.println("       TEST FAILED - AI ANALYSIS");
                    System.out.println("====================================");
 
                    System.out.println("Scenario: "
                            + event.getTestCase().getName());
 
                    System.out.println("Error: "
                            + error);
 
                    // Send the REAL error to Gemini
                    AIAnalyzer.analyze(error.toString());
 
                    System.out.println("====================================");
                }
            };
    @Override
    public void setEventPublisher(EventPublisher publisher) {
 
        publisher.registerHandlerFor(
                TestCaseFinished.class,
                testCaseFinishedHandler
        );
    }
}
