
@SuppressWarnings("unchecked")
public class ResizableArray<T> {
		int size = 0;
		int capacity = 4;
		T[] array = (T[]) new Object[capacity];

		public void add(T item) {
				if (size == capacity) rearrange();
				array[size++] = item;
		}

		public T get(int index) {
				return array[index];
		}

		public T remove(int index) {
				T removedItem = array[index];
				for (int i = index; i < size - 1; i++) {
						array[i] = array[i + 1];
				}
				array[--size] = null;
				return removedItem;
		}

		public int size() {
				return size;
		}

		private void rearrange() {
				T[] newArray = (T[]) new Object[capacity * 2];
				for (int i = 0; i < size; i++) {
						newArray[i] = array[i];
				}
				array = newArray;
				capacity = capacity * 2;
				
		}

		@Override
		public String toString() {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < size; i++) {
						sb.append(array[i]);
						if (i != size - 1) sb.append(",");
				}
				return sb.toString();
		}
		
		public static void main(String[] args) {
				ResizableArray<Integer> array = new ResizableArray<>();
				for (int i = 0; i < 10; i++) {
						array.add(i);
						System.out.printf("Add[%d]: %d   ", i, i);
						System.out.println(array);
				}

				for (int i = 0; i < 10; i++) {
						System.out.printf("Get[%d]: %s   ", i, array.get(i).toString());
						System.out.println(array);
				}

				for (int i = 0; i < 5; i++) {
						System.out.printf("Remove[%d]: %s   ", i, array.remove(i).toString());
						System.out.println(array);
				}
		}
}
