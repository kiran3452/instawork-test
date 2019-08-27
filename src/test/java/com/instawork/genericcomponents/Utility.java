package com.instawork.genericcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    public String Read_properties(String sKey) throws IOException {
        FileInputStream fis = new FileInputStream("prod.properties");
        Properties prop= new Properties();

        prop.load(fis);
        return prop.getProperty(sKey);

    }
}
