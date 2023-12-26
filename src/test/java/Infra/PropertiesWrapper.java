package Infra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWrapper {

    private final String propPath = "src/test/java/config.properties";
    private Properties prop ;
    public PropertiesWrapper() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(propPath);
            prop.load(ip);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public String getProperties(String key){
        return (String)prop.get(key);
    }

    public void setProprieties(String key, String value){
        prop.setProperty(key, value);
        try (FileOutputStream fileOutputStream = new FileOutputStream(propPath)) {
            prop.store(fileOutputStream, "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
