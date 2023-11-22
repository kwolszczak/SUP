package pl.kwolszczak.selenium8_1.models;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketLine> products;
    private double totalPrice;

    public Basket() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addProduct(Product product, int quantity) {

        //if in the cart - update quantity
        //if not -add

        //update total price
        //tutaj do sprawdZena nie == product tylko wartosci produktu  nazwa, cena, kolor ... bo moze byc 100 setki identycznych produktow ????
        for (var line : products) {
            if (line.getProduct() == product) {
                line.setQuantity(line.getQuantity()+quantity);

            } else {
                BasketLine cartLine = new BasketLine(product, quantity );
                products.add(cartLine);
            }
        }

    }
}
