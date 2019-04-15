package br.com.rk.dot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

/**
 * @author Rhuan Karlus
 * @since 12/04/2019
 */
public class LoginWorker {

    private static final String BUTTON_SUBMIT = "Submit";
    private static final String INPUT_TEXT_PASSWORD = "requiredsenha";
    private static final String INPUT_TEXT_USERNAME = "requiredusuario";
    private static final String SELECT_ONE_COMPANY = "requiredempresa";
    private static final String INDRA_LOGIN_PAGE = "http://52.71.95.168/webpontoindra/";
    private static final String INDRA_BRASIL_VALUE = "1";

    public static WebDriver login() {
        final JPanel panel = new JPanel();
        final JLabel labelPassword = new JLabel("Senha:");
        final JPasswordField tfPassword = new JPasswordField(10);

        panel.add(labelPassword);
        panel.add(tfPassword);

        final String[] options = new String[]{"Entrar", "Cancelar"};
        int option = JOptionPane.showOptionDialog(null, panel, "Login",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (option == 1) {
            System.exit(0);
            return null;
        }

        final WebDriver webDriver = new FirefoxDriver();
        webDriver.get(INDRA_LOGIN_PAGE);
        new Select(webDriver.findElement(By.name(SELECT_ONE_COMPANY))).selectByValue(INDRA_BRASIL_VALUE);
        webDriver.findElement(By.name(INPUT_TEXT_USERNAME)).sendKeys("[INSIRA_SUA_MATRICULA_AQUI]");
        webDriver.findElement(By.name(INPUT_TEXT_PASSWORD)).sendKeys(String.valueOf(tfPassword.getPassword()));
        webDriver.findElement(By.name(BUTTON_SUBMIT)).click();

        return webDriver;
    }

}
