public class CustomLinkedList implements CustomLists{
    private int size;

    private CustomListElement start;
    private CustomListElement end;

    CustomLinkedList(){
        start = null;
        end = null;
    }

    private CustomListElement getElementByIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Index is out of list size");
        }

        int midSize = size / 2;
        CustomListElement currentElement = null;

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
    public int getByIndex(int index) throws ArrayIndexOutOfBoundsException {
        return this.getElementByIndex(index).getValue();
    }

    @Override
    public void removeByIndex(int index) throws ArrayIndexOutOfBoundsException {
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("Index is out of list size");
        }

        CustomListElement currentElement = this.getElementByIndex(index);
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
    }

    @Override
    public void removeElement(int value) throws ArrayIndexOutOfBoundsException {
        int[] foundIndexes = new int[size];
        int count = 0;
        for(int i = 0; i < size; i++){
            CustomListElement element = this.getElementByIndex(i);
            if(element.getValue() == value){
                foundIndexes[count] = i;
                count++;
            }
        }

        for(int i=0; i<count; i++){
            this.removeByIndex(foundIndexes[i]-i);
        }
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
