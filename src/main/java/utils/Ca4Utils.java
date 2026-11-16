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
}
