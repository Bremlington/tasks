package Utilites;

import Collections.CustomLinkedList;
import Collections.CustomList;
import Collections.List;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Serializer {
    private final Pattern pattern = Pattern.compile(",");

    public String Serialize(List list){
        int listSize = list.getSize();
        if(listSize==0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        for(int i=0; i < listSize; i++){
            result.append(list.getByIndex(i));
            result.append(",");
        }
        result.deleteCharAt(result.lastIndexOf(","));

        return result.toString();
    }

    public List Deserialize(String value, boolean isLinked){
        List list = (isLinked) ? new CustomLinkedList() : new CustomList();
        String[] strings = pattern.split(value);
        Stream<String> stream = Arrays.stream(strings);
        stream.forEach(x->list.add(Integer.parseInt(x)));

        return list;
    }
}
