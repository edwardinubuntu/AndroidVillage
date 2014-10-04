package tw.soleil.androidvillage.activity.java.object;

/**
 * Created by bryan on 2014/10/4.
 */
public class Ape extends Monkey  {

    public Ape() {
    climbTree = false;
}

    public Ape(int weight, int height) {
        super(weight, height);
        climbTree = false;
        setColor("brown");
    }

    @Override
    public String sound() {
        return "WuuuuuuuuEEEeeeeeee";
    }


}
