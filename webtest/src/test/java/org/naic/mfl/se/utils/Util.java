package org.naic.mfl.se.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
