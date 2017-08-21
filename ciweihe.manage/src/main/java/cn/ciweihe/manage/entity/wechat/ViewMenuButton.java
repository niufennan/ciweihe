package cn.ciweihe.manage.entity.wechat;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ViewMenuButton extends MenuButton {
    //不超过1024字节
    private String url;

    public ViewMenuButton(){
        this.setType("view");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
