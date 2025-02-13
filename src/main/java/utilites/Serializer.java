package utilites;

import collections.CustomLinkedList;
import collections.CustomList;
import collections.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Serializer {
    private final Pattern pattern = Pattern.compile(",");
    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    public String serialize(List list){
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

    public List deserialize(String value, boolean isLinked) {
        List list = (isLinked) ? new CustomLinkedList() : new CustomList();
        try {
            Arrays.stream(pattern.split(value)).forEach(x -> list.add(Integer.parseInt(x)));
        } catch (NumberFormatException e){
            String errorMessage = "Error serializing: "+e;
            logger.error(errorMessage);
        }
        return list;
    }
}
