package main;

/**
 * Created by maxim on 18.04.2021.
 */
public class Calculator {

    public double add(double val1, double val2){
        return val1 + val2;
    }

    public double sub(double val1, double val2){
        return val1 - val2;
    }

    public double mult(double val1, double val2){
        return val1 * val2;
    }

    public double div(double val1, double val2){
        return val1 / val2;
    }

    public double calc(double val1, double val2, char operation){
        double result = 0;
        switch (operation) {
            case '+':
                result = add(val1, val2);
                break;
            case '-':
                result = sub(val1, val2);
                break;
            case '*':
                result = mult(val1, val2);
                break;
            case '/':
                result = div(val1, val2);
                break;
        }
        return result;
    }
}
