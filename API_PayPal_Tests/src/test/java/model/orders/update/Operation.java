package model.orders.update;

public class Operation {
    private String op;
    private String path;
    private AddressValue value;

    public Operation(String op, String path, AddressValue value) {
        this.op = op;
        this.path = path;
        this.value = value;
    }
    public String getOp() {return op;}

    public void setOp(String op) {this.op = op;}

    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}

    public AddressValue getValue() {return value;}

    public void setValue(AddressValue value) {this.value = value;}
}
