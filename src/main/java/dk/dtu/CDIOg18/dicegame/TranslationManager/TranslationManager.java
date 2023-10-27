package dk.dtu.CDIOg18.dicegame.TranslationManager;

import java.io.File;
import java.io.IOException;

import com.moandjiezana.toml.Toml;

public class TranslationManager {
    private Toml toml;
    /**
     * Used for throwing exception, and possibly other things in the future idk
     */
    private String filename; 

    public TranslationManager(String filePath) {
        File tomlFile = new File(filePath);
        this.toml = new Toml().read(tomlFile);

        try {
            this.filename = tomlFile.getCanonicalPath();
        } catch (IOException e) {};
    }

    public TranslationManager(File langFile) {
        this.toml = new Toml().read(langFile);
        
        try {
            this.filename = langFile.getCanonicalPath();
        } catch (IOException e) {}
    }


    public String get(TranslationId translationId) {
        return this.toml.getString(translationId.id());
    }

    public String get(String translationId) {
        return this.toml.getString(translationId);
    }

    /**
     * Formats the translation string for the given translation ID with the provided arguments.
     *
     * @param translationId the ID of the translation string to format
     * @param args the arguments to use when formatting the translation string (read documentations, sorry i tried to make it easy :( )
     * @return the formatted translation string
     */
    public String format(TranslationId translationId, Object... args) {
        String translationString = this.get(translationId);

        if (translationString == null) {
            throw new IllegalArgumentException(
                                               String.format("Translation not found for ID '%s' in file '%s'",
                                                             translationId.id(),
                                                             this.filename
                                                             )
                                               );
        }

        String formattedOutput = String.format(translationString, args);
        return formattedOutput;
    }

    public void println(TranslationId translationId, Object... args) {
        String translationStringFormatted = this.format(translationId, args);

        System.out.println(translationStringFormatted);
    }

    public void print(TranslationId translationId, Object... args) {
        String translationStringFormatted = this.format(translationId, args);

        System.out.print(translationStringFormatted);
    }

    /**
     * Method used for testing and debugging the LanguageManager class.
     * TODO: Remove before merging into dev
     */
    public static void main(String[] args) {
        TranslationManager lcfg = new TranslationManager("./resources/lang/dk.toml");

        System.out.println(lcfg.get(Field.Tower));

        lcfg.println(Output.game_over, "lars");
    }
}