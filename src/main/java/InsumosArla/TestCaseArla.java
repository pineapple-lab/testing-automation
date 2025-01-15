package InsumosArla;

import InsumosDocola.GeneratorDocola;

public class TestCaseArla extends ContextArla{
    private final GeneratorDocola generate = new GeneratorDocola();
    public void login(){
        System.out.println("El usuario se logeara "+generate.generateExecutions()+" veces\n");
        for (executeCounter = 1; executeCounter <= generate.generateExecutions(); executeCounter++) {
            page.navigate(navigationLink);
            page.fill(SelectorsArla.USERNAME_INPUT,"admin-a");
            page.fill(SelectorsArla.PASSWORD_INPUT, "123123aA.");
            page.click(SelectorsArla.LOGIN_BUTTON);
            page.waitForTimeout(2000000);
        }
        cleanupContext();
    }
}
