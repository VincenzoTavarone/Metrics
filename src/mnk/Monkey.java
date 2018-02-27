package mnk;

import java.util.Random;

public class Monkey {

    public static double getMonkeyValue(){
        Random generator = new Random();
        return generator.nextDouble();
    }

}
