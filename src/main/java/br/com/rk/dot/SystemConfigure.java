package br.com.rk.dot;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.net.URISyntaxException;

/**
 * @author Rhuan Karlus
 * @since 12/04/2019
 */
public class SystemConfigure {

    private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static final String GECKO_DRIVER = "geckodriver";
    private static final String WINDOWS_EXTENSIONS = ".exe";

    public static void configure() throws URISyntaxException {
        final String geckoDriverPath = new File(SystemConfigure.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI().getPath()).getParent()
                + File.separator
                + (SystemUtils.IS_OS_WINDOWS ? GECKO_DRIVER + WINDOWS_EXTENSIONS : GECKO_DRIVER);

        System.setProperty(GECKO_DRIVER_PROPERTY, geckoDriverPath);
    }


}
