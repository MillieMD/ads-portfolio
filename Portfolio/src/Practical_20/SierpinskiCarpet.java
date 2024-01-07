package Practical_20;

public class SierpinskiCarpet {

    /**
     * Generates a Sierpinski's Carpet fractal using '*' and ' ', of size 3^n
     * @param n size factor
     * @return 2d char[][] of the fractal
     */
    public static char[][] generateSierpinskiCarpet(int n){
        // N must be in range 1 <= n => 5
        if(1 > n || n > 5){
            throw new RuntimeException("n must be between 1 and 5");
        }

        int size = (int) Math.pow(3, n); // N is integer, and int^int is always an integer, safe to cast

        char[][] carpet = new char[size][size];

        // Fill array with *
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                carpet[j][i] = '*';
            }
        }

        return pokeHoles(carpet, size-1, 0, size-1, 0);
    }

    /**
     * Generates a Sierpinski's Carpet fractal using '*' and filling gaps with the current recusion level.
     * Size: 3^n
     * @param n size factor
     * @return 2d char[][] of the fractal
     */
    public static char[][] generateSierpinskiCarpetLevels(int n){
        // N must be in range 1 <= n => 5
        if(1 > n || n > 5){
            throw new RuntimeException("n must be between 1 and 5");
        }

        int size = (int) Math.pow(3, n); // N is integer, and int^int is always an integer, safe to cast

        char[][] carpet = new char[size][size];

        // Fill array with *
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                carpet[j][i] = '*';
            }
        }

        return pokeNumbers(carpet, size-1, 0, size-1, 0, 0);
    }

    /**
     * Given the coordinates of a "square" in a 2d char array, remove the center 1/9th
     * and recursively repeat the process until the squares are too small
     * @param carpet 2d char array to perform process on
     * @param x_upper upper x bound
     * @param x_lower lower x bound
     * @param y_upper upper y bound
     * @param y_lower lower y bound
     * @return 2d char array of sierpinski carpet
     */
    private static char[][] pokeHoles(char[][] carpet, int x_upper, int x_lower, int y_upper, int y_lower){ // coords of current sub area of carpet

        int size = (x_upper +1 - x_lower)/3;

        if(size < 1){
            return carpet;
        }

        // Remove middle section
        for(int x = size; x < 2*size; x++){
            for(int y = size; y < 2*size; y++){
                carpet[y + y_lower][x + x_lower] = ' ';
            }
        }

        // Split into 9 smaller subsections and poke holes
        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                pokeHoles(carpet,  x_lower + (i)*size, x_lower + (i-1)*size, y_lower + (j)*size, y_lower + (j-1)*size);
            }
        }

        return carpet;

    }

    /**
     * Given the coordinates of a "square" in a 2d char array, remove the center 1/9th
     * and recursively repeat the process until the squares are too small
     * @param carpet 2d char array to perform process on
     * @param x_upper upper x bound
     * @param x_lower lower x bound
     * @param y_upper upper y bound
     * @param y_lower lower y bound
     * @param level current level of recursion
     * @return 2d char array of sierpinski carpet
     */
    private static char[][] pokeNumbers(char[][] carpet, int x_upper, int x_lower, int y_upper, int y_lower, int level){

        int size = (x_upper +1 - x_lower)/3;

        // If size of sub array is less than one "square" just return out
        if(size < 1){
            return carpet;
        }

        // Remove middle section
        for(int x = size; x < 2*size; x++){
            for(int y = size; y < 2*size; y++){
                carpet[y + y_lower][x + x_lower] = (char)(level + 48); // ASCII for digits are 48 above
            }
        }

        level++; // Increment recursion level

        for(int i = 1; i < 4; i++){
            for(int j = 1; j < 4; j++){
                // Middle "square" must be skipped to avoid renumbering the recursion levels
                if(!(i == 2 && j == 2)){
                    pokeNumbers(carpet,  x_lower + (i)*size, x_lower + (i-1)*size, y_lower + (j)*size, y_lower + (j-1)*size, level);
                }
            }
        }

        return carpet;
    }


    public static void main(String[] args) {
        int n = 3;
        char[][] sCarpet = generateSierpinskiCarpet(n);

        for(int i = 0; i < sCarpet[0].length; i++){
            for(int j = 0; j < sCarpet[0].length; j++){
                System.out.print(" " + sCarpet[j][i] + " ");
            }

            System.out.print("\n");
        }

        System.out.println("Sierpinski Carpet with recursion levels:");

        char[][] lCarpet = generateSierpinskiCarpetLevels(n);

        for(int i = 0; i < lCarpet[0].length; i++){
            for(int j = 0; j < lCarpet[0].length; j++){

                System.out.print(" " + lCarpet[j][i] + " ");
            }

            System.out.print("\n");
        }
    }

}
