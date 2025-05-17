package project;
public class BotResponder {
	 public static String askGPT(String userInput) {
	        if (userInput == null || userInput.trim().isEmpty()) {
	            return "Please say something!";
	        }

	        userInput = userInput.toLowerCase();

	        if (userInput.contains("hello")) {
	            return "Hi there!";
	        }

	        if (userInput.contains("how are you")) {
	            return "I'm doing great, orbiting the galaxy!";
	        }

	        if (userInput.contains("your name")) {
	            return "I'm SpaceBot, your cosmic companion.";
	        }

	        if (userInput.contains("bye")) {
	            return "Goodbye!  Have a stellar day.";
	        }

	        return "Hmm... I didn't quite understand that. Try asking me something else!";
	    }

	    // Optional main method to test the bot in console
	    public static void main(String[] args) {
	        String[] testInputs = {
	            "Hello",
	            "How are you?",
	            "What's your name?",
	            "Bye",
	            "Tell me a joke"
	        };

	        for (String input : testInputs) {
	            System.out.println("User: " + input);
	            System.out.println("Bot: " + askGPT(input));
	            System.out.println();
	        }
	    }
}
