import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLinkedList implements CustomLists{
    private int size;
    private CustomListElement start;
    private CustomListElement end;
    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    private CustomListElement getElementByIndex(int index){
        if(size == 0){
            logger.error("Index is out of list size");
            return null;
        }

        int midSize = size / 2;
        CustomListElement currentElement;

        if(index < midSize) {
            currentElement = start;
            int count = 0;
            while (count < index) {
                currentElement = currentElement.getNext();
                count++;
            }
        }else{
            currentElement = end;
            int count = size - 1;
            while(count > index){
                currentElement = currentElement.getPrevious();
                count--;
            }
        }
        return currentElement;
    }

    @Override
    public int getByIndex(int index) throws RuntimeException {
        CustomListElement element = this.getElementByIndex(index);
        if(element == null){
            throw new RuntimeException("Index is out of list size");
        }

        return element.getValue();
    }

    @Override
    public boolean removeByIndex(int index) {
        if(size == 0){
            logger.error("Index is out of list size");
            return false;
        }

        CustomListElement currentElement = this.getElementByIndex(index);
        if(currentElement == null){
            return false;
        }

        CustomListElement prevElement = currentElement.getPrevious();
        CustomListElement nextElement = currentElement.getNext();

        if(prevElement != null){
            prevElement.setNext(nextElement);
        }

        if(nextElement != null){
            nextElement.setPrevious(prevElement);
        }

        if(this.start == currentElement){
            this.start = nextElement;
        }

        if(this.end == currentElement){
            this.end = prevElement;
        }

        size--;
        return true;
    }

    @Override
    public boolean removeElement(int value) {
        int[] foundIndexes = new int[size];
        int count = 0;
        for(int i = 0; i < size; i++){
            CustomListElement element = this.getElementByIndex(i);
            if(element == null){
                return false;
            }

            if(element.getValue() == value){
                foundIndexes[count] = i;
                count++;
            }
        }

        for(int i=0; i<count; i++){
            boolean result = this.removeByIndex(foundIndexes[i]-i);
            if(!result){
                return false;
            }
        }

        return true;
    }

    @Override
    public void add(int i) {
        CustomListElement newElement = new CustomListElement(i);

        if(start == null){
            start = newElement;
        }

        if(end != null){
            end.setNext(newElement);
            newElement.setPrevious(end);
        }
        end = newElement;

        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

}
