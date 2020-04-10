package AnnotationReflection;

import java.lang.reflect.Field;
import java.util.List;

public class SqlUtil {

    /**
     * 根据传入的参数返回查询语句
     * @param user
     * @return 返回查询语句
     */
    String query(User user) {
    	Class us = user.getClass();
    	String tablename = null;
    	int idvalue = 0;
    	String namevalue = null;
    	if(us.isAnnotationPresent(Table.class)) {
    		Table table = (Table) us.getAnnotation(Table.class);
    		tablename = table.value();
    	}
    	String result = "SELECT * FROM " + tablename;
    	try {
			Field id = us.getDeclaredField("id");
			Field name = us.getDeclaredField("username");
			name.setAccessible(true);
			if(id.isAnnotationPresent(Column.class)) {
				id.setAccessible(true);
				idvalue = id.getInt(user);
			}
			if(name.isAnnotationPresent(Column.class)) {
				name.setAccessible(true);
				namevalue = (String) name.get(user);
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(idvalue!=0) {
    		result += " WHERE id = " + String.valueOf(idvalue) + ";";
    	}
    	else {
    		result += " WHERE username LIKE '" + namevalue + "';";
    	}
		return result;
	}

    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     */
    String insert(User user) {
    	Class us = user.getClass();
    	String tablename = null;
    	if(us.isAnnotationPresent(Table.class)) {
    		Table table = (Table) us.getAnnotation(Table.class);
    		tablename = table.value();
    	}
    	String result = "INSERT INTO " + tablename + " ('username', 'age', 'email', 'telephone') VALUES (";
    	Field [] fields = us.getDeclaredFields();
    	for(int i=0; i<fields.length; i++) {
    		if(fields[i].isAnnotationPresent(Column.class)) {
    			fields[i].setAccessible(true);
    			try {
    				if(fields[i].getName().equals("username")) {
    					result += "'" + fields[i].get(user) + "'" + ", ";
    				}
    				if(fields[i].getName().equals("age")) {
    					result += String.valueOf(fields[i].getInt(user)) + ", ";
    				}
    				if(fields[i].getName().equals("email")) {
    					result += "'" + fields[i].get(user) + "'" + ", ";
    				}
    				if(fields[i].getName().equals("telephone")) {
    					result += "'" + fields[i].get(user) + "'" + ")";
    				}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
		return result;
	}

    /**
     * 根据传入的参数返回插入语句
     * @param users
     * @return 返回插入语句
     */
    String insert(List<User> users) {
    	Class temp = users.get(0).getClass();
    	String tablename = null;
    	if(temp.isAnnotationPresent(Table.class)) {
    		Table table = (Table) temp.getAnnotation(Table.class);
    		tablename = table.value();
    	}
    	String result = "INSERT INTO " + tablename + " ('username', 'age', 'email', 'telephone') VALUES ";
    	for(User user : users) {
    		Class us = user.getClass();
    		Field [] fields = us.getDeclaredFields();
        	for(int i=0; i<fields.length; i++) {
        		if(fields[i].isAnnotationPresent(Column.class)) {
        			fields[i].setAccessible(true);
        			try {
        				if(fields[i].getName().equals("username")) {
        					result += "('" + fields[i].get(user) + "'" + ", ";
        				}
        				if(fields[i].getName().equals("age")) {
        					result += String.valueOf(fields[i].getInt(user)) + ", ";
        				}
        				if(fields[i].getName().equals("email")) {
        					result += "'" + fields[i].get(user) + "'" + ", ";
        				}
        				if(fields[i].getName().equals("telephone")) {
        					result += "'" + fields[i].get(user) + "'" + ")";
        				}
    				} catch (IllegalArgumentException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (IllegalAccessException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
        		}
        	}
        	if(users.size() - 1 != users.indexOf(user)) {
        		result += ", ";
        	}
    	}
		return result;
	}

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     * @param user
     * @return 返回删除语句
     */
    String delete(User user) {
    	Class us = user.getClass();
    	String tablename = null;
    	int idvalue = 0;
    	if(us.isAnnotationPresent(Table.class)) {
    		Table table = (Table) us.getAnnotation(Table.class);
    		tablename = table.value();
    	}
    	String result = "DELETE FROM " + tablename;
    	try {
			Field id = us.getDeclaredField("id");
			if(id.isAnnotationPresent(Column.class)) {
				id.setAccessible(true);
				idvalue = id.getInt(user);
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	result += " WHERE id = " + String.valueOf(idvalue);
		return result;
	}
/**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     * @param user
     * @return 返回更新语句
     */
    String update(User user) {
    	Class us = user.getClass();
    	String tablename = null;
    	int idvalue = 0;
    	String email = null;
    	if(us.isAnnotationPresent(Table.class)) {
    		Table table = (Table) us.getAnnotation(Table.class);
    		tablename = table.value();
    	}
    	String result = "UPDATE " + tablename;
    	try {
			Field id = us.getDeclaredField("id");
			Field name = us.getDeclaredField("email");
			name.setAccessible(true);
			if(id.isAnnotationPresent(Column.class)) {
				id.setAccessible(true);
				idvalue = id.getInt(user);
			}
			if(name.isAnnotationPresent(Column.class)) {
				name.setAccessible(true);
				email = (String) name.get(user);
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	result += " SET email = '" + email + "'" + " WHERE id = " + String.valueOf(idvalue);
		return result;
    }
}
