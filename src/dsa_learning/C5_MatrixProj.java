package dsa_learning;


class Node {
    int data;
    Node right;
    Node down;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.down = null;
    }
}
/////////////////////////////////////////////////////
class C5_MatrixProj {
    private Node[][] nodes;

    public C5_MatrixProj(int rows, int cols) {
        nodes = new Node[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(0); 
                if (j > 0) {
                    nodes[i][j - 1].right = nodes[i][j];
                }
                if (i > 0) {
                    nodes[i - 1][j].down = nodes[i][j]; 
                }
            }
        }
    }

    public void insert(int row, int col, int data) {
        if (row >= nodes.length || col >= nodes[0].length) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        nodes[row][col].data = data;
    }

    public void display() {
        for (Node[] row : nodes) {
            Node current = row[0];
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.right;
            }
            System.out.println();
        }
    }
}

//////////////////////////////////////////////////////
class C5_MatrixApp {
    public static void main(String[] args) {
        C5_MatrixProj matrix = new C5_MatrixProj(7, 10); 

        matrix.insert(0, 3, 5); 
        matrix.insert(2, 7, 15); 
        matrix.insert(6, 9, 25); 

        matrix.display(); 
    }
}


