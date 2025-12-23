package model.orders.create;

public class Breakdown {
    private ItemTotal item_total;
    private Shipping shipping;

    public Breakdown(ItemTotal item_total, Shipping shipping) {
        this.item_total = item_total;
        this.shipping = shipping;
    }

    public ItemTotal getItem_total() {return item_total;}

    public void setItem_total(ItemTotal item_total) {this.item_total = item_total;}

    public Shipping getShipping() {return shipping;}

    public void setShipping(Shipping shipping) {this.shipping = shipping;}
}
