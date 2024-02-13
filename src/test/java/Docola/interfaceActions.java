package Docola;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
public class interfaceActions extends interfacePositions{
    enum ExecMethod {
        CreateUser,
        validationFirstNameRegister,
        validationLastNameRegister
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
            listaDeEspera.remove(elemento);
            checkBoxesMap.remove(checkBox);
            gridCola.getChildren().remove(checkBox);
        }
    }
   //create actions
    public void actionJoin() {
        functionJoin test = new functionJoin();
        test.validationRegister();
    }
    //validation actions
    public void actionValidationFirstNameRegister() {
        testValidations test = new testValidations();
        test.validationFirstNameRegister();
    }
    public void actionValidationLastNameRegister() {
        testValidations test = new testValidations();
        test.validationLastNameRegister();
    }
}
