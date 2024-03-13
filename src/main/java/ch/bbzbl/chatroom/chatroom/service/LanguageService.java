package ch.bbzbl.chatroom.chatroom.service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class LanguageService {
    private static ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);

    public String findString(String nameOfString) {
        return bundle.getString(nameOfString);
    }

    public void changeLanguage(String language) {
        switch (language) {
            case "de" -> bundle = ResourceBundle.getBundle("messages", Locale.GERMAN);
            case "it" -> bundle = ResourceBundle.getBundle("messages", Locale.ITALIAN);
            case "fr" -> bundle = ResourceBundle.getBundle("messages", Locale.FRENCH);
            default -> bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        }
    }
}
