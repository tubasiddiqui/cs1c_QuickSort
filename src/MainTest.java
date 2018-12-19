
/**
 * Tuba Siddiqui
 * CS1C
 * Assignment 8
 */

/**
 * main test file investigating recursion limit of array from 20,000 to 2,300,000
 * Investigate recursion limit of quicksort
 */
//Write a test file that investigates the recursion limit of arrays of various sizes.
//Your test file must be in a separate class than FHsort class, which means a new .java file
public class MainTest {
    /**
     * main test file to test recursion limit run time of different array sizes
     * @param args
     */
    public static void main(String[] args){
        //Run them on different size arrays from 20,000 up to the largest you can get in your computer with at least 20 intervals.
        //20 intervals of 120,000 of array sizes 20,000 to 2,300,000
        /**
         * attributes
         * array sizes, minimum limit, maximum limit, and recursion limit defined
         */
        final int[] ARRAY_SIZES = {20000, 140000, 260000, 380000, 500000, 620000, 740000, 860000, 980000, 1100000, 1220000, 1340000, 1460000, 1580000, 1700000, 1820000, 1940000, 2060000, 2180000, 2300000};

        //minimum recursion limit
        int minLimit = 2;
        //maximum recursion limit
        int maxLimit = 300;

        int k = minLimit;
        int randomInt = minLimit;

        //only investigate limits from 2-300 in steps of 2
        int[] arrayStep = new int[maxLimit / 2];

        /**
         * starting recursion of limits and start time when finding runtime
         */
        //initial
        int start = 0;
        long startTime, estimatedTime2;

        /**
         * Investigate limit in steps of 2
         */
        //Investigate all recursion limits from 2 to 300 in steps of 2. For example: 2, 4, 6, 8 ...
        while (maxLimit >= k && start < arrayStep.length) {
            //set the recursion limit to start at 2
            arrayStep[start] = randomInt;
            //recursively add 2
            randomInt += 2;
            //adjust start value after each recursion of step 2 and keep adding until start is less than the arrayStep
            start++;
        }

        /**
         * perform quicksort
         * use FHsort file
         */
        //quicksort using FHsort file
        for (int i = 0; i < arrayStep.length; i++) {
            //set recursion limit
            //find optimal recursion limit arrays of various sizes
            FHsort.setRecursionLimit(arrayStep[i]); //static mutator
            //print out what arrayStep is being looked at
            System.out.println("\nInvestigating Recursion Limit Of: " + arrayStep[i]);

            //test array sizes for all limits
            for (int arrayTest = 0; arrayTest < ARRAY_SIZES.length; arrayTest++) {
                int testSize = ARRAY_SIZES[arrayTest];

                Integer[] arrayOfInts2 = new Integer[testSize];

                //build array
                //have random generated numbers to test different recursion limits
                for (k = 0; k < testSize; k++) {
                    randomInt = (int) (Math.random() * testSize);
                    arrayOfInts2[k] = randomInt;
                }

                /**
                 * record the runtime in ns
                 * use TimeConverter file
                 */
                //record the run time using timeConverter file
                startTime = System.nanoTime();  // ------------------ start
                FHsort.quickSort(arrayOfInts2);

                /**
                 * print time (ns)
                 */
                //print time in ns
                estimatedTime2 = System.nanoTime() - startTime;    // ---------------------- stop
                System.out.println("Quick sort Elapsed Time: "
                        + " size: " + testSize + ", "
                        + TimeConverter.convertTimeToString(estimatedTime2)
                        + " = " + estimatedTime2 + "ns");
            }

        }
    }
}