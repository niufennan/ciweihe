package cn.ciweihe.manage.service.wxchat.impl;

import cn.ciweihe.manage.entity.wechat.MenuButton;
import cn.ciweihe.manage.service.wxchat.WxChatService;
import cn.ciweihe.manage.utils.PropsUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/8/28.
 */
@Service
public class WxChatServiceImpl implements WxChatService
{
    private final String propertieName="wxchat.properties";
    private final String urlFormat="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    @Override
    public String getToken() {
        long expiresDate=PropsUtil.getLong(propertieName,"expiresDate");
        String token=PropsUtil.getString(propertieName,"accessToken");
       if (expiresDate==0||"".equals(token)|| expiresDate > (System.currentTimeMillis() / 1000 + 7200)) {
            //超出时间
            String url = String.format(urlFormat, PropsUtil.getString(propertieName,"appid"),PropsUtil.getString("wxchat.properties","appsecret"));
            String result = sendGet(url, null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            PropsUtil.setLong(propertieName,"expiresDate", System.currentTimeMillis() / 1000 + Integer.parseInt(jsonObject.get("expires_in").toString()));
            PropsUtil.setString(propertieName,"accessToken", jsonObject.get("access_token").toString());

        }
        return PropsUtil.getString(propertieName,"accessToken");
    }

    @Override
    public Map<String,Object> getWxChatButton() {
        String menuUrlFormat="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
        String result=sendGet(String.format(menuUrlFormat,PropsUtil.getString(propertieName,"accessToken")),null);
        System.out.println(result);
        JSONObject jsonObject=JSONObject.parseObject(result);
        Map<String,Object> map=new HashMap<>();
        if(jsonObject.containsKey("errcode")){
            map.put("error","接口没有此权限");
        }else{
            map.put("menu",new MenuButton());
        }

        return map;
    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url ;//+ "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            //for (String key : map.keySet()) {
            //    System.out.println(key + "--->" + map.get(key));
            //}
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
