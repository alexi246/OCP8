package chapter_6;

import chapter_1.OverrideFromObject;

/**
 * Created by alexi on 2016/06/27.
 */
public class Assertions {

    public static void main(String[] args) {

        OverrideFromObject overrideFromObject = new OverrideFromObject("Timmy", 25);

        assert (overrideFromObject.equals(new OverrideFromObject("Timmy", 24))) : "Objects are not equal";
    }
}
