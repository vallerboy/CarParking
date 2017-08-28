package pl.oskarpolak;

/**
 * Created by Lenovo on 28.08.2017.
 */
public class App {
    public static void main(String[] args) {
       new App();
    }

    Connector connector = Connector.getInstance();

    public App() {

    }

    private String register(String name, String password, String email, String number, String lastname) {

        return "Udało się zarejestrować";
    }
}

