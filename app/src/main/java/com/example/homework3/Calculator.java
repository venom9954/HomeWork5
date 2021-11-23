package com.example.homework3;

public class Calculator {
    private int firstArg;
    private int secondArg;

    private  StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        operationSelected,
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator() {
        state = State.firstArgInput;
    }

    public void onNumPressed (int buttonsId){

    if (state == State.resultShow){
        state = State.firstArgInput;
        inputStr.setLength(0);
    }

    if (state == State.operationSelected) {
        state = State.secondArgInput;
        inputStr.setLength(0);
    }

    if (inputStr.length() < 9){
        switch (buttonsId) {
            case R.id.button_0:
                if (inputStr.length() != 0){
                    inputStr.append("0");
                }
                break;
            case R.id.button_1:
                    inputStr.append("1");
                break;
            case R.id.button_2:
                inputStr.append("2");
                break;
            case R.id.button_3:
                inputStr.append("3");
                break;
            case R.id.button_4:
                inputStr.append("4");
                break;
            case R.id.button_5:
                inputStr.append("5");
                break;
            case R.id.button_6:
                inputStr.append("6");
                break;
            case R.id.button_7:
                inputStr.append("7");
                break;
            case R.id.button_8:
                inputStr.append("8");
                break;
            case R.id.button_9:
                inputStr.append("9");
                break;
        }
    }
    }

    public void onActionPressed (int otherId){
        if(otherId == R.id.button_equal && state == State.secondArgInput) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected){
                case R.id.button_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.button_minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.button_multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.button_divide:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.button_equal:
                    actionSelected = R.id.button_equal;
                    break;
                case R.id.button_AC:
                    actionSelected = R.id.button_AC;
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
        firstArg = Integer.parseInt(inputStr.toString());
        state = State.secondArgInput;
        inputStr.setLength(0);
        switch (otherId) {
            case R.id.button_plus:
                actionSelected = R.id.button_plus;
                break;
            case R.id.button_minus:
                actionSelected = R.id.button_minus;
                break;
            case R.id.button_multiply:
                actionSelected = R.id.button_multiply;
                break;
            case R.id.button_divide:
                actionSelected = R.id.button_divide;
                break;
            case R.id.button_equal:
                actionSelected = R.id.button_equal;
                break;
            case R.id.button_AC:
                actionSelected = R.id.button_AC;
                break;
        }
        }
    }
    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }
    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.button_plus:
                return '+';
            case R.id.button_minus:
                return '-';
            case R.id.button_multiply:
                return '*';
            case R.id.button_divide:
            default:
                return '/';

        }
    }
    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }
}
