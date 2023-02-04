 class Untitled {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = a;
        a[0] = 1;
        System.out.println(b[0]);
    }
}
