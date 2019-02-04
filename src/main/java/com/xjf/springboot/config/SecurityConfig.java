package com.xjf.springboot.config;

import com.xjf.springboot.encoder.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * @author xjf
 * @date 2019/2/4 10:21
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //都可以访问
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()
                //需要相应的角色才能访问
                .antMatchers("/users").hasRole("ADMIN")
                .and()
                //基于form表单验证登录
                .formLogin()
                //自定义登录页面
                .loginPage("/login").failureUrl("/login-error");

        /*//关闭默认的csrf认证
        http.csrf().disable();*/
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        /*auth
                //认证信息存于内存中
                .inMemoryAuthentication()
                .withUser("xjf").password("123456").roles("ADMIN");*/


        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth
            .inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
            .withUser("xjf").password("123456").roles("ADMIN")
            .and()
            .withUser("dale").password("123456").roles("USER");
    }
}
