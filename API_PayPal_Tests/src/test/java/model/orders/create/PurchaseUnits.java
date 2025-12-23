package model.orders.create;

import java.util.ArrayList;

public class PurchaseUnits {
    private String reference_id;
    private String invoice_id;
    private Amount amount;
    private ArrayList<Items> items;

    public PurchaseUnits(String reference_id,String invoice_id, Amount amount, ArrayList<Items> items) {
        this.reference_id = reference_id;
        this.invoice_id = invoice_id;
        this.amount = amount;
        this.items = items;
    }

    public String getInvoice_id() {return invoice_id;}

    public void setInvoice_id(String invoice_id) {this.invoice_id = invoice_id;}

    public Amount getAmount() {return amount;}

    public void setAmount(Amount amount) {this.amount = amount;}

    public ArrayList<Items> getItems() {return items;}

    public void setItems(ArrayList<Items> items) {this.items = items;}

    public String getReference_id() {return reference_id;}

    public void setReference_id(String reference_id) {this.reference_id = reference_id;}
}
