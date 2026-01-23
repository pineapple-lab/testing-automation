package Spacelogik;
import InsumosSpacelogik.MethodsSpacelogik;
import InsumosSpacelogik.VariablesSpacelogik;
import Spacelogik.InterfaceProperties;
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;

public class InterfaceActions extends InterfaceProperties {
        VariablesSpacelogik variables = new VariablesSpacelogik();
        enum ExecMethod {
            //HAPPY PATH
            LOGIN_HP,
            CREATERECOMPANIE_HP,
            CREATEOFFICE_HP,
            CREATENATIONALACCOUNT_HP,
            CREATEGURU_HP,
            CREATECLIENT_HP
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
        //HAPPY PATH ACTIONS
        public void actionHpLogin() {
            executeService(new FunctionLoginSpacelogik(), FunctionLoginSpacelogik::serviceLogin);
        }
        public void actionHpCreateReCompanie() {
        executeService(new FunctionReCompanie(), FunctionReCompanie::serviceNewReCompanieHappyPath);
        }
    public void actionHpCreateOffice() {
        executeService(new FunctionOffice(), FunctionOffice::serviceNewOffice);
    }
        public void actionHpCreateNationalAccount() {
        executeService(new FunctionNationalAccount(), FunctionNationalAccount::serviceNewNationalAccount);
        }
        public void actionHpCreateClient() {
        executeService(new FunctionClient(), FunctionClient::serviceNewClient);
        }
        public void actionHpCreateGuru() {
        executeService(new FunctionPeople(), FunctionPeople::serviceNewGuru);
        }
        private <T> void executeService(T serviceInstance, Spacelogik.InterfaceActions.CheckedConsumer<T> action) {
        try {
            action.accept(serviceInstance);
        } catch (Exception e) {
            System.err.println("Hubo un error: " + action.getClass().getName());
            e.printStackTrace();
            }
        }
        // Interfaz funcional para consumidores con excepción
        @FunctionalInterface
        private interface CheckedConsumer<T> {
            void accept(T t) throws Exception;
        }


}
