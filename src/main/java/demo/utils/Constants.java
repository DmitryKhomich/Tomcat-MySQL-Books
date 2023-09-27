package demo.utils;

import demo.credentials.Credentials;

public final class Constants {

    public final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/";
    public final static String DB_NAME = "demo_db";
    public final static String DB_USER = "dev";

    public final static String PATH_TO_PASS = "INFO/cred.txt";

    public final static String PASS = Credentials.readPass();
}
