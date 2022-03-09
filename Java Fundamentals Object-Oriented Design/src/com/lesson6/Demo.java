package com.lesson6;

interface PaymentObserver {
    public void amPaying(Payable employee);
}

class AccountsPayable implements PaymentObserver {
    private static AccountsPayable instance = new AccountsPayable();
    static AccountsPayable getInstance() {
        return instance;
    }
    public void amPaying(Payable employee) {}
}

interface Payable {
    public void pay();

    public static class Implementation implements Payable {
        private PaymentObserver observer;
        public void addObserver(PaymentObserver observer) {
            this.observer = observer;
        }

        public void pay() {
            observer.amPaying(this);
        }
    }
}

class Peon extends Payable.Implementation {}

public class Demo {
    public static void main(String[] args) {
        AccountsPayable accounting = new AccountsPayable();
        Peon worker = new Peon();

        worker.addObserver(accounting);
        worker.pay();
    }
}