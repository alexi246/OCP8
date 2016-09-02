package chapter_5;

import java.util.Locale;

/**
 * Created by alexi on 2016/06/27.
 */
public class ResourceBundle {

    public static void main(String[] args) {
        Locale greek = new Locale("gr", "GR");

        display(greek);
    }

    public static void display(Locale locale) {
        java.util.ResourceBundle resourceBundle = java.util.ResourceBundle.getBundle("chapter_5.Zoo_el_el_GR", locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("open"));
    }
}
