package com.example.investimentos;

import java.io.Serializable;

public class Investment implements Serializable {
    private int month;
    private double fees;
    private double deposit;
    private double saves;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getFees() {
        return Math.round(fees);
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getSaves() {
        return Math.round(saves);
    }

    public void setSaves(double saves) {
        this.saves = saves;
    }

    public void addDepositMonth(){
        double aux = this.fees + this.deposit;
        this.saves += aux;
    }
}
