package dsa_learning;

//QUESTION 2
public class C6_BinaryTreeDrawing {
    private char[][] treeArray;
    private int width;
    private int height;

    public C6_BinaryTreeDrawing(int width) {
        this.width = width;
        this.height = (int) (Math.log(width) / Math.log(2)) + 1;
        treeArray = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                treeArray[i][j] = '-';
            }
        }
        
        makeBranches(0, width - 1, 0);
    }

    private void makeBranches(int left, int right, int depth) {
        if (left > right || depth >= height) {
            return;
        }

        int center = (left + right) / 2;
        treeArray[depth][center] = 'X';
        makeBranches(left, center - 1, depth + 1);
        makeBranches(center + 1, right, depth + 1);
    }

    public void display() {
        for (char[] row : treeArray) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        int treeWidth = 16; // You can change this to 32, 64, etc.
        C6_BinaryTreeDrawing tree = new C6_BinaryTreeDrawing(treeWidth);
        tree.display();
    }
}
