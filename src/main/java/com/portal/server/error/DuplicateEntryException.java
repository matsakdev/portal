package com.portal.server.error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DuplicateEntryException extends RuntimeException{

    Logger logger = LogManager.getLogger(DuplicateEntryException.class);

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
        logger.warn(message, "\n" + cause.getMessage());
    }
}
