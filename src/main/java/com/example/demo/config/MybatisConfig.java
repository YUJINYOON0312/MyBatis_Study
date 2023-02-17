package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig; //4번
import com.zaxxer.hikari.HikariDataSource;

//@MapperScan("classpath:/mapper.board") boardmapper에 @mapper 안넣어줄때
//3번
@Configuration
@PropertySource("classpath:/application.properties")
public class MybatisConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	//4번
	public HikariConfig hikariConfig() {
		return new HikariConfig();
		
	}
	
	@Bean
	DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	//싱글톤 구성
	//DataSource dataSource=new HikariDataSource(hikariConfig());
	
	@Autowired // SqlSessionFactory 하고 mapper(6번) 만들고 7번
	ApplicationContext ac;
	
	
	//http://mybatis.org/spring/factorybean.html 5번
	@Bean
	SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    Resource[] mapperLocations=ac.getResources("classpath:/mapper/**/mapper-*.xml");//직접추가 8번
	    factoryBean.setMapperLocations(mapperLocations); //직접추가 //xml파일들
	    factoryBean.setConfiguration(myConfiguration());
	    
	    return factoryBean.getObject();
	}
	
	//9번 이제 propertis 가서 카멜설정
	@Bean
	SqlSessionTemplate sqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	org.apache.ibatis.session.Configuration myConfiguration(){
		//Configuration충돌방지로 이름 길게 경로 넣음
		return new org.apache.ibatis.session.Configuration();
	} 
	
}
