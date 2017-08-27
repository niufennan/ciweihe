package cn.ciweihe.wxchat.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/8/25.
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
}
