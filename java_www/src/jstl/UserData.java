package jstl;

public class UserData {
    private int id;
    private static int lastId;
    private String name, surname;
    private String address;
    private String phone, email;

    public UserData(String name, String surname, String address, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = lastId++;
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
