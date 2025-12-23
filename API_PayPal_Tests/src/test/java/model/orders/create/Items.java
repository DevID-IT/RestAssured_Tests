package model.orders.create;

public class Items {
    private String name;
    private String description;
    private UnitAmount unit_amount;
    private String  quantity;

    public Items(String name, String description, UnitAmount unit_amount, String  quantity) {
        this.name = name;
        this.description = description;
        this.unit_amount = unit_amount;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitAmount getUnit_amount() {return unit_amount;}

    public void setUnit_amount(UnitAmount unit_amount) {this.unit_amount = unit_amount;}

    public String getQuantity() {return quantity;}

    public void setQuantity(String quantity) {this.quantity = quantity;}
}
