package com.kobold.objectutils;

import java.io.*;

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

            ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bais);
            result=(T)ois.readObject();
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
