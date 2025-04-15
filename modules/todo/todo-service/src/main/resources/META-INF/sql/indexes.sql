create index IX_F6629FE9 on Todo_TodoItem (groupId, completed);
create index IX_31465E4C on Todo_TodoItem (groupId, userId);
create unique index IX_1DF91962 on Todo_TodoItem (groupId, uuid_[$COLUMN_LENGTH:75$]);
create index IX_8339A71C on Todo_TodoItem (uuid_[$COLUMN_LENGTH:75$]);