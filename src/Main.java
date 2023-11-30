public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO("users.txt");

        // Create
        User user1 = new User(1, "John Doe");
        userDAO.addUser(user1);

        // Read
        System.out.println("Usuario con ID de 1: " + userDAO.getUserById(1));

        // Update
        User updatedUser = new User(1, "nombre actualizado");
        userDAO.updateUser(updatedUser);
        System.out.println("Usuario actualizado: " + userDAO.getUserById(1));

        // Delete 
        userDAO.deleteUser(1); 
        System.out.println("Usuario despues de ser eliminado: " + userDAO.getAllUsers());
    }
}
