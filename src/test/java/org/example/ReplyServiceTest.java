package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.ReplyService.ReplyType;

class ReplyServiceTest {

    private final ReplyService service = new ReplyService();

    // ===== Helpers =====
    private void assertReply(String expected, String input, ReplyType type) {
        assertEquals(expected, service.reply(input, type),
                () -> "Input=[" + input + "], Type=" + type);
    }

    // ===== FORMAL =====
    @Test
    void formal_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyType.FORMAL);
        assertReply("Please say something.", "", ReplyType.FORMAL);
        assertReply("Please say something.", "   \t  ", ReplyType.FORMAL);

        // Canonical inputs
        assertReply("Hello. How may I assist you today?", "hi", ReplyType.FORMAL);
        assertReply("Hello. How may I assist you today?", "hello", ReplyType.FORMAL);
        assertReply("I am functioning properly. How may I assist you?", "how are you", ReplyType.FORMAL);
        assertReply("I can assist with that. Please provide more details.", "i need help", ReplyType.FORMAL);
        assertReply("Certainly. Please describe the account issue.", "can you help me with my account", ReplyType.FORMAL);
        assertReply("You are welcome.", "thanks", ReplyType.FORMAL);
        assertReply("Goodbye.", "bye", ReplyType.FORMAL);
        assertReply("I am your virtual assistant.", "what is your name", ReplyType.FORMAL);

        // Any other text
        assertReply("Could you clarify your request?", "what time is it", ReplyType.FORMAL);
    }

    // ===== FRIENDLY =====
    @Test
    void friendly_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyType.FRIENDLY);
        assertReply("Please say something.", "", ReplyType.FRIENDLY);
        assertReply("Please say something.", "   \t  ", ReplyType.FRIENDLY);

        // Canonical inputs
        assertReply("Hey there! 😊 How can I help?", "hi", ReplyType.FRIENDLY);
        assertReply("Hi! 👋 What’s up?", "hello", ReplyType.FRIENDLY);
        assertReply("Doing great! 😄 How can I help?", "how are you", ReplyType.FRIENDLY);
        assertReply("I’ve got you! 🙂 Tell me a bit more.", "i need help", ReplyType.FRIENDLY);
        assertReply("Sure thing! 😊 What’s wrong with the account?", "can you help me with my account", ReplyType.FRIENDLY);
        assertReply("Anytime! 🙌", "thanks", ReplyType.FRIENDLY);
        assertReply("See you later! 👋", "bye", ReplyType.FRIENDLY);
        assertReply("I’m your helper bot 🤖", "what is your name", ReplyType.FRIENDLY);

        // Any other text
        assertReply("Could you tell me more?", "what time is it", ReplyType.FRIENDLY);
    }

    // ===== CONCISE =====
    @Test
    void concise_canonical_messages() {
        // Null / blank
        assertReply("Please say something.", null, ReplyType.CONCISE);
        assertReply("Please say something.", "", ReplyType.CONCISE);
        assertReply("Please say something.", "   \t  ", ReplyType.CONCISE);

        // Canonical inputs
        assertReply("Hello. How can I help?", "hi", ReplyType.CONCISE);
        assertReply("Hello. How can I help?", "hello", ReplyType.CONCISE);
        assertReply("I’m good. How can I help?", "how are you", ReplyType.CONCISE);
        assertReply("Share details; I’ll help.", "i need help", ReplyType.CONCISE);
        assertReply("Describe the account issue…", "can you help me with my account", ReplyType.CONCISE);
        assertReply("You’re welcome.", "thanks", ReplyType.CONCISE);
        assertReply("Goodbye.", "bye", ReplyType.CONCISE);
        assertReply("I’m your assistant.", "what is your name", ReplyType.CONCISE);

        // Any other text
        assertReply("Please clarify.", "what time is it", ReplyType.CONCISE);
    }
}
