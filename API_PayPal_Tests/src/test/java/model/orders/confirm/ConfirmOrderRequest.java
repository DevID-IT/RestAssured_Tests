package model.orders.confirm;

public class ConfirmOrderRequest {
    private PaymentSource payment_source;

    public ConfirmOrderRequest(PaymentSource payment_source){
        this.payment_source = payment_source;
    }

    public PaymentSource getPayment_source() {return payment_source;}

    public void setPayment_source(PaymentSource payment_source) {this.payment_source = payment_source;}
}
