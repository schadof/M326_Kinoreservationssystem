public class Client {

    String completeName;
    String phoneNumber;
    String eMail;
    String address;

    public Client(String Name, String Number, String Email, String Address){
        completeName = Name;
        phoneNumber = Number;
        eMail = Email;
        address = Address;
    }

    public String getName(){
        return completeName;
    }
    public String getPhone(){ return phoneNumber; }
    public String getMail(){
        return eMail;
    }
    public String getAddress(){
        return address;
    }
}
