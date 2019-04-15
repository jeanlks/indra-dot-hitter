package br.com.rk;

import br.com.rk.dot.DotHitter;
import br.com.rk.dot.LoginWorker;
import br.com.rk.dot.SystemConfigure;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Rhuan Karlus
 * @since 12/04/2019
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        SystemConfigure.configure();
        DotHitter.hitarODot(LoginWorker.login());
        closeDriver();
    }

    private static void closeDriver() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
    }

}
