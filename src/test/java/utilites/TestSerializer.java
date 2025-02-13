package utilites;

import collections.CustomList;
import collections.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSerializer {

    @Test
    void testSerialize(){
        Serializer serializer = new Serializer();
        CustomList list = new CustomList();

        String empty = serializer.serialize(list);
        assertTrue(empty.isEmpty());

        list.add(10);
        list.add(20);
        list.add(30);

        String notEmpty = serializer.serialize(list);
        assertEquals(notEmpty, "10,20,30");
    }

    @Test
    void testDeserialize(){
        Serializer serializer = new Serializer();

        String emptyString = "";
        List emptyList = serializer.deserialize(emptyString, false);
        assertEquals(0, emptyList.getSize());

        String correctString = "10,20,30,30";
        List correctList = serializer.deserialize(correctString, false);
        assertEquals(4, correctList.getSize());
        assertEquals(10, correctList.getByIndex(0));
        assertEquals(20, correctList.getByIndex(1));
        assertEquals(30, correctList.getByIndex(2));
        assertEquals(30, correctList.getByIndex(3));

        String wrongString = "wrong string";
        List wrongList = serializer.deserialize(wrongString, false);
        assertEquals(0, wrongList.getSize());
    }
}
