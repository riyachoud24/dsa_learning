package dsa_learning;

//Question 5
class C5_JosephusProj {
    private C5_CircularList circle;
    private int countNum; // The number used for counting off

    public C5_JosephusProj(int numPeople, int countNum, int startingPosition) {
        circle = new C5_CircularList();
        this.countNum = countNum;

        for (int i = 1; i <= numPeople; i++) {
            circle.insert(i);
        }

        while (startingPosition-- > 1) {
            circle.step();
        }
    }

    public void startElimination() {
        System.out.println("Elimination order: ");
        while (circle.getSize() > 1) {
            for (int i = 0; i < countNum - 1; i++) {
                circle.step();
            }
            System.out.print(circle.eliminateCurrent() + " ");
        }
        System.out.println("\nThe survivor is: " + circle.getCurrentData());
    }
}

///////////////////////////////////////////////////

class C5_JosephusApp {
    public static void main(String[] args) {
        C5_JosephusProj josephus = new C5_JosephusProj(7, 3, 1);
        josephus.startElimination();
    }
}
