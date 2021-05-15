package com.asb.todoapp.todo.entity.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Status {
    CREATED, COMPLETED, POSTPONED, DELETED;

    public static List<Status> getActiveStatusList() {
        return Arrays.asList(Status.CREATED, Status.COMPLETED, Status.POSTPONED);
    }
}
