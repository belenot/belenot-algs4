import java.util.*;

public class Bag<T> implements Iterable<T> {

		public static final int DEFAULT_SIZE = 4;

		private Object[] items = new Object[DEFAULT_SIZE];
		private int count = 0;
		
		public Bag() {
				
		}
		
		public void add(T value) {
				if (count + 1 == items.length) {
						rearrange();
				}
				items[count] = value;
				count += 1;
		}
		
		public boolean isEmpty() {
				return count == 0;
		}
		
		public int size() {
				return count;
		}

		@Override
		public BagIterator iterator() {
				return new BagIterator(items);
		}

		private void rearrange() {
				int currentSize = items.length;
				int newSize = currentSize * 2;
				Object[] newItems = new Object[newSize];
				for (int i = 0; i < currentSize; i++) {
						newItems[i] = items[i];
				}
				items = newItems;
		}

	  public class BagIterator implements Iterator<T> {

				private int currentIndex = 0;
				private int totalSize = 0;
				private Object[] cachedItems;

				private BagIterator(Object[] items) {
						totalSize = Bag.this.count;
						cachedItems = new Object[totalSize];
						for (int i = 0; i < totalSize; i++) {
								cachedItems[i] = items[i];
						}
				}
				
				@Override
				public boolean hasNext() {
						return currentIndex != cachedItems.length;
				}

				@Override
				@SuppressWarnings("unchecked")
				public T next() {
						return (T) cachedItems[currentIndex++];
				}				
		}
}
