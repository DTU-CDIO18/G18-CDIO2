package dk.dtu.CDIOg18.dicegame.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class LanguageProcessor {

    private Locale locale;

    public LanguageProcessor(Locale locale) {
        this.locale = locale;
    }

    /**
     * 
     * @param key
     * @param arguments
     * @return the value based on the key, if no key could be found, an empty string will be returned
     */
    public String getString(LanguageKey key, Object... arguments) {
        return String.format(locale, getValueFromKey(key.getKey()), arguments);
    }

    private String getValueFromKey(String key) {
        String str = "";
        InputStream inputStream = LanguageProcessor.class.getResourceAsStream("/" + locale.getLanguage().toLowerCase() + ".yml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            while ((str = reader.readLine()) != null) {  
                if(extractKey(str).equals(key)) {
                    return extractValue(str);
                }
            }
        } catch (IOException e) {
            
        } finally {
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }

    private static String extractKey(String line) {
        return line.split(":")[0];
    }

    private static String extractValue(String line) {
        return line.split(":")[1].trim();
    } 
}
