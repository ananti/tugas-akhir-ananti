/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinpoint.util;

import java.sql.*;
/**
 *
 * @author Ananti
 */
public class Database {

    private Connection connection;   
    private String username;
    private String password;
    private String hostname;
    private String database;

    public Database()
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());           

            this.hostname = "localhost";
            this.database = "pinpoint";
            this.username = "pinpoint";
            this.password = "pinpoint";
        }
        catch (SQLException e)
        {
            System.out.println(this.getClass().getName() + " Exception: " + e.getMessage());
        }
    }

    public boolean open()
    {
        boolean retval = false;

        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + database, username, password);
            retval = true;
        }
        catch (Exception e)
        {
            System.out.println(this.getClass().getName() + " Exception: " + e.getMessage());
        }

        return retval;
    }

    public boolean open(String hostname_, String database_, String username_, String password_)
    {
        boolean retval = false;

        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname_ + "/" + database_, username_, password_);
            retval = true;
        }
        catch (Exception e)
        {
            System.out.println(this.getClass().getName() + " Exception: " + e.getMessage());
        }

        return retval;
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void close()
    {
        try
        {
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(this.getClass().getName() + " Error: " + e.getMessage());
        }
    }
}
