package org;

import org.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        Scanner scanner = TestUtil.genScanner(input + "\nexit");

        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        AppContext.renew(scanner);
        new App().run();

        System.out.println("output = " + output);

        return output.toString();
    }
}
