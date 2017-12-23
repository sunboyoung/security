package math;

public class Single {
    public static Single single = null;

    private Single() {

    }

    public static Single getSingle() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}
