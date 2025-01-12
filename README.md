# SendStreak Java SDK

[SendStreak](https://www.sendstreak.com) is a simple interface that lets you integrate quickly to email services such as Mailchimp, Sendgrid or even AWS SES or Gmail to decouple your audience, email history and templates from your email provider.

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java **11+** required
- Maven for dependency management

---

### ✅ Installation (Maven)
Add the following to your project's `pom.xml`:

```xml
<dependencies>
    <!-- SendStreak Java SDK -->
    <dependency>
        <groupId>com.sendstreak</groupId>
        <artifactId>sendstreak-jdk</artifactId>
        <version>1.0.0</version>
    </dependency>

</dependencies>
```

---

### ✅ Usage Example

```java
package org.example;

import com.sendstreak.jdk.SendStreak;
import com.sendstreak.jdk.model.Email;

public class App {
    public static void main(String[] args) {
        // Initialize the SDK with your API key
        SendStreak client = new SendStreak("your-api-key-here");

        // Send an email
        Email email = new Email("user@example.com", "email-template-slug");
        email.getAttributes().putString("name", "John");
        client.sendMail(email);

        System.out.println("Email sent successfully!");
    }
}

```

---

## 📦 API Reference

### ✅ **SendStreak Initialization**
```java
SendStreak client = new SendStreak("your-api-key-here");
```

### ✅ **Send an Email**
```java
Email email = new Email("recipient@example.com", "welcome-template");
client.sendMail(email);
```

### ✅ **Send an Event**
```java
Event event = new Event("user_logged_in", "user@example.com");
client.sendEvent(event);
```

### ✅ **Create or Update a Contact**
```java
Contact contact = new Contact("user@example.com");
contact.getAttributes().put("firstName", "John");
client.updateContact(contact);
```

### ✅ **Delete a Contact**
```java
Contact contact = new Contact("user@example.com");
client.deleteContact(contact);
```

---

## 📦 Support

For support or API-related questions, please contact **support@sendstreak.com**.

---

## We accept contributions here

If you're a Java developer using SendStreak and want to contribute to this SDK, we're more than happy to have your pull request here - and your name on the hall of fame forever!

---

### 🚀 **Happy Coding with SendStreak!** 🚀
