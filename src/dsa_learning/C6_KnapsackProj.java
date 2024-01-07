package dsa_learning;

// QUESTION 4
public class C6_KnapsackProj {
    
    public static int knapsack(int[] weights, int capacity, int index) {
        if (index == weights.length || capacity == 0) {
            return 0;
        }

        if (weights[index] > capacity) {
            return knapsack(weights, capacity, index + 1);
        } else {
            return Math.max(weights[index] + knapsack(weights, capacity - weights[index], index + 1),
                            knapsack(weights, capacity, index + 1));
        }
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30}; 
        int capacity = 50; 

        System.out.println("Maximum weight in knapsack = " + knapsack(weights, capacity, 0));
    }
}

