public class WordUtils {
	public static String longest(List61B<String> list) {
		int MaxDex = 0;
		for(int i = 0; i < list.size(); i ++){
			String longestword = list.get(MaxDex);
			String thisword = list.get(i);
			if(longestword.length() < thisword.length()){
				MaxDex = i;
			}

		}
		return list.get(MaxDex);
	}

	public static void main(String[] args) {
     	AList<String> someList = new AList<String>();
     	someList.insertBack("elk");
     	someList.insertBack("are");
     	someList.insertBack("watching");
     	System.out.println(longest(someList));
     	someList.print();
  	}
}

