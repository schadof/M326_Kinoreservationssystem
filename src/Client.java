public class Client {

    private String completeName;
    private String phoneNumber;
    private String eMail;
    private String address;

    public Client(String Name, String Number, String Email, String Address){
        completeName = Name;
        phoneNumber = Number;
        eMail = Email;
        address = Address;
    }

    public String getName(){ return completeName; }
    public String getPhone(){ return phoneNumber; }
    public String getMail(){ return eMail; }
    public String getAddress(){ return address; }
}
