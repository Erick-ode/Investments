package com.example.investimentos;

import java.io.Serializable;

public class Investment implements Serializable {
    private int month = 1;
    private double fees;
    private double deposit;
    private double saves;

    public int getMonth() {
        return month;
    }

    public void setMonth() {
        this.month++;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees / 100;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getSaves() {
        return saves;
    }

    public void setSaves(double saves) {
        this.saves = saves;
    }

    public void addDepositMonth(){
        double aux = this.saves * this.fees + this.deposit;
        this.saves += aux;
    }
}
