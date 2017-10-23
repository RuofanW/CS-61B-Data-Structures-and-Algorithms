/**
 * Created by wangruofan on 2017/5/2.
 */
public class Palindrome {
    public static LinkedListDequeSolution<Character> wordToDeque(String word){
        LinkedListDequeSolution<Character> newdeque = new LinkedListDequeSolution<Character>();
        char[] chary=  word.toCharArray();
        for(int i = 0; i<chary.length; i++) {
            newdeque.addLast(chary[i]);
        }
    return newdeque;
    }

    public static boolean isPalindrome(String word){
        boolean res = true;
        char[] chary=  word.toCharArray();
        if(word.length() > 1){
            float l = word.length()/2;
            for(int i = 0; i<l ;i++) {
                if (chary[i] != chary[word.length() - 1 - i]) {
                    return false;
                }

            }
        }
        return res;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc){
        boolean res = true;
        char[] chary=  word.toCharArray();
        if(word.length() > 1){
            float l = word.length()/2;
            for(int i = 0; i<l ;i++) {
                if (! cc.equalChars(chary[i], chary[word.length() - 1 - i])) {
                    return false;
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        LinkedListDequeSolution<Character> test = wordToDeque("String");
        test.printDeque();
        OffByN offby2 = new OffByN(2);
        System.out.println(isPalindrome("flake", offby2));
    }
}
