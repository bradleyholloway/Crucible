package dev.util;

import java.io.*;
import java.net.URL;
import java.util.HashMap;

public class Config {
    public final URL urlToConfigFile = this.getClass().getResource("/config/init.cfg");

    private static Config instance = null;
    private HashMap<String, String> hash;

    private Config() {
        hash = new HashMap<>();
        InputStream stream;
        try {
            stream = urlToConfigFile.openStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String key = line.substring(0, line.indexOf(' '));
                String value = line.substring(line.indexOf(' ')+1);
                if (!(key.charAt(0)=='#')) {
                    hash.put(key, value);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        return (instance == null) ? createInstance() : instance;
    }

    public int get(String param, int defaults) {
        return Integer.parseInt(hash.getOrDefault(param, Integer.toString(defaults)));
    }

    public String getString(String param, String defaults) {
        return hash.getOrDefault(param, defaults);
    }

    public double getDouble(String param, double defaults) {
        return Double.parseDouble(hash.getOrDefault(param, Double.toString(defaults)));
    }

    private static Config createInstance() {
        instance = new Config();
        return instance;
    }
}
