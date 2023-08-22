package tech.dinhphu28.hanoitower;
/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks.
 * Initially, all the disks are stacked in decreasing value of diameter
 * i.e., the smallest disk is placed on the top and they are on rod A.
 * The objective of the puzzle is to move the entire stack to another rod (here considered C),
 * obeying the following simple rules:
 *
 * <p>• Only one disk can be moved at a time.
 * <p>• Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack
 * i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * <p>• No disk may be placed on top of a smaller disk.
 *
 * @author dinhphu28
 * @see <a href="https://www.dinhphu28.tech">Website: dinhphu28</a>
 * @see <a href="https://github.com/dinhphu28">GitHub: dinhphu28</a>
 */
public class HanoiTower {
    private final Stack<Integer> towerA;
    private final Stack<Integer> towerB;
    private final Stack<Integer> towerC;

    private Integer poppedValue = 0;

    public HanoiTower(int numberOfDisks) {
        towerA = new Stack<>(numberOfDisks);
        towerB = new Stack<>(numberOfDisks);
        towerC = new Stack<>(numberOfDisks);

        initTowerA(numberOfDisks);
    }

    private void initTowerA(int numberOfDisks) {
        for(int i = numberOfDisks; i > 0; i--) {
            towerA.push(i);
        }
    }

    /**
     *
     * @return true - only if all disks has move from A to C
     */
    public boolean isSuccess() {
        boolean isSuccess = true;
        if(towerA.isEmpty() && towerB.isEmpty() && towerC.isFull()) {
            for(int i = 1; i <= towerC.getCapacity(); i++) {
                try{
                    if(i != towerC.pop()) {
                        isSuccess = false;
                    }
                } catch (Exception e) {
                    isSuccess = false;
                }
            }
        } else {
            isSuccess = false;
        }

        return isSuccess;
    }

    private void liftFromTower(Stack<Integer> tower) {
        if(poppedValue == 0) {
            poppedValue = tower.pop();
        } else {
            throw new RuntimeException("Put disk first");
        }
    }

    private void putToTower(Stack<Integer> tower) {
        if(poppedValue > 0) {
            tower.push(poppedValue);
            poppedValue = 0;
        } else {
            throw new RuntimeException("Nothing to put");
        }
    }

    public void liftFromTower(Tower tower) {
        switch (tower) {
            case A:
                liftFromTower(towerA);
                break;
            case B:
                liftFromTower(towerB);
                break;
            default:
                liftFromTower(towerC);
                break;
        }
    }

    public void putToTower(Tower tower) {
        switch (tower) {
            case A:
                putToTower(towerA);
                break;
            case B:
                putToTower(towerB);
                break;
            default:
                putToTower(towerC);
                break;
        }
    }

    /**
     * <strong>3 Tower used in this problem:</strong>
     * <p><strong>A</strong> is given tower
     * <p><strong>B</strong> is common tower
     * <p><strong>C</strong> is target tower
     */
    public enum Tower {
        A, B, C
    }

    public Stack<Integer> getTowerA() throws CloneNotSupportedException {
        return towerA.clone();
    }

    public Stack<Integer> getTowerB() throws CloneNotSupportedException {
        return towerB.clone();
    }

    public Stack<Integer> getTowerC() throws CloneNotSupportedException {
        return towerC.clone();
    }
}

