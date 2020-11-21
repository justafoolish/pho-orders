package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<MeatType> meatTypes = new ArrayList<>();
    List<Topping> toppings = new ArrayList<>();

    DishType type;
    public Order() {}

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public enum DishType {
        SMALL, BIG, SPECIAL
    }

    public void addMeat(MeatType xMeatType) {
        meatTypes.add(xMeatType);
    }
    public List<MeatType> getMeatTypes() {
        return meatTypes;
    }
    public void setMeatTypes(List<MeatType> meatTypes) {
        this.meatTypes = meatTypes;
    }
    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public boolean isTopping() {
        return !toppings.isEmpty();
    }
    public double getPrice() {
        double price = 0;
        switch (this.type) {
            case SMALL: price += 45e3;break;
            case BIG: price+= 60e3;break;
            case SPECIAL: price += 75e3;break;
        }
        for (Topping topping : toppings) {
            price += topping.getPrice();
        }
        return price;
    }
}
