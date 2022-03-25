package com.pawell.Controlers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandlerBasic implements EventHandler<KeyEvent> {

    BasicLayoutController controller;

    public KeyHandlerBasic(BasicLayoutController controller){
        this.controller = controller;
    }

    @Override
    public void handle(KeyEvent keyEvent) {

        switch (keyEvent.getCode()){
            case NUMPAD0:
            case NUMPAD1:
            case NUMPAD2:
            case NUMPAD3:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9:
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
                getNumberFromKeyboard(keyEvent);
                break;

            case SLASH:
            case DIVIDE:
                controller.div();
                break;

            case MULTIPLY:
            case X:
                controller.mul();
                break;

            case ENTER:
            case EQUALS:
                controller.evaluate();
                break;

            case COMMA:
            case PERIOD:
                controller.addComma();
                break;

            case ADD:
                controller.add();
                break;

            case SUBTRACT:
                controller.changeSign();
                break;

            case MINUS:
                controller.sub();
                break;

            case BACK_SPACE:
                controller.oneDigitRemove();
                break;

            case ESCAPE:
                controller.allClear();
                break;
        }
    }

    private void getNumberFromKeyboard(KeyEvent keyEvent){

        if(controller.getField().getText().equals("0")) controller.getField().setText("");
        if(controller.isOperation()) controller.getField().setText(""); controller.setOperation(false);
        if(keyEvent.getCode() == KeyCode.NUMPAD1 || keyEvent.getCode() == KeyCode.DIGIT1) controller.getField().appendText("1");
        else if(keyEvent.getCode() == KeyCode.NUMPAD2 || keyEvent.getCode() == KeyCode.DIGIT2) controller.getField().appendText("2");
        else if(keyEvent.getCode() == KeyCode.NUMPAD3 || keyEvent.getCode() == KeyCode.DIGIT3) controller.getField().appendText("3");
        else if(keyEvent.getCode() == KeyCode.NUMPAD4 || keyEvent.getCode() == KeyCode.DIGIT4) controller.getField().appendText("4");
        else if(keyEvent.getCode() == KeyCode.NUMPAD5 || keyEvent.getCode() == KeyCode.DIGIT5) controller.getField().appendText("5");
        else if(keyEvent.getCode() == KeyCode.NUMPAD6 || keyEvent.getCode() == KeyCode.DIGIT6) controller.getField().appendText("6");
        else if(keyEvent.getCode() == KeyCode.NUMPAD7 || keyEvent.getCode() == KeyCode.DIGIT7) controller.getField().appendText("7");
        else if(keyEvent.getCode() == KeyCode.NUMPAD8 || keyEvent.getCode() == KeyCode.DIGIT8) controller.getField().appendText("8");
        else if(keyEvent.getCode() == KeyCode.NUMPAD9 || keyEvent.getCode() == KeyCode.DIGIT9) controller.getField().appendText("9");
        else if(keyEvent.getCode() == KeyCode.NUMPAD0 || keyEvent.getCode() == KeyCode.DIGIT0) controller.getField().appendText("0");
    }

}
