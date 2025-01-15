package Arla;

import Docola.FunctionJoin;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActions extends InterfaceProperties{
    enum ExecMethod {
        //CREATE
        LOGIN_USER,
    }
    public void actionEliminarDeLaCola() {
        List<CheckBox> checkBoxesSeleccionados = new ArrayList<>();
        for (CheckBox checkBox : checkBoxesMap.keySet()) {
            if (checkBox.isSelected()) {
                checkBoxesSeleccionados.add(checkBox);
            }
        }
        for (CheckBox checkBox : checkBoxesSeleccionados) {
            Enum elemento = checkBoxesMap.get(checkBox);
            waitingList.remove(elemento);
            checkBoxesMap.remove(checkBox);
            gridCola.getChildren().remove(checkBox);
        }
    }
    //create actions
    public void actionLogin() {
        executeService(new FunctionLogin(), FunctionLogin::serviceLogin);
    }
    private <T> void executeService(T serviceInstance, Arla.InterfaceActions.CheckedConsumer<T> action) {
        try {
            action.accept(serviceInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Interfaz funcional para consumidores con excepción
    @FunctionalInterface
    private interface CheckedConsumer<T> {
        void accept(T t) throws Exception;
    }
}
