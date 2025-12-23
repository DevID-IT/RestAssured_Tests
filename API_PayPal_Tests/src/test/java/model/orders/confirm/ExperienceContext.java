package model.orders.confirm;

public class ExperienceContext {
    private String brand_name;
    private String return_url;
    private String cancel_url;

    public ExperienceContext(String brand_name, String return_url, String cancel_url) {
        this.brand_name = brand_name;
        this.return_url = return_url;
        this.cancel_url = cancel_url;
    }

    public String getBrand_name() {return brand_name;}

    public void setBrand_name(String brand_name) {this.brand_name = brand_name;}

    public String getReturn_url() {return return_url;}

    public void setReturn_url(String return_url) {this.return_url = return_url;}

    public String getCancel_url() {return cancel_url;}

    public void setCancel_url(String cancel_url) {this.cancel_url = cancel_url;}
}
