package com.kobold.objectutils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

public class ObjectHelpers {

	/***
	 * 序列化深克隆对象
	 * @param t 克隆的对象
	 * @param <T>克隆的对象类型
	 * @return
	 */
	public static <T> T deepClone(T t) {
		T result = null;
		if (t == null) {
			return result;
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(t);
			oos.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			result = (T) ois.readObject();
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * equals two objects all value
	 *
	 * @param obj1
	 * @param obj2
	 * @param <T>
	 * @returna
	 */
	public static <T> boolean equalTwoObject(T obj1, T obj2) {
		Class<?> clazzT = obj1.getClass();
		var clazzTFields = clazzT.getDeclaredFields();
		try {
			for (Field field : clazzTFields) {
				field.setAccessible(true);

				if (!field.get(obj1).equals(field.get(obj2)))
					return false;
			}
		} catch (IllegalAccessException e) {
			return false;
		}
		return true;

	}

	/**
	 * equal two objects all value with some value except
	 * @param obj1
	 * @param obj2
	 * @param ignoreField it is a List with the field name you want to ignore
	 * @param <T>
	 * @return
	 */
	public static  <T> boolean equalTwoObject(T obj1, T obj2, List<String> ignoreField) {
		Class<?> clazzT = obj1.getClass();
		var clazzTFields = clazzT.getDeclaredFields();
		try {
			for (Field field : clazzTFields) {
				field.setAccessible(true);
				if (ignoreField.contains(field.getName()))
					continue;
				if (!field.get(obj1).equals(field.get(obj2)))
					return false;
			}
		} catch (IllegalAccessException e) {
			return false;
		}
		return true;
	}
}
