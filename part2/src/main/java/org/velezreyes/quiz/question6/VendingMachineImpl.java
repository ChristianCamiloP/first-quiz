package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {
    private int currentMoney;
    private Map<String, Drink> drinks;

    public VendingMachineImpl() {
        this.currentMoney = 0;
        this.drinks = new HashMap<>();
        drinks.put("ScottCola", new DrinkImpl("ScottCola", true));
        drinks.put("KarenTea", new DrinkImpl("KarenTea", false));
    }

    public static VendingMachine getInstance() {
        return new VendingMachineImpl();
    }

    @Override
    public void insertQuarter() {
        currentMoney += 25;
    }

    @Override
    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
        if (drinks.containsKey(name)) {
            Drink drink = drinks.get(name);
            if (currentMoney >= 75) {
                currentMoney -= 75;
                return drink;
            } else {
                throw new NotEnoughMoneyException();
            }
        } else {
            throw new UnknownDrinkException();
        }
    }
}
