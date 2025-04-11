create index IX_7EB35668 on TaskManagement_Task (groupId);
create index IX_660E2D68 on TaskManagement_Task (status);
create index IX_78D46BC on TaskManagement_Task (userId);
create unique index IX_EFA541F8 on TaskManagement_Task (uuid_[$COLUMN_LENGTH:75$], groupId);