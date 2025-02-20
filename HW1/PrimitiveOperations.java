public class PrimitiveOperations {
    public static void main (String[] args) {
        int myIntOne = 10;
        int myIntTwo = 2;

        System.out.println(myIntOne);
        System.out.println(myIntTwo);

        int myMultipliedInt = myIntOne * myIntTwo;

        System.out.println(myMultipliedInt);

        float myFloat = (float) myMultipliedInt;

        System.out.println(myFloat);

        char myChar = 'Z';
        System.out.println(myChar);

        char myNewChar = (char) (myChar + 20);
        System.out.println(myNewChar);
    }
}