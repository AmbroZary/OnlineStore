package client.domain.Aggregates.UserAggregate;

public class User extends Client {
    private String password;
    private ClientAddress address;

    public User(int id, Cart cart, String password, ClientAddress address) {
        super(id, cart);
        this.password = password;
        this.address = address;
    }

    public User(int id, String password, ClientAddress address) {
        super(id);
        this.password = password;
        this.address = address;
    }

    public User(Cart cart, String password, ClientAddress address) {
        super(cart);
        this.password = password;
        this.address = address;
    }

    public User(String password, ClientAddress address) {
        super();
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientAddress getAddress() {
        return address;
    }

    public void setAddress(ClientAddress address) {
        this.address = address;
    }
}
