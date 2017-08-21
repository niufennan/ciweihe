package cn.ciweihe.manage.entity.wechat;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ClickMenuButton extends MenuButton {
    //长度不能超过128
    private String key;

    public  ClickMenuButton(){
        this.setType("click");
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
