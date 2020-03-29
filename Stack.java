import java.util.*;

public class Stack<T> implements Iterable<T> {
		private List<T> list = new ArrayList<T>();

		public Stack() {
				
		}

		public Stack(Iterable<T> iterable) {
				for (T value : iterable) {
						list.add(value);
				}
		}

		@SuppressWarnings("unchecked")
		public Stack(T... args) {
				for (T arg : args) {
						list.add(arg);
				}		
		}

		public void push(T value) {
				list.add(value);
		}

		public T pop() {
				T value = list.get(list.size() - 1);
				list.remove(list.size() -1);
				return value;
		}

		public int size() {
				return list.size();
		}

		@Override
		public Iterator<T> iterator() {
				return new StackIterator();
		}

		@Override
		public String toString() {
				return list.toString();
		}

		private class StackIterator implements Iterator<T> {
				@Override
				public boolean hasNext() {
						return list.size() > 0;
				}

				@Override
				public T next() {
						return Stack.this.pop();
				}
		}



		public static void main(String[] args) {
				Stack<String> stack = new Stack<>();
				for (String arg : args) {
						stack.push(arg);
				}
				for (String arg : stack) {
						System.out.print(arg + ", ");
				}
		}
}
