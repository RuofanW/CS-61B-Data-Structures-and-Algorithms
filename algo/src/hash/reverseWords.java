package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class reverseWords {

    public String reverseWords(String s) {
        if(s.length() < 2){
            return s;
        }
        s= removeextrabalnks(s);
        s = reverse(s, 0, s.length() -1 );
        s = appendblank(s);
        int i = 0;
        int j = 0;
        while(i != s.length()){
            if((int)s.charAt(i) == 32){
                s = reverse(s, j, i - 1);
                j = i + 1;
            }
            i ++;
        }
        StringBuffer res = new StringBuffer(s);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public String reverse(String s, int start, int end){
        StringBuffer str = new StringBuffer(s);
        while(start < end){
            char temp = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, temp);
            start ++;
            end --;
        }
        return str.toString();
    }

    public String appendblank(String s){
        return s + " ";
    }

    public String removeextrabalnks(String s){
        int i = s.length() - 1;
        while((int)s.charAt(i) == 32){
            i --;
            if(i < 0){
                break;
            }
        }
        return s.substring(0, i + 1);
    }

    public static void main(String[] args){
        reverseWords test = new reverseWords();
        String s = test.reverseWords("    ");
        System.out.println(s);
    }


}
