package com.linkedin.javacodechallenges;

public class TicketHolder {
    
    private String name;
    private int quantity;
    
    public TicketHolder(String name, int quantity) {
      this.name = name;
      this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void printAllowMessage() {
        System.out.println(this.name + " purchased " + this.quantity + " ticket(s), allow to enter.");
    }

    public void printNotAllowMessage() {
        System.out.println(this.name + " did not purchase any ticket, not allow to enter.");
    }
}
