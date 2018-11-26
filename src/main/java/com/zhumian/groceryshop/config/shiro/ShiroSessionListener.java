package com.zhumian.groceryshop.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
@Slf4j
public class ShiroSessionListener implements SessionListener {

    @Override
    public void onStart(Session session) {
        log.info("session start");
    }

    @Override
    public void onStop(Session session) {
        log.info("session stop");
    }

    @Override
    public void onExpiration(Session session) {
        log.info("session 过期");
    }
}
