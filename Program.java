import tech.dinhphu28.hanoitower.HanoiTower;
import tech.dinhphu28.hanoitower.Stack;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException {
        int n = 3;
        HanoiTower hanoiTower = new HanoiTower(n);
        System.out.print("Tower A: ");
        System.out.println(hanoiTower.getTowerA());
        System.out.print("Tower B: ");
        System.out.println(hanoiTower.getTowerB());
        System.out.print("Tower C: ");
        System.out.println(hanoiTower.getTowerC());
        System.out.println("---");

        towerOfHanoi(n, hanoiTower,HanoiTower.Tower.A, HanoiTower.Tower.C, HanoiTower.Tower.B);

        System.out.println("---");
        System.out.print("Tower A: ");
        System.out.println(hanoiTower.getTowerA());
        System.out.print("Tower B: ");
        System.out.println(hanoiTower.getTowerB());
        System.out.print("Tower C: ");
        System.out.println(hanoiTower.getTowerC());
        System.out.print("Result is success?: ");
        System.out.println(hanoiTower.isSuccess());

//        Stack<Integer> stack = new Stack<>(1);
//        stack.push(5);
//        System.out.println(stack);
    }

    static void towerOfHanoi(int n, HanoiTower hanoiTower,
                             HanoiTower.Tower from_rod, HanoiTower.Tower to_rod, HanoiTower.Tower helper_rod)
    {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            hanoiTower.liftFromTower(from_rod);
            hanoiTower.putToTower(to_rod);

            return;
        }
        towerOfHanoi(n-1, hanoiTower, from_rod, helper_rod, to_rod);

        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        hanoiTower.liftFromTower(from_rod);
        hanoiTower.putToTower(to_rod);

        towerOfHanoi(n-1, hanoiTower, helper_rod, to_rod, from_rod);
    }
}
