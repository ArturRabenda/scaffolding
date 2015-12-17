package io.realskill.tasks;


public class ATM {

    private ATMCentral connection;

    public ATM(ATMCentral central) {
        connection = central;
    }

    public Double withdraw(double cardNo, int pin, double amount) {
        if (!connection.connect()) {
            throw new IllegalStateException();
        }

        Double withdrawal = connection.withdraw(cardNo, pin, amount);
        connection.disconnect();
        return withdrawal;
    }

    public Double deposit(double cardNo, double amount) {
        if (!connection.connect()) {
            throw new IllegalStateException();
        }

        Double deposit = connection.deposit(cardNo, amount);
        connection.disconnect();
        return deposit;
    }

    public Double currentStatus(double cardNo, int pin) {
        if (!connection.connect()) {
            throw new IllegalStateException();
        }

        Double status = connection.currentStatus(cardNo, pin);
        connection.disconnect();
        return status;
    }

}
