public class StringOperations {
    public static void main (String[] args) {

        String myName = "Jun Liang";
        System.out.println(myName);

        String myNewName = "A" + myName.substring(1, myName.length()-1) + "Z";
        System.out.println(myNewName);

        String webAddr = "www.gatech.edu";
        System.out.println(webAddr);

        String newWebAddr = webAddr.substring(4, webAddr.length()-4) + "1331";
        System.out.println(newWebAddr);
    }
}