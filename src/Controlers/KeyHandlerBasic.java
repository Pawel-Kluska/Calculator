package Controlers;

import javafx.event.EventHandler;
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
                controller.getNumberFromKeyboard(keyEvent);
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
                controller.comma();
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
                controller.aclear();
                break;
        }
    }
}
