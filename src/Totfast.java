public class Totfast {
    public void cls() {  // clean the screen
//        String cls = "\033[H\033[2J";
//        System.out.println(cls);
//        System.out.flush();

        for (int i = 0; i < 50; i++) {
            System.out.println('\n');
        }
    }
}
