package ru.innopolis.bs3_1.zamaleev.untils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilgiz on 09.11.2016.
 */
public class AssertionsMethods {

    private static Pattern space = Pattern.compile("\\s*");
    private static Matcher matcher;

    public static boolean isEmptyString(String s) {
        matcher = space.matcher(s);
        return (s != null && !matcher.matches());
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

}
