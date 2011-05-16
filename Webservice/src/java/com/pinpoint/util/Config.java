/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ananti
 */
public class Config {

    private Properties configuration;
    private String configurationFile = "config.ini";

    public Config() {
        configuration = new Properties();
    }

    public boolean load() {
        boolean retval = false;

        try {
            configuration.load(new FileInputStream(this.configurationFile));
            retval = true;
        } catch (IOException e) {
            System.out.println("Configuration error: " + e.getMessage());
        }

        return retval;
    }

    public boolean store() {
        boolean retval = false;

        try {
            configuration.store(new FileOutputStream(this.configurationFile), null);
            retval = true;
        } catch (IOException e) {
            System.out.println("Configuration error: " + e.getMessage());
        }

        return retval;
    }

    public void set(String key, String value) {
        configuration.setProperty(key, value);
    }

    public String get(String key) {
        return configuration.getProperty(key);
    }
}
