package chapter_1;

/**
 * Created by Alexi on 2016-06-04.
 * This class demonstrates how to overload the functions from the Object superclass, these are;
 * public boolean equals(Object object);
 * public int hashCode();
 * public String toString();
 */
public class OverrideFromObject {

    private String name;
    private int number;

    public OverrideFromObject(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // Used to define how to check for object equality
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OverrideFromObject)) return false;
        OverrideFromObject overrideFromObject = (OverrideFromObject) obj;
        return (this.number == overrideFromObject.number) && (this.name.equals(overrideFromObject.name));
    }

    // Used to define a unique code for the object, it is used for set and map keys
    @Override
    public int hashCode() {
        return (7 * number) + (name.hashCode());
    }

    // Used to define a useful description of the object
    @Override
    public String toString() {
        return String.format("%s : %d", name, number);
    }

    public static void main(String[] args) {
        OverrideFromObject overrideFromObject = new OverrideFromObject("Timmy", 23);
        System.out.println(overrideFromObject);
        System.out.println("Equals to another Timmy: " + overrideFromObject.equals(new OverrideFromObject("Timmy", 23))); // true
        System.out.println("Equals to another timmy: " + overrideFromObject.equals(new OverrideFromObject("timmy", 23))); //false
        System.out.println("Equals to a 13-year-old Timmy: " + overrideFromObject.equals(new OverrideFromObject("Timmy", 13))); // false
    }

}
