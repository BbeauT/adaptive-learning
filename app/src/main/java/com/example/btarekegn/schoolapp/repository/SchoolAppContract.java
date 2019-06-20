package com.example.btarekegn.schoolapp.repository;

import android.provider.BaseColumns;

public final class SchoolAppContract {

    private SchoolAppContract() {}

    /* Inner class that defines the table contents */
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_FULL_NAME = "fullname";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_PASSWORD = "password";
    }

    public static final String SQL_CREATE_USER =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    UserEntry.COLUMN_FULL_NAME + " TEXT," +
                    UserEntry.COLUMN_EMAIL + " TEXT NOT NULL UNIQUE," +
                    UserEntry.COLUMN_ROLE + " TEXT," +
                    UserEntry.COLUMN_GENDER + " TEXT," +
                    UserEntry.COLUMN_PASSWORD + " TEXT)";

    public static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;



    /* Inner class that defines the table contents */
    public static class RoleEntry implements BaseColumns {
        public static final String TABLE_NAME = "role";
        public static final String COLUMN_ROLE_TYPE = "roleType";
    }



    public static final String SQL_CREATE_ROLE =
            "CREATE TABLE " + RoleEntry.TABLE_NAME + " (" +
                    RoleEntry._ID + " INTEGER PRIMARY KEY," +
                    RoleEntry.COLUMN_ROLE_TYPE + " TEXT)";

    public static final String SQL_DELETE_ROLE =
            "DROP TABLE IF EXISTS " + RoleEntry.TABLE_NAME;
}
