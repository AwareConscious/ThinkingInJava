//: object/HelloDate.java
package com.huobi.prj;
import java.util.*;

/** The first Thinking in Java example program.
 * Displays a string and today's date.
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
 */
public class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments
     * @throws exceptions No exceptions thorown
     */
    final int message_of_the_day = 5;
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
        System.out.println("A String of things");
        System.out.print("command line arguments: ");
        System.out.println(args);
    }
} /* Output: (55% match)
Hello, it's:
Wed Oct 05 14:39:36 MDT 2005
*///:~
class SomeClass{
    int f = 78;
    public static int printIt(String[] args){
        System.out.print("command line arguments: ");
        System.out.println(args);
        return 1;
    }
}