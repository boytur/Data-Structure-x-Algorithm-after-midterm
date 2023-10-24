public class Main {
    public static void main(String[] args) {
        ArrayList my_arr = new ArrayList(10);
        my_arr.show();
        my_arr.add(10);
        my_arr.add(20);
        my_arr.add(30);
        my_arr.show();
        my_arr.add(1,15);
        my_arr.show();
        my_arr.set(3, 40);
        my_arr.show();
        try {
            my_arr.add(6, 60);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            my_arr.set(4, 60);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            my_arr.get(4);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
