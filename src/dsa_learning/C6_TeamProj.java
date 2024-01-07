package dsa_learning;

import java.util.Scanner;
// QUESTION 5
public class C6_TeamProj {
    
    private static void showTeams(char[] group, char[] team, int start, int k) {
        if (k == 0) {
            System.out.println(String.valueOf(team));
            return;
        }

        for (int i = start; i <= group.length - k; i++) {
            team[team.length - k] = group[i];
            showTeams(group, team, i + 1, k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter group size (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter team size (k): ");
        int k = scanner.nextInt();

        char[] group = new char[n];
        for (int i = 0; i < n; i++) {
            group[i] = (char) ('A' + i); 
        }

        char[] team = new char[k];
        showTeams(group, team, 0, k);
    }
}

