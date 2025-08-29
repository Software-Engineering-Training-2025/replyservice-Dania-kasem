package org.example;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public class ReplyService {
    public enum ReplyType { FORMAL, FRIENDLY, CONCISE }

    private static final Map<String, String[]> RESPONSES=new HashMap<>();
    static {
        RESPONSES.put("hi",new String[]{
                "Hello. How may I assist you today?",
                "Hey there! 😊 How can I help?",
                "Hello. How can I help?"
        });
        RESPONSES.put("hello",new String[]{
                "Hello. How may I assist you today?",
                "Hi! 👋 What’s up?",
                "Hello. How can I help?"
        });
        RESPONSES.put("how are you",new String[]{
                "I am functioning properly. How may I assist you?",
                "Doing great! 😄 How can I help?",
                "I’m good. How can I help?"
        });

        RESPONSES.put("i need help",new String[]{
                "I can assist with that. Please provide more details.",
                "I’ve got you! 🙂 Tell me a bit more.",
                "Share details; I’ll help."
        });

        RESPONSES.put("can you help me with my account",new String[]{
                "Certainly. Please describe the account issue.",
                "Sure thing! 😊 What’s wrong with the account?",
                "Describe the account issue…"
        });

        RESPONSES.put("thanks",new String[]{
                "You are welcome.",
                "Anytime! 🙌",
                "You’re welcome."
        });

        RESPONSES.put("bye",new String[]{
                "Goodbye.",
                "See you later! 👋",
                "Goodbye."
        });

        RESPONSES.put("what is your name",new String[]{
                "I am your virtual assistant.",
                "I’m your helper bot 🤖",
                "I’m your assistant."
        });

        RESPONSES.put("default",new String[]{
                "Could you clarify your request?",
                "Could you tell me more?",
                "Please clarify."
        });
    }

    public String reply(String message, ReplyType type) {
        if (message==null || message.trim().isEmpty()) {
            return "Please say something.";
        }
        String normalized = message.trim().toLowerCase(Locale.ROOT);
        String[] responses = RESPONSES.getOrDefault(normalized, RESPONSES.get("default"));

        int index;
        switch (type) {
            case FORMAL: index=0;break;
            case FRIENDLY: index=1;break;
            case CONCISE: index=2;break;
            default:throw new IllegalArgumentException("Unknown reply type");
        }
        return responses[index];
    }
}
