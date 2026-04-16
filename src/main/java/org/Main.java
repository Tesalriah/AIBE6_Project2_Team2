package org;

public class Main {
    static void main() {
        AppContext.renew();
        new App().run();
    }
}
