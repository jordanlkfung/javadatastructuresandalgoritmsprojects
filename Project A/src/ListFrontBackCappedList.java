import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ListFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {
	private List<T> list;
	private int numberOfElements;
	
    public ListFrontBackCappedList() {
        this(10);
    }

    public ListFrontBackCappedList(int desiredCapacity) {
            @SuppressWarnings("unchecked")
            list = new ArrayList<T>(desiredCapacity);
            numberOfElements = 0;
    }

    public boolean addBack(T newEntry) {
        if (this.isFull())
            return false;
        
        this.list.add(newEntry);
        this.numberOfElements++;
        return true;
    }

    public boolean addFront(T newEntry) {
        if (this.isFull())
            return false;

        this.list.add(0,newEntry);
        numberOfElements++;
        return true;
    }

    public boolean contains(T anEntry) {
        if (!this.isEmpty()) {
            for (int i = 0; i < numberOfElements; i++) {
                if (list.get(i).equals(anEntry)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lastIndexOf(T anEntry) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list.get(i).equals(anEntry))
                return i;
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            list.set(i, null);
        }
        numberOfElements = 0;
    }

    public boolean isFull() {
        return this.numberOfElements == this.list.length;
    }
    public String toString() {
    	@SuppressWarnings("unchecked")
    	T[] temp= (T[])new Object[numberOfElements];
    	for(int i=0;i<numberOfElements;i++) {
    		temp[i]=list[i];
    	}
        return "size: "+numberOfElements+
                "; capacity: "+list.length+
                "; List contents: "+Arrays.toString(temp);
    }

    public T removeFront() {
        if(!this.isEmpty()) {
            T temp = this.list[0];
            for(int i=0;i<this.numberOfElements-1;i++) {
                this.list[i]=this.list[i+1];
            }
            this.list[numberOfElements-1]=null;
            numberOfElements--;
            return temp;
        }
        else
            return null;
    }

    public T removeBack() {
        if(!this.isEmpty()) {
            T temp = this.list[numberOfElements-1];
            this.list[numberOfElements-1]=null;
            numberOfElements--;
            return temp;
        }
        else
            return null;
    }

    public int indexOf(T object) {
        for(int i=0;i<numberOfElements;i++) {
            if(this.list[i].equals(object))
                return i;
        }
        return -1;
    }

    public T getEntry(int givenPosition) {
        if(isEmpty()
                ||(givenPosition>=numberOfElements||givenPosition<0))
            return null;
        else {
            return this.list[givenPosition];
        }
    }

    public boolean isEmpty() {
        if(numberOfElements==0)
            return true;
        else
            return false;
    }
    public int size() {
        return numberOfElements;
    }
	
}
