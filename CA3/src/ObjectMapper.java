/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author jmccarthy
 */
public class ObjectMapper {

    public int id = 0;

    // not used
    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    // save method. If the id is 0, the object doesn't exist in the db (use an insert)
    // if the id is > 0, we should use update
    public void save() {
        if (this.id == 0) {
            // new object
            create();
        } else {
            // existing row in DB
            update();
        }
    }

    public void create() {
        try {
            // String to hold the fields for the insert statement
            String insert_fields = "";
            
            // String to hold the values for the insert statement 
            String insert_values = "";
            
            // counter used to manage the commas between statements
            int counter = 0;
            
            // Get a reference to the object we are dealing with. eg. Student
            Class<?> objClass = this.getClass();
            
            // get the name of the class. Append 's' to the name to get the database table name 
            String db_tableName = objClass.getSimpleName() + "s";
            
            // Get an array of all the fields in the class. eg for student (classname, firstname, lastname, age)
            Field[] fields = objClass.getFields();

            // loop through the fields array
            for (int i = 0; i < fields.length - 1; i++) {
                // get the field name
                String name = fields[i].getName();
                
                // get the field value
                Object value = fields[i].get(this);
                
                // manage where to put the commas in the insert statement, the first needs to be dealt with as a special case
                if (counter == 0) {
                    insert_fields = insert_fields + name;
                } else {
                    insert_fields = insert_fields + ", " + name;
                }
                
                
                // use a switch statement to try figure what type of variable we have (int or string)
                switch (value.getClass().toString()) {
                    // if we have a string, wrap it with single quotes
                    case "class java.lang.String":
                    	//If name contains apostrophe replace it with blank space
                    	value = value.toString().replace("'", " ");

                        if (counter == 0) {
                            insert_values = insert_values + "'" + value.toString() + "'";
                        } else {
                            insert_values = insert_values + ", " + "'" + value.toString() + "'";
                        }
                        break;
                    case "class java.lang.Integer":
                        if (counter == 0) {
                            insert_values = insert_values + value.toString();
                        } else {
                            insert_values = insert_values + ", " + value.toString();
                        }
                        break;
                    default:
                        // Something went wrong if we got here!!
                        break;

                }
                
                counter += 1;
            }
            
            // build the insert statement
            String sql = "insert into " + db_tableName + " (" + insert_fields + ") values (" + insert_values + ");";
            System.out.println(sql);
            // execute the statement and get the row id in the as a return, store in this.id
            this.id = dbExecuteStatement(sql);
            
            //System.out.println(this.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            // String variable to hold the update statements
            String update_cols = "";
            
            // counter used to manage the commas between statements
            int counter = 0;

            // Get a reference to the object we are dealing with. eg. Student
            Class<?> objClass = this.getClass();
            
            // get the name of the class. Append 's' to the name to get the database table name 
            String db_tableName = objClass.getSimpleName() + "s";
            
            // Get an array of all the fields in the class. eg for student (classname, firstname, lastname, age)
            Field[] fields = objClass.getFields();

            // loop through the fields array
            for (int i = 0; i < fields.length - 1; i++) {
                // get the field name
                String name = fields[i].getName();
                
                // create a string to hold the field value
                String fieldValue = "";
                
                // get the field value
                Object value = fields[i].get(this);
                
                
                // use a switch statement to try figure what type of variable we have (int or string)
                switch (value.getClass().toString()) {
                    // if we have a string, wrap it with single quotes
                    case "class java.lang.String":
                        fieldValue = name + " = '" + value.toString() + "'";
                        break;
                    case "class java.lang.Integer":
                        fieldValue = name + " = " + value.toString();
                        break;
                    default:
                        // Something went wrong if we got here!!
                        break;
                }

                // manage where to put the commas in the update statement, the first needs to be dealt with as a special case
                if (counter == 0) {
                    update_cols = fieldValue;
                } else {
                    update_cols = update_cols + ", " + fieldValue;
                }
                counter += 1;
            }
            
            // create the update statement
            String sql = "UPDATE " + db_tableName + " SET " + update_cols + " WHERE id=" + this.id + ";";
            
            // execute the statement
            dbExecuteStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        Class<?> objClass = this.getClass();
        String db_tableName = objClass.getSimpleName() + "s";
        String sql = "DELETE FROM " + db_tableName + " WHERE id=" + this.id + ";";
        // execute the statement
        dbExecuteStatement(sql);
    }

    public static void find(String type, int id) {

    }

    public static void findAll(String type) {

    }

    private int dbExecuteStatement(String sql) {
        Connection c = null;
        Statement stmt = null;
        int row = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:patients.sqlite");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            
            stmt.executeUpdate(sql);
            
            row = stmt.getGeneratedKeys().getInt(1);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return row;
    }
}
