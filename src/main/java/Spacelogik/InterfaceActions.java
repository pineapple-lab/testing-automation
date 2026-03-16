package Spacelogik;
import Arla.TestErrorMessageValidations;
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
            CREATECLIENT_HP,
            CREATELOCATION_HP,
            CREATEPROGRAM_HP,

            //TEST CASE ERROR MESSAGE VALIDATION
            RECOMPANIE_VALIDATION_EMPTYMESSAGE,
            NATIONALACCOUNT_VALIDATION_EMPTYMESSAGE,
            SEARCH_VALIDATION,

            //SWEET TEST CASE
            EXECUTE_SWEET_NEW_PROGRAMS,
            EXECUTE_SWEET_NEW_RECOMPANIE,
            EXECUTE_SWEET_NEW_GURU
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
        public void actionHpLogin() {executeService(new FunctionLoginSpacelogik(), FunctionLoginSpacelogik::serviceLogin);}
        public void actionHpCreateReCompanie() {executeService(new FunctionReCompanie(), FunctionReCompanie::serviceNewReCompanieHappyPath);}
        public void actionHpCreateOffice() {executeService(new FunctionOffice(), FunctionOffice::serviceNewOffice);}
        public void actionHpCreateNationalAccount() {executeService(new FunctionNationalAccount(), FunctionNationalAccount::serviceNewNationalAccount);}
        public void actionHpCreateClient() {executeService(new FunctionClient(), FunctionClient::serviceNewClient);}
        public void actionHpCreateGuru() {executeService(new FunctionPeople(), FunctionPeople::serviceNewGuru);}
        public void actionHpCreateLocation(){executeService(new FunctionLocations(), FunctionLocations::serviceNewLocation);}
        public void actionHpCreateProgram() { executeService(new FunctionPrograms(), FunctionPrograms::serviceNewProgram); }
        public void actionSearchValidation() { executeService(new FunctionSearch(), FunctionSearch::serviceBuildingsInfoValidations); }
        //RECOMPANIE TEST CASE VALIDATION ERROR MESSAGE
        public void actionAssertReCompanieFormEmptyInputs() {executeService(new FunctionReCompanie(), FunctionReCompanie::serviceAssertReCompanieFormMessageEmptyInputs);}
        public void actionAssertNationalAccountFormEmptyInputs() {executeService(new FunctionNationalAccount(), FunctionNationalAccount::serviceAssertNationalAccountFormMessageEmptyInputs);}
        //SWEET TEST CASE
        public void actionExecuteSweetCaseNewProgram() { executeService(new FunctionPrograms(), FunctionPrograms::serviceProgramSweetExecute); }
        public void actionExecuteSweetCaseNewReCompanie() {executeService(new FunctionReCompanie(), FunctionReCompanie::serviceReCompanieSweetExecute);}
        public void actionExecuteSweetCaseNewGuru() {executeService(new FunctionPeople(), FunctionPeople::serviceNewGuruSweetExecute);}
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
