package com.markerhub.util;

import org.slf4j.Logger;

public class LogUtil {

    public static void info(Logger logger, Object... objects) {
        if (logger.isInfoEnabled()) {
            String message = messageBuild(objects);
            logger.info(message);
        }
    }

    public static void error(Logger logger, Object... objects) {
        if (logger.isErrorEnabled()) {
            String message = messageBuild(objects);
            logger.info(message);
        }
    }


    private static String messageBuild(Object... objects) {
        StringBuilder stringBuffer = new StringBuilder();
        for (Object object : objects) {
            stringBuffer.append(object.toString());
            stringBuffer.append("|");
        }
        return stringBuffer.toString();
    }
}
