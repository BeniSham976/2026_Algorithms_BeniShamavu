package apps;

import java.util.Arrays;
import java.util.Scanner;
import utils.*;

public class NumberMerging {
    static Scanner kb = new Scanner(System.in);
    static int[] nums1 = new int[4];
    static int[] nums2 = new int[4];
    static void main(String[] args) {
        System.out.println("Enter first array of numbers (ascending order)");
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = kb.nextInt();
        }
        System.out.println("Enter second array of numbers (ascending order");
        for (int j= 0;  j < nums2.length; j++) {
            nums2[j] = kb.nextInt();
        }
        int[] merged = new int[nums1.length+ nums2.length];
        merged = Ca4Utils.merge(nums1,nums2);
        for (int i = 0; i < merged.length; i++) {
            System.out.print("\n" + (i+1) + ": " + merged[i] + " ");
        }
    }
}
