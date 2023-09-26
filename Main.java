import java.util.ArrayList;
import java.util.List;

// Observer Pattern
class ChatRoom {
    private List<User> users = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void sendMessage(String username, String message) {
        messages.add(username + ": " + message);
        notifyUsers();
    }

    public List<String> getMessages() {
        return messages;
    }

    public List<User> getUsers() {
        return users;
    }

    private void notifyUsers() {
        for (User user : users) {
            user.update(messages);
        }
    }
}

// Observer Pattern
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void sendMessage(ChatRoom chatRoom, String message) {
        chatRoom.sendMessage(username, message);
    }

    public void update(List<String> messages) {
        System.out.println("New messages for user " + username + ":");
        for (String message : messages) {
            System.out.println(message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Singleton Pattern
        ChatRoom chatRoom = new ChatRoom();

        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Add users to the chat room
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        // Send messages
        alice.sendMessage(chatRoom, "Hello, everyone!");
        bob.sendMessage(chatRoom, "How's it going?");
        charlie.sendMessage(chatRoom, "Goodbye!");

        // Display active users and messages
        System.out.println("Active Users: " + chatRoom.getUsers());
        System.out.println("Chat Messages:");
        for (String message : chatRoom.getMessages()) {
            System.out.println(message);
        }
    }
}