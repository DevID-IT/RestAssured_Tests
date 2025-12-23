package model.orders.track;

public class TrackOrder {
    String capture_id;
    String tracking_number;
    String carrier;
    String notify_payer;

    public TrackOrder(String capture_id, String tracking_number, String carrier, String notify_payer) {
        this.capture_id = capture_id;
        this.tracking_number = tracking_number;
        this.carrier = carrier;
        this.notify_payer = notify_payer;
    }

    public String getNotify_payer() {return notify_payer;}

    public void setNotify_payer(String notify_payer) {this.notify_payer = notify_payer;}

    public String getCarrier() {return carrier;}

    public void setCarrier(String carrier) {this.carrier = carrier;}

    public String getTracking_number() {return tracking_number;}

    public void setTracking_number(String tracking_number) {this.tracking_number = tracking_number;}

    public String getCapture_id() {return capture_id;}

    public void setCapture_id(String capture_id) {this.capture_id = capture_id;}

}
