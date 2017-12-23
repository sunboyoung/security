package math;

public class StringDemo {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "bbb";
        String ab = "aaa" + "bbb";
        String ab1 = "aaa" + b;
        String aabb = "aaabbb";
        String abb = a + b;
        System.out.println(ab == ab1);
        System.out.println(ab == aabb);
        System.out.println(ab == abb);
        System.out.println(ab1 == abb);
    }
}
