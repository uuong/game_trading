package com.sky.shiro;

import com.sky.pojo.User;
import com.sky.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/8/21 0021
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        //if (principals == null) {
        //    return null;
        //} else {
        //    AuthorizationInfo info = null;
        //
        //    info = shiroRedis.getAuthinfo(principals.toString());
        //    if (info == null) {
        //        info = this.doGetAuthorizationInfo(principals);
        //        if (info != null) {
        //            if (log.isTraceEnabled()) {
        //                log.trace("Caching authorization info for principals: [" + principals + "].");
        //            }
        //            shiroRedis.putAuthinfo(principals.toString(), JsonUtil.obj2JsonStr(info));
        //        }
        //    }
        //    return info;
        //}
        return null;
    }
    /**
     * 获取授权信息，在这个方法中，从db获取当前登录用户的角色和资源权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //int userId = Integer.parseInt((String) getAvailablePrincipal(principalCollection));
        //List<UserRoles> userRoles = userRoleService.getRoleByUserId(userId);
        ////通过用户名从数据库获取权限字符串
        //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        ////角色权限
        //Set<String> roleSet = new HashSet<>();
        ////资源权限
        //Set<String> resourcesSet = new HashSet<>();
        //for (UserRoles userRole : userRoles) {
        //    roleSet.add(userRole.getRoleName());
        //    List<RoleResources> resourceList = roleResourcesService.getResourcesByRole(userRole.getRoleId());
        //    for(RoleResources roleResources : resourceList) {
        //        resourcesSet.add(roleResources.getUri() + ":" + roleResources.getMethod());
        //    }
        //}
        //info.setRoles(roleSet);
        //info.setStringPermissions(resourcesSet);
        //return info;
        return null;
    }
    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.selectByUsername(username);
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return aInfo;
    }
}
