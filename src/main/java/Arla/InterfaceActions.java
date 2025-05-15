package Arla;

import Docola.FunctionJoin;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActions extends InterfaceProperties{
    enum ExecMethod {
        //CREATE
        HP_LOGIN_USER,
        HP_UPLOAD_VIDEO,
        HP_CREATE_COURSE,
        HP_CREATE_CATEGORY,
        HP_INVITE_CLIENT
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
    public void actionHpLogin() {
        executeService(new FunctionLogin(), FunctionLogin::serviceLogin);
    }
    public void actionHpUploadVideo() {
        executeService(new FunctionUploadVideo(), FunctionUploadVideo::serviceUploadVideos);
    }
    public void actionHpCreateCourse() {
        executeService(new FunctionCreateCourse(), FunctionCreateCourse::serviceCreateCourse);
    }
    public void actionHpCreateCategory() {
        executeService(new FunctionCreateCategory(), FunctionCreateCategory::serviceCreateCategory);
    }
    public void actionHpInviteClient() {
        executeService(new FunctionInviteClient(), FunctionInviteClient::serviceInviteClients);
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
