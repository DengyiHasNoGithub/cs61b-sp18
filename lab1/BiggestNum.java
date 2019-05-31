public class BiggestNum{
	public static int max(int[] m){
		int len = m.length;
		int i = 0;
		int max = 0;
		while (i < len){
			if (m[i] > max){
				max = m[i];
			}
			i = i + 1;
		}
		return max;
	}

	public static void main(String[] args){
		int[] numbers = new int[] {2,9,6,33,5,6,23,54};
		System.out.println(max(numbers));
	}
}