public class BiggestNum2{
	public static int forMax(int[] m){
		int len = m.length;
		int max = 0;
		for (int i = 0; i < len; i = i + 1){
			if (m[i] > max){
				max = m[i];
			}
		}
		return max;
	}

	public static void main (String[] args){
		int[] numbers = new int[] {9,2,15,2,22,10,34};
		System.out.println(forMax(numbers));
	}
}