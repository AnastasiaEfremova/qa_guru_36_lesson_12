package tests.propertiesTests;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser", "mozilla");
        String version = System.getProperty("version", "142.0.1");
    }

}
