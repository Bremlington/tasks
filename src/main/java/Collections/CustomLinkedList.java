package Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class CustomLinkedList implements List {
    private int size;
    private CustomListElement start;
    private CustomListElement end;
    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    private int[] toArray(){
        int[] values = new int[size];

        int count = 0;
        CustomListElement currElement = start;
        while(!currElement.isEmpty()){
            values[count] = currElement.getValue();

            currElement = currElement.getNext();
            count++;
        }

        return values;
    }

    public CustomLinkedList() {
        this.start = new CustomListElement();
        this.end = new CustomListElement();
        this.size = 0;
    }

    private CustomListElement getElementByIndex(int index){
        if(size == 0){
            logger.error("Index is out of list size");
            return new CustomListElement();
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
        if(element.isEmpty()){
            throw new RuntimeException("Index is out of size");
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
        if(currentElement.isEmpty()){
            return false;
        }

        CustomListElement prevElement = currentElement.getPrevious();
        CustomListElement nextElement = currentElement.getNext();

        if(!prevElement.isEmpty()){
            prevElement.setNext(nextElement);
        }

        if(!nextElement.isEmpty()){
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
            if(element.isEmpty()){
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

        if(start.isEmpty()){
            start = newElement;
        }

        if(!end.isEmpty()){
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
