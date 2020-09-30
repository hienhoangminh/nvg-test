package utils;

import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;

public class ComparatorHelper {

    private static ComparatorHelper instance;

    private ComparatorHelper() {
    }

    public static ComparatorHelper getInstance() {
        if (instance == null)
            instance = new ComparatorHelper();
        return instance;
    }

    public static boolean isSorted(List<String> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

}
