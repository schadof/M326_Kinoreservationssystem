public class Client {
    private String fullName;
    private  String phoneNumber;
    private String eMail;
    private String address;
    public void Client(String Name, String Number, String Email, String Address){
        fullName = Name;
        phoneNumber = Number;
        eMail = Email;
        address = Address;
    }

    public String getName(){
        return fullName;
    }
    public String getPhone(){
        return phoneNumber;
    }
    public String getMail(){
        return eMail;
    }
    public String getAddress(){
        return address;
    }
}
