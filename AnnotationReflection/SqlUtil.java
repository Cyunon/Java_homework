package AnnotationReflection;

import java.lang.reflect.Field;
import java.util.List;

public class SqlUtil {

    /**
     * ���ݴ���Ĳ������ز�ѯ���
     * @param user
     * @return ���ز�ѯ���
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
     * ���ݴ���Ĳ������ز������
     * @param user
     * @return ���ز������
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
     * ���ݴ���Ĳ������ز������
     * @param users
     * @return ���ز������
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
     * ���ݴ���Ĳ�������ɾ����䣨ɾ��idΪuser.id�ļ�¼��
     * @param user
     * @return ����ɾ�����
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
     * ���ݴ���Ĳ������ظ�����䣨��idΪuser.id�ļ�¼�������ֶθ��³�user�еĶ�Ӧֵ��
     * @param user
     * @return ���ظ������
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
