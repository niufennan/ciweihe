package cn.ciweihe.manage.entity.wechat;

/**
 * Created by Administrator on 2017/8/21.
 */
public class MenuButton {
    private String name;
    private String type;
    private MenuButton sub_button;

    public MenuButton(){
        this.setName("button");
        this.setType("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public MenuButton getSub_button() {
        return sub_button;
    }

    public void setSub_button(MenuButton sub_button) {
        this.sub_button = sub_button;
    }
}
