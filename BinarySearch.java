public class BinarySearch {
		public static void main(String[] args) {
				int value = Integer.parseInt(args[0]);
			  int[] sortedArray = new int[args.length - 1];
				for (int i = 1; i < args.length; i++) sortedArray[i - 1] = Integer.parseInt(args[i]);
				System.out.println(binarySearch(value, sortedArray, 0, sortedArray.length));
				
		}
		public static int binarySearch(int value, int[] sortedArray, int start, int end) {
				int length = end - start;
				for (int i = start; i < end; i++) {
						int middleIndex = start + length / 2;
						int middleValue = sortedArray[middleIndex];
						if (middleValue == value) return middleIndex;
						if (middleValue > value) {
								return binarySearch(value, sortedArray, start, start + length / 2);
						} else {
								return binarySearch(value, sortedArray, start + length / 2, end);
						}
				}
				return -1;
		}
}
