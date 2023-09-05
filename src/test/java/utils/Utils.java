package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static Properties getPropertiesFile () throws IOException {
        FileReader reader = new FileReader("src/test/resources/utils/testData.properties");
        Properties prop = new Properties();
        prop.load(reader);
        return prop;
    }
}
