package model.orders.confirm;

public class PaymentSource {
    private MyBank mybank;
    private String email_address;

    public PaymentSource(MyBank mybank, String email_address) {
        this.mybank = mybank;
        this.email_address = email_address;
    }

    public String getEmail_address() {return email_address;}

    public void setEmail_address(String email_address) {this.email_address = email_address;}

    public MyBank getMybank() {return mybank;}

    public void setMybank(MyBank mybank) {this.mybank = mybank;}
}
