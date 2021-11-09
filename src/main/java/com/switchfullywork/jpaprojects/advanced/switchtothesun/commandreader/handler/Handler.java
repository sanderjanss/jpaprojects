package com.switchfullywork.jpaprojects.advanced.switchtothesun.commandreader.handler;

public interface Handler {

    boolean canHandle(String prefix);

    void handle(String parameter);
}
