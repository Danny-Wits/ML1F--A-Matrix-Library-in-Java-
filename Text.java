
public class Text {
    public static void main(String[] args) {

        Float[][] a = { { 1F, 0F }, { 0F, 1F } };
        Matrix<Float> m2 = new Matrix<>(a);
        long time = System.nanoTime();
        Matrix<Integer> m = new Matrix<>();
        m.addRow(1, 2);
        m.addRow(1, 2);

        // m.forEach(System.out::println);
        // m.map(e -> "hello");
        System.out.println(m.reduce((e, x) -> x += e, 0));

        // m.add(20).print().subtract(10).print().multiply(2).print();
        System.out.println("Time Taken : " + (System.nanoTime() - time) / 1000000);

    }

}
