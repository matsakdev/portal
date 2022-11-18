package com.portal.server.dao;

public interface DaoProcessor<Session, T, R> {
    R apply(Session session, T t);
}
