package com.liferay.task.management.constants;

public class TaskStatus {
    public static final int STATUS_OPEN = 0;
    public static final int STATUS_IN_PROGRESS = 1;
    public static final int STATUS_COMPLETED = 2;

    public static String getStatusLabel(int status) {
        switch (status) {
            case STATUS_OPEN:
                return "Open";
            case STATUS_IN_PROGRESS:
                return "In Progress";
            case STATUS_COMPLETED:
                return "Completed";
            default:
                return "Unknown";
        }
    }
}