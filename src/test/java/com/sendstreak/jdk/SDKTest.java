package com.sendstreak.jdk;

import com.sendstreak.jdk.model.Contact;
import com.sendstreak.jdk.model.Email;
import com.sendstreak.jdk.model.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class SDKTest {
    private SendStreak sendStreak;

    /**
     * Setup method called before each test case.
     */
    @Before
    public void setUp() {
        String server = System.getenv("SENDSTREAK_API_SERVER");
        assertNotNull("SENDSTREAK_API_SERVER environment variable is not set", server);

        String apiKey = System.getenv("SENDSTREAK_API_KEY");
        assertNotNull("SENDSTREAK_API_KEY environment variable is not set", apiKey);

        sendStreak = new SendStreak(apiKey);
        sendStreak.setConfig("server", server);
    }

    /**
     * Test for invalid API key handling.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidKey() {
        new SendStreak("");
    }

    /**
     * Test sending an event with mocked HTTPClient.
     */
    @Test
    public void testSendEvent() throws Exception {
        Event mockEvent = new Event("test@example.com", "test-event");
        sendStreak.sendEvent(mockEvent);
    }

    /**
     * Test sending an email with mocked HTTPClient.
     */
    @Test
    public void testSendMail() throws Exception {
        Email mockEmail = new Email("test@example.com", "email-template-slug");
        mockEmail.getAttributes().putString("name", "Test User");
        mockEmail.getAttributes().putDate("date", new Date());
        mockEmail.getAttributes().putNumber("age", 25);
        mockEmail.getAttributes().putBoolean("isSubscribed", true);

        sendStreak.sendMail(mockEmail);
    }

    /**
     * Test deleting a contact.
     */
    @Test
    public void testDeleteContact() throws Exception {
        Contact mockContact = new Contact("test@example.com");

        sendStreak.deleteContact(mockContact);
    }

    @Test
    public void testUpdateContact() throws Exception {
        Contact mockContact = new Contact("test@example.com");
        mockContact.getAttributes().putString("name", "Test User");
        mockContact.getAttributes().putDate("date", new Date());
        mockContact.getAttributes().putNumber("age", 25);
        mockContact.getAttributes().putBoolean("isSubscribed", true);

        sendStreak.updateContact(mockContact);
    }
}