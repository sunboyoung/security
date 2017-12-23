package math;

public class Son extends Father {
    public int num = 10;

    public Son(int num) {
        super();
        this.num = num;
    }

    public void out() {
        System.out.println("this num is:" + num);
    }
}
