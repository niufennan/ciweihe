package cn.ciweihe.wxchat.utils;

import groovyjarjarantlr.StringUtils;

import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/8/28.
 */
public class PropsUtil {
    public static Properties loadProps(String fileName){
        Properties properties=null;
        InputStream is=null;
        try {
            is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is==null){
                throw  new FileNotFoundException( fileName+"file is not found");
            }
            properties=new Properties();

            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }

    public static String getString(String fileName,String key){
        return getString(loadProps(fileName),key);
    }

    public static String getString(Properties props,String key,String defaultValue){
        String value=defaultValue;
        if(props.containsKey(key)){
            value=props.getProperty(key);
        }
        return value;
    }

    public static Long getLong(Properties props,String key,Long defaultValue){
        Long value=defaultValue;
        String strValue=getString(props,key);
        if(Pattern.matches("\\d+",strValue)){
            value=Long.parseLong(strValue);
        }
        return value;
    }

    public static Long getLong(Properties props,String key){
        return getLong(props,key,0L);
    }

    public static Long getLong(String fileName,String key){
        return getLong(loadProps(fileName),key);
    }

    public static void setString(String fileName,String key,String value){
        Properties props=loadProps(fileName);
        if(props.containsKey(key)) {
            props.setProperty(key, value);
            OutputStream os= null;
            try {
                String path=Thread.currentThread().getContextClassLoader().getResource("wxchat.properties").getPath();
                os = new FileOutputStream(path);
                props.store(os,"");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(os!=null)
                {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void setLong(String fileName,String key,Long value){
        setString(fileName,key,String.valueOf(value));
    }

}
