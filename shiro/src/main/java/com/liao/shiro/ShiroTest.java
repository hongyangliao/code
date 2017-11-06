package com.liao.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @ClassName: ShiroTest
 * @Date 17-10-16 下午1:44
 */
public class ShiroTest {
	@Test
	public void show() {
		//获取SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//创建SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		//将SecurityManager绑定给SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		//创建主体
		Subject subject = SecurityUtils.getSubject();
		//创建用户
		UsernamePasswordToken token = new UsernamePasswordToken("li","456");
		subject.login(token);

		//Assert.assertEquals("用户已登录",false,subject.isAuthenticated());
		subject.logout();
	}
}
