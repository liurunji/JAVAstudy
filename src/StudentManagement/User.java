package StudentManagement;

public class User {
    private String userName;
    private String password;
    private String IdCard;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String password, String idCard, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        IdCard = idCard;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
