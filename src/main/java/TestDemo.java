import java.util.Random;

public class TestDemo {

    int randomNumberSquared() {
        int randomNumber = getRandomInt();
        return randomNumber * randomNumber;
    }

        int getRandomInt() {
            Random random = new Random();
            return random.nextInt(10) + 1;
        }


    public int addPositive (int a, int b) {
        if (b >= 0 && a >= 0) {
            return a + b;
        }
        else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }
}
