package com.redis.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redis.component.CacheLock;
import com.redis.component.LockedObject;

public class DoSomething {
    private static Logger logger = LoggerFactory.getLogger(DoSomething.class);

    @CacheLock(lockedPrefix = "ACCEPT_ORDER")
    public void acceptOrder(@LockedObject long orderId) {
        logger.info(String.valueOf(orderId));
    }

}
