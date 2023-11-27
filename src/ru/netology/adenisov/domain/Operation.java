package ru.netology.adenisov.domain;

public class Operation {
    int id;
    int sum;
    String currency;
    String merchant;

    public Operation(){

    }
    public Operation(int id, int sum,  String currency,  String merchant){
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }
    public void print(Operation operation){
        System.out.println("Operation{" +
                "sum=" + sum +
                ", currency=" + "'" + currency + "'" +
                ", merchant=" + "'" + merchant + "'" + "}");
    }

    @Override
    public String toString() {
        return "Operation{" +
                "sum=" + sum +
                ", currency=" + "'" + currency + "'" +
                ", merchant=" + "'" + merchant + "'" + "}";
    }
}
