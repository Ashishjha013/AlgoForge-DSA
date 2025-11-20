// Pizza ordering billing system (OOPs Concept - Pillars of OOPs)
// Question: we have 2 pizza normal pizza and delux pizza
// normal pizza have base price of 300 and delux pizza have base price of 500
// you can add extra cheese for veg 50 for non-veg 80 and extra topping for veg 70 and non-veg 100
// use basic logic

import java.util.Scanner;
class Pizza {
    protected int basePrice;
    protected int extraCheesePrice;
    protected int extraToppingPrice;
    protected boolean isVeg;
    protected int totalPrice;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        if (isVeg) {
            this.basePrice = 300;
            this.extraCheesePrice = 50;
            this.extraToppingPrice = 70;
        } else {
            this.basePrice = 500;
            this.extraCheesePrice = 80;
            this.extraToppingPrice = 100;
        }
        this.totalPrice = basePrice;
    }
}