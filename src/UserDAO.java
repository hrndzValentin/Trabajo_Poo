import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> userList;
    private String filePath;

    public UserDAO(String filePath) {
        this.filePath = filePath;
        this.userList = readFromFile();
    }

    // Read data 
    private List<User> readFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                users.add(User.fromCsv(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Write data 
    private void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : userList) {
                bw.write(user.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create
    public void addUser(User user) {
        userList.add(user);
        writeToFile();
    }

    // Read
    public User getUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    // Update
    public void updateUser(User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getId() == updatedUser.getId()) {
                userList.set(i, updatedUser);
                writeToFile();
                return;
            }
        }
    }

    // Delete
    public void deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id);
        writeToFile();
    }
}