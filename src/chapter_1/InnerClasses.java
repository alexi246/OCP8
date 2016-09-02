package chapter_1;

/**
 * Created by Alexi on 2016-06-04.
 * This class demonstrates the features and rules for using member inner classes, local inner classes, anonymous inner classes and static nested classes
 */
public class InnerClasses {

    private class Member { // member inner class
        private String message = "Member inner class";
    }

    private abstract class AnonInner {
        private int number = 5;
        // static int anInt; // inner classes cannot have static members
        abstract void f();
    }

    private static class StaticClass { // static nested class
        private int anInt = 21;
        private static String message = "Static member from static nested class"; // static nested classes may contain static members
    }

    public static void main(String[] args) {
        InnerClasses innerClasses = new InnerClasses();

        Member member = innerClasses.new Member();

        System.out.println("****************** Member inner class *******************");
        System.out.println(member.message);

        // Anonymous inner class
        AnonInner anonInner = innerClasses.new AnonInner() {
            void f() {
                System.out.print("Inside anonymous inner class. ");
            }
        };

        System.out.println("****************** Anonymous inner class ******************");
        anonInner.f();
        System.out.println("Value is " + anonInner.number);

        InnerClasses.StaticClass staticClass = new StaticClass();

        System.out.println("****************** Static neted class *********************");
        System.out.println("Static class contains an integer of value: " + staticClass.anInt); // Remember that in Java, the enclosing class has access to private variables of its inner class
        System.out.println(StaticClass.message);

        System.out.println("***************** Local inner class *******************");
        innerClasses.local();
    }

    private void local() {
        class LocalInner {
            private String message = "Local inner class";
            // private static int anInt; // static members are not allowed inside a local class
        }

        LocalInner localInner = new LocalInner();
        System.out.println(localInner.message);
    }

}
