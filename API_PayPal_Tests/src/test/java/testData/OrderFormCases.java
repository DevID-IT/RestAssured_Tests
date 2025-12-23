package testData;

import model.orders.create.*;

import java.util.ArrayList;

public class OrderFormCases {
    public static Orders validOrder() {
        ItemTotal itemTotal = new ItemTotal("EUR", "450");
        Shipping shipping = new Shipping("EUR", "49");
        Breakdown breakdown = new Breakdown(itemTotal, shipping);
        Amount amount = new Amount("EUR", "499", breakdown);
        UnitAmount unit_amount = new UnitAmount("EUR", "450");

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items("T-shirt A", "Nowa koszulka", unit_amount, "1"));
        ArrayList<PurchaseUnits> purchase_units = new ArrayList<>();
        purchase_units.add(new PurchaseUnits("A001","test_invoice_id",amount, items));
        return new Orders("CAPTURE", purchase_units);
    }
    public static Orders invalidOrderItemTotal() {
        ItemTotal itemTotal = new ItemTotal("USD", "450");
        Shipping shipping = new Shipping("USD", "49");
        Breakdown breakdown = new Breakdown(itemTotal, shipping);
        Amount amount = new Amount("USD", "499", breakdown);
        UnitAmount unit_amount = new UnitAmount("USD", "450");

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items("T-shirt B", "Nowa koszulka", unit_amount, "2"));
        ArrayList<PurchaseUnits> purchase_units = new ArrayList<>();
        purchase_units.add(new PurchaseUnits("A002","test_invoice_id",amount, items));
        return new Orders("CAPTURE", purchase_units);
    }
    public static Orders invalidOrderAmount() {
        ItemTotal itemTotal = new ItemTotal("USD", "450");
        Shipping shipping = new Shipping("USD", "49");
        Breakdown breakdown = new Breakdown(itemTotal, shipping);
        Amount amount = new Amount("USD", "450", breakdown);
        UnitAmount unit_amount = new UnitAmount("USD", "450");

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items("T-shirt C", "Nowa koszulka", unit_amount, "1"));
        ArrayList<PurchaseUnits> purchase_units = new ArrayList<>();
        purchase_units.add(new PurchaseUnits("A003","test_invoice_id",amount, items));
        return new Orders("CAPTURE", purchase_units);
    }
    public static Orders invalidOrderShipping() {
        ItemTotal itemTotal = new ItemTotal("USD", "450");
        Shipping shipping = new Shipping("USD", "9");
        Breakdown breakdown = new Breakdown(itemTotal, shipping);
        Amount amount = new Amount("USD", "499", breakdown);
        UnitAmount unit_amount = new UnitAmount("USD", "450");

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items("T-shirt D", "Nowa koszulka", unit_amount, "1"));
        ArrayList<PurchaseUnits> purchase_units = new ArrayList<>();
        purchase_units.add(new PurchaseUnits("A004","test_invoice_id",amount, items));
        return new Orders("CAPTURE", purchase_units);
    }
}
