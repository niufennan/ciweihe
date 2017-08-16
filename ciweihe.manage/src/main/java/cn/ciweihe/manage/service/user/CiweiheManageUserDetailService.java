package cn.ciweihe.manage.service.user;

import cn.ciweihe.manage.entity.user.CiweiheManageUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/16.
 */
//@Service
public class CiweiheManageUserDetailService implements UserDetailsService {
    private List<CiweiheManageUserDetails> userDetailss;
    public CiweiheManageUserDetailService(){
        userDetailss=new ArrayList<>();
        userDetailss.add(new CiweiheManageUserDetails(1L,"admin","admin",true,null));
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        for(CiweiheManageUserDetails ciweiheManageUserDetails: userDetailss){
            if(ciweiheManageUserDetails.getUsername().equals(s)){
                return ciweiheManageUserDetails;
            }
        }
        return null;
    }
}
