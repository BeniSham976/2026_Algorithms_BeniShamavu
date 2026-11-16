package utils;

public class Ca4Utils {
    public static int[] merge(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Cannot merge a null array");
        }

        int[] merged = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            merged[nums1.length + i] = nums2[i];
        }
        return merged;
    }

    public static int[] orderedMerge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Cannot merge a null array");
        }
        int leftOrdered = 0;
        int rightOrdered = 0;
        int[] ordered = new int[nums1.length + nums2.length];

                /*
            // LOGIC:
            for each slot (i) in merged:
                if nums1Tracker equals nums1.length:
                    Set merged[i] to current element in nums2
                    Increase nums2Tracker by 1 +
                else if nums2Tracker equals nums2.length:
                    Set merged[i] to current element in nums1
                    Increase nums1Tracker by 1 +
                else if current element in nums1 (nums1[nums1Tracker]) < current element in nums2 (nums2[nums2Tracker]):
                    Set merged[i] to current element in nums1
                    Increase nums1Tracker by 1 +
                else:
                    Set merged[i] to current element in nums2
                    Increase nums2Tracker by 1 +
        */

        for (int i = 0; i < nums1.length; i++) {
            if (leftOrdered == nums1.length) {
                ordered[i] = nums2[i];
                rightOrdered++;
            } else if (leftOrdered == nums2.length) {
                ordered[i] = nums1[i];
                leftOrdered++;
            } else if (nums1[i] < nums2[i]) {
                ordered[i] = nums1[i];
                leftOrdered++;
            } else {
                ordered[i] = nums2[i];
                rightOrdered++;
            }
        }
        return ordered;
    }
    public int[] partition(int[] data, int pivot) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }

        /*
        * Partitioning separates data into a smaller sublist of elements in a specified size

        //SETUP:
        * Create variable leftCount to count elements placed on the left partition
        * Create variable rightCount to count elements placed on the right partition
        * Create variable pivot to determine whether element goes to left or right partition

        * //LOGIC:
        For every value in data:
            if value is less or equal to the pivot:
            Increase leftCount by 1
          else
          * Increase right count by 1
        * */
        int leftCount = 0;
        int rightCount = 0;

        for (int value : data) {
            if (value <= pivot) {
                leftCount++;
            } else {
                rightCount++;
            }
        }

        /*
        //SETUP:
        * Create array left to place data on the left
        * Create variable leftTracker to track elements on the left
        * Create array right to place data on the right
        * Create variable rightTracker to track elements on the right
        */
        int[] left = new int[leftCount];
        int leftTracker = 0;
        int[] right = new int[rightCount];
        int rightTracker = 0;

        /*
        //LOGIC:
        * for every value in data:
            if value is less or equal to the pivot:
            assign left of leftTracker to value
            Increase leftTracker by 1
           else
             assign right of rightTracker to value
             Increase rightTracker by 1
             */
        for (int value : data) {
            if (value <= pivot) {
                left[leftTracker] = value;
                leftTracker++;
            } else {
                right[rightTracker] = value;
                rightTracker++;
            }
        }
        int[] partitioned = merge(left, right);
        return partitioned;
    }
}
