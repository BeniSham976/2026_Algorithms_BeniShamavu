package utils;

public class Ca2Utils {
    public int[] deduplicate(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        /*
            // SETUP
            Create a new array (filtered) with size equal to data
            Create a variable (uniqueCount) to track number of elements added to filtered
        */
        int[] filtered = new int[data.length];
        int uniqueCount = 0;

        filtered[0] = data[0];
        uniqueCount++;

        /*
            // LOGIC
            for each element (elem) in data starting at slot 1:
                Create boolean flag (found) to track if element exists in filtered and set to false
                for each slot (j) in filtered up to uniqueCount:
                    if elem equals value in filtered[j]:
                        Set found to true
                        Halt loop/break out of loop

                if found is false:
                    Set filtered[uniqueCount] to elem
                    Increase uniqueCount by 1
        */
        for (int i = 1; i < data.length; i++) {
            int currentElem = data[i];
            boolean found = false;
            for (int j = 0; j < filtered.length; j++) {
                if (currentElem==(filtered[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                filtered[uniqueCount] = currentElem;
                uniqueCount++;
            }
        }
        if (uniqueCount == data.length) {
            return filtered;
        }
        /*
            resize filtered array to uniqueCount size and store in new array (resized)
        */
        int [] resized = new int[uniqueCount];
        for (int i = 0; i < resized.length; i++) {
            resized[i] = filtered[i];
        }
        /*
            // OUTPUT
            return resized
         */
        return resized;
    }

    public static int[] orderedDeduplication(int[] data){
        if (data == null){
            throw new IllegalArgumentException("Data cannot be null");
        }
        // Handle unsuitable data
        // If the array is empty, avoid any extra unnecessary processing
        if (data.length == 0){
            return new int[0];
        }

        // SETUP : Create an array to hold one copy of each value, plus a tracker to know where we are in it
        int [] filtered = new int[data.length];
        int uniqueCount = 0;

        // LOGIC
        // Add first element in automatically
        filtered[0] = data[0];
        uniqueCount++;

        // Loop through and add each of the rest in
        for(int i = 1; i < data.length; i++){
            // If the current element doesn't match the last thing we saved
            if(data[i] != filtered[uniqueCount-1]){
                // Save first instance of new value to filtered array
                filtered[uniqueCount] = data[i];
                // Increase number of values encountered
                uniqueCount++;
            }
        }

        // Filtered now contains only one copy of each value
        // If array is full, return it
        if(filtered.length == uniqueCount){
            return filtered;
        }

        // If array has empty slots, make a smaller one
        int [] resized = new int[uniqueCount];
        // Copy each value from the filtered array to the smaller array
        for (int i = 0; i < resized.length; i++) {
            resized[i] = filtered[i];
        }
        // Return the smaller array
        return resized;
    }
}
