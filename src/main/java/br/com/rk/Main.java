package br.com.rk;

import br.com.rk.dot.DotHitter;
import br.com.rk.dot.LoginWorker;
import br.com.rk.dot.SystemConfigure;
import org.apache.commons.lang3.SystemUtils;

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
        if (SystemUtils.IS_OS_WINDOWS) {
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        } else if (SystemUtils.IS_OS_LINUX) {
            Runtime.getRuntime().exec("pkill -f geckodriver");
        }
        // todo: handle mac
    }

}
