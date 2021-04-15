public class IsPowerOfTwo {
    public Boolean isPowerOfTwo(int n) {
        if (n < 2) {
            return false;
        }
        if (n % 2 == 1) {
            return false;
        }
        if (n / 2 == 1) {
            return true;
        }
        return isPowerOfTwo(n / 2);
    }
}
