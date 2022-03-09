package com.lesson5;

import java.util.Currency;
interface Timesheet{}
interface Invoice{}
class Money { public Money(double value, Currency currency){} }

interface Payable {
    void pay();
}

abstract class Worker implements Payable {
    private String name;
    public Worker(String name) {
        this.name = name;
    }
    public void pay() {
        Money due = getAmountDue();
    }
    abstract protected Money getAmountDue();
}

class Employee extends Worker {
    private Timesheet[] unpaidTimesheets;
    public Employee(String name) {super(name);}
    public void attachTimesheet(Timesheet i) {}
    protected Money getAmountDue(){
        return  new Money(12.34, Currency.getInstance("USD"));
    }
}

class Contractor extends Worker {
    public Contractor(String name) {super(name);}
    private Invoice[] invoicesDue;
    public void attachInvoice(Invoice i) {}
    protected Money getAmountDue(){
        return  new Money(12.34, Currency.getInstance("USD"));
    }
}

class AccountPayable {
    Payable[] creditors;
    public void PayEveryBody() {
        for (Payable creditor : creditors) {
            creditor.pay();
        }
    }
}
