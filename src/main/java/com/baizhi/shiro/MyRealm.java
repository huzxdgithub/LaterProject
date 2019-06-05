package com.baizhi.shiro;

import com.baizhi.Dto.Role;
import com.baizhi.cache.ApplicationUtils;
import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        AdminMapper getclazz = (AdminMapper) ApplicationUtils.getclazz(AdminMapper.class);
        Admin admin = getclazz.login(primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo=null;
        if (admin!=null){
            List<Role> roles = getclazz.selectAllRoleAndJurisdiction(admin.getId());
            Set<String> roleSet = new HashSet<>();
            Set<String> jurisdictionSet = new HashSet<>();
            for (Role role : roles) {
                System.out.println(role.getRoleName()+"角色");
                roleSet.add(role.getRoleName());
                List<String> jurisdiction = role.getJurisdiction();
                for (String s : jurisdiction) {
                    System.out.println(s+"权限");
                    jurisdictionSet.add(s);
                }
            }
            simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRoles(roleSet);
            simpleAuthorizationInfo.addStringPermissions(jurisdictionSet);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        AdminMapper getclazz = (AdminMapper) ApplicationUtils.getclazz(AdminMapper.class);
        Admin admin = getclazz.login(principal);
        SimpleAuthenticationInfo simpleAuthenticationInfo=null;
        if(admin!=null){
             simpleAuthenticationInfo = new SimpleAuthenticationInfo(
            admin.getAdminName(), admin.getAdminPassword(),ByteSource.Util.bytes(admin.getSalt()), this.getName());
        }
        return simpleAuthenticationInfo;
    }
}
