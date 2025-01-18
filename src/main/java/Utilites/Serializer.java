package Utilites;

import Collections.CustomLinkedList;
import Collections.CustomList;
import Collections.List;

import java.util.regex.Pattern;

public class Serializer {
    public String SerializeList(List list){
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

    private List DeserializeAsList(String value, List list){
        Pattern pattern = Pattern.compile(",");
        String[] strings = pattern.split(value);

        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }

        return list;
    }

    public CustomList DeserializeAsCustomList(String value){
        CustomList result = new CustomList();
        return (CustomList) DeserializeAsList(value, result);
    }

    public CustomLinkedList DeserializeAsCustomLinkedList(String value){
        CustomLinkedList result = new CustomLinkedList();
        return (CustomLinkedList) DeserializeAsList(value, result);
    }
}
