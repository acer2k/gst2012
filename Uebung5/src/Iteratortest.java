
public class Iteratortest {

	public static void main(String[] args) throws Exception{
		IterableArray<Integer> array = new IterableArray<Integer>(new Integer[]{1,2,3,4});
		Iterator<Integer> iterator = array.iterator();
		
		while (!iterator.isDone()){
				System.out.println(iterator.currentItem());
				iterator.next();
		}
		// fail here
		iterator.next();
	}
	
}

class IterableArray<T> implements Iterable<T> {
	T[] array;

	public IterableArray(T[] array) {
		this.array = array;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Iterator<T> iterator() {
		
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			int position;
			
			{
				init();
			}
			
			private void init() {
				position = 0;
				
			}

			@Override
			public T currentItem() {
				// TODO Auto-generated method stub
				return array[position];
			}


			@Override
			public void next() throws Exception {
				if (isDone()) {
					throw new Exception();
				}
				position++;
			}

			@Override
			public void first() {
				init();
			}

			@Override
			public boolean isDone() {
				// TODO Auto-generated method stub
				return position >= array.length;
			}
		};
	}
}

interface Iterator<T> {
	//currentItem, next, first und isDone.
	
	T currentItem() ;
	
	void next() throws Exception;
	
	void first();
	
	boolean isDone();
}

interface Iterable<T> {
	Iterator<T> iterator();
}

