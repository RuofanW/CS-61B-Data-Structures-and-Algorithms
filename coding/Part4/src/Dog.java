/**
 * Created by wangruofan on 2017/5/6.
 */
public class Dog implements OurComparable{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    public  int compareTo(OurComparable ourdog){
        Dog d = (Dog) ourdog;
        return this.size - d.size;
    }

}
