package apps;

import java.util.Scanner;
import utils.*;

public class NumberPartitioning {
    static Scanner kb = new Scanner(System.in);;
    static void main(String[] args) {
        int[] grades = new int[6];
        int passingGrade = 40;
        int passCount = 0;
        System.out.println("Enter in student grades");
        for (int i = 0; i < grades.length; i++) {
            grades[i] = kb.nextInt();
            if (grades[i] >= passingGrade){
                passCount++;
            }
        }
        int[] gradesPartition = Ca4Utils.partition(grades, passingGrade);
        for (int i = 0; i < gradesPartition.length; i++) {
            System.out.println("Grade " + (i+1) + ": " + grades[i]);
        }
        System.out.println("\nThe number of passing grades: " + passCount);
    }
}
