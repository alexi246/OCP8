package chapter_5;

import java.util.Locale;

/**
 * Created by alexi on 2016/06/27.
 */
public class Locales {

    public static void main(String[] args) {
        Locale mine = Locale.getDefault();
        System.out.println(mine.getDisplayLanguage() + ", " + mine.getDisplayCountry());

        Locale greece = new Locale("el", "GR");
        System.out.println(greece.getDisplayLanguage() + ", " + greece.getDisplayCountry());
    }
}
