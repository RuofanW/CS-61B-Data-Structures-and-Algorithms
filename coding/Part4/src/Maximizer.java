/**
 * Created by wangruofan on 2017/5/6.
 */
public class Maximizer {
    public static Object max(OurComparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            if (items[i].compareTo(items[maxDex]) > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];

    }

    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9),
                new Dog("Artemesios", 15)};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }
}