package com.liferay.task.management.constants;

public class TaskPriority {
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_HIGH = 2;

    public static String getPriorityLabel(int priority) {
        switch (priority) {
            case PRIORITY_LOW:
                return "Low";
            case PRIORITY_MEDIUM:
                return "Medium";
            case PRIORITY_HIGH:
                return "High";
            default:
                return "Unknown";
        }
    }
}