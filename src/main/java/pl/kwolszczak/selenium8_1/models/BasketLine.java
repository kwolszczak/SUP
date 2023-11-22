package pl.kwolszczak.selenium8_1.models;

public class BasketLine {
    private Product product;
    private double totalPrice;
    private int quantity;

    public BasketLine(Product product, int quantity) {
        this.product = product;
        this.totalPrice = quantity * product.getPrice();
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
