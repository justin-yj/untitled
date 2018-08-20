package com.lw.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author sunping
 * @create 2017/8/21
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages="com.lw")
public class MybatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    /**
     * @param @return
     * @return DataSource
     * @throws
     * @Title: getDataSource
     * @Description: 创建数据源
     */
    @Bean
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.put("driverClass", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));
        props.put("maxWait", env.getProperty("jdbc.maxWait"));
        props.put("maxActive", env.getProperty("jdbc.maxActive"));
        props.put("removeAbandoned", env.getProperty("jdbc.removeAbandoned"));
        props.put("removeAbandonedTimeout", env.getProperty("jdbc.removeAbandonedTimeout"));
        try {
            return DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param @param  ds
     * @param @return
     * @param @throws Exception
     * @return SqlSessionFactory
     * @throws
     * @Title: sqlSessionFactory
     * @Description: 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(ds);
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        sfb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        sfb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));

        sfb.setPlugins(new Interceptor[]{new PageInterceptor()});
        return sfb.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Interceptor getInterceptor() {
        return new PageInterceptor();
    }

}
