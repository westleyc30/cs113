public class PowerOfTwo {
    static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor((Math.log(n) / Math.log(2))));
    }
    static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        return (int) (Math.ceil((Math.log(n) / Math.log(3)))) == (int) (Math.floor((Math.log(n) / Math.log(3))));
    }
}
