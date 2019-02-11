public class UserData {

    private static int count = 0;
    private int id;
    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String email;

    public UserData(String name, String surname, String address, String telephone, String email) {
        this.id = ++count;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
