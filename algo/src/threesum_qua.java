/**
 * Created by wangruofan on 2017/5/26.
 */

import java.util.Collections;
import java.util.ArrayList;
//import java.util.Scanner;

public class threesum_qua {

    public ArrayList<Integer> data;

    public threesum_qua(ArrayList<Integer> intarray){
        data = intarray;
    }

    public void threesum(){
        if(this.data == null || this.data.size() < 3){
            System.out.println("Error！");
        }

        Collections.sort(this.data);

        for(int i = 0; i < this.data.size() - 2; i = i+ 1){
            int j = i + 1;
            int k = this.data.size() - 1;
            while(j < k){
                int sum = this.data.get(j) + this.data.get(k);
                if(sum == -this.data.get(i)){
                    System.out.println(i+":"+this.data.get(i)+" "+j+":"+this.data.get(j)+" "+k+":"+this.data.get(k)+" ");
                    j = j + 1;
                    k = k - 1;
                }
                else if(sum + this.data.get(i) > 0){
                    k = k - 1;
                }
                else{
                    j = j + 1;
                }
            }

        }
    }

    public static void main(String args[]){
        ArrayList<Integer> testdata = new ArrayList<Integer>();
        testdata.add(2);
        testdata.add(-2);
        testdata.add(7);
        testdata.add(-1);
        testdata.add(3);
        testdata.add(5);
        testdata.add(1);

        threesum_qua testmodel = new threesum_qua(testdata);
        testmodel.threesum();
    }
}
