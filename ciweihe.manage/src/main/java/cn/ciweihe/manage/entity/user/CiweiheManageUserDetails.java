package cn.ciweihe.manage.entity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by admin on 2017/8/16.
 */
public class CiweiheManageUserDetails implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
    public CiweiheManageUserDetails(Long id,String username,String password,boolean enabled,Collection<? extends GrantedAuthority> authorities){
        this.id=id;
        this.username=username;
        this.password=password;
        this.enabled=enabled;
        if(authorities!=null){
        this.authorities=authorities;
        }else{

        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
