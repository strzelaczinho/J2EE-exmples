public class Baza {

    private static int count = 0;
    private int id;
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private String email;

    public Baza(String imie, String nazwisko, String adres, String telefon, String email) {
        this.id = ++count;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;
        this.email = email;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

}
