public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

        public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }

    public String toCsv() {
        return id + "," + name;
    }

    public static User fromCsv(String csv) {
        String[] fields = csv.split(",");
        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        return new User(id, name);
    }
}