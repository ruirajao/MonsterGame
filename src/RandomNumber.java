public class RandomNumber {
    public static int randomGeneratedNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min); //should return a random number between 0 a max rand(1,13);
    }
}