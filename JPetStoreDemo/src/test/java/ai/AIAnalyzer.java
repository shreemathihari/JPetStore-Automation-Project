package ai;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
 
public class AIAnalyzer {
 
    private static final Client client = new Client();
 
    public static void analyze(String errorMessage) {
 
        String prompt = """
                You are an expert Selenium automation tester.
 
                Analyze the following automation error.
 
                Give me:
 
                1. Root cause
                2. Why it happened
                3. Suggested fix
                4. Selenium code example if required
 
                Automation error:
                """ + errorMessage;
 
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.7-flash",
                        prompt,
                        null
                );
 
        System.out.println();
        System.out.println("====================================");
        System.out.println("          AI TEST ANALYSIS");
        System.out.println("====================================");
 
        System.out.println(response.text());
 
        System.out.println("====================================");
    }
 
    public static void main(String[] args) {
 
        String error = """
                TimeoutException:
                Unable to locate the Sign Out element.
 
                The Selenium test was trying to click
                the Sign Out button after login.
                """;
 
        analyze(error);
    }
}
 