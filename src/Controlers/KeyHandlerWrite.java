package Controlers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandlerWrite implements EventHandler<KeyEvent> {

    WriteModeController controller;

    public KeyHandlerWrite(WriteModeController controller){
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

            case PLUS:
            case ADD:
            case MINUS:
            case SUBTRACT:
            case MULTIPLY:
            case DIVIDE:
            case LEFT_PARENTHESIS:
            case OPEN_BRACKET:
            case RIGHT_PARENTHESIS:
            case CLOSE_BRACKET:
            case CIRCUMFLEX:
                getOperatorFromKeyboard(keyEvent);
                break;

            case ENTER:
            case EQUALS:
                controller.evaluate();
                break;

            case COMMA:
            case PERIOD:
                controller.addComma();
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

        if (controller.isEvaluated()) controller.getField().setText("");
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
        controller.setEvaluated(false);
    }

    private void getOperatorFromKeyboard(KeyEvent keyEvent) {

        if (controller.isEvaluated()) controller.getField().setText("");
        if (keyEvent.getCode() == KeyCode.PLUS || keyEvent.getCode() == KeyCode.ADD)
            controller.getField().appendText("+");
        else if (keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT)
            controller.getField().appendText("-");
        else if (keyEvent.getCode() == KeyCode.MULTIPLY)
            controller.getField().appendText("*");
        else if (keyEvent.getCode() == KeyCode.DIVIDE)
            controller.getField().appendText("/");
        else if (keyEvent.getCode() == KeyCode.LEFT_PARENTHESIS || keyEvent.getCode() == KeyCode.OPEN_BRACKET)
            controller.getField().appendText("(");
        else if (keyEvent.getCode() == KeyCode.RIGHT_PARENTHESIS || keyEvent.getCode() == KeyCode.CLOSE_BRACKET)
            controller.getField().appendText(")");
        else if (keyEvent.getCode() == KeyCode.CIRCUMFLEX)
            controller.getField().appendText("^");
        controller.setEvaluated(false);
    }

}
