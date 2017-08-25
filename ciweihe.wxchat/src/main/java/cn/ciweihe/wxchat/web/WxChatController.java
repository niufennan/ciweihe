package cn.ciweihe.wxchat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by admin on 2017/8/25.
 */
@Controller
public class WxChatController {
    @RequestMapping("/wxchat")
    @ResponseBody
    public String wxchat(HttpServletRequest request){
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        String token="01234554321abcdefghigk";
        String[] paramArr = new String[] { token, timestamp, nonce };
        Arrays.sort(paramArr);
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
        String result=EncoderByMd5(content);
         //通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
        if (result != null&&result.equals(signature.toUpperCase())) {
            return echostr;
        }
        return "";
    }

    public String EncoderByMd5(String str)
    {
        String ciphertext = null;
        try{
            //确定计算方法
            MessageDigest md= MessageDigest.getInstance("SHA-1");
            //BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            //String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));

            byte[] digest = md.digest(str.toString().getBytes());
            ciphertext = byteToStr(digest);

            return ciphertext;
        }catch(Exception ex){
            return "";
        }
    }
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
