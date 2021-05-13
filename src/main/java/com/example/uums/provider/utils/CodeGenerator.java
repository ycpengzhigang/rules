package com.example.uums.provider.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * zhigang.peng
 * 2021/3/3
 * 代码生成器
 */
public class CodeGenerator {

    public static void main(String[] args) {
        CodeGenerator g = new CodeGenerator();
        boolean startWithI = false;
        String packageName = "com.example.uums.provider";
        String[] tableName = {"t_test_user"};
        g.generateByTables(startWithI, packageName, tableName);
    }

    public static void generate(boolean startWithI, String packageName, String... tableName) {
        CodeGenerator g = new CodeGenerator();
        g.generateByTables(startWithI, packageName, tableName);
    }

    /**
     * 根据表自动生成
     *
     * @param serviceNameStartWithI 默认为false
     * @param packageName           包名
     * @param tableNames            表名
     */
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        // 配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        // 全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        // 包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        // 自动生成
        autoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     */
    private void autoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    /**
     * 设置包名
     *
     * @param packageName 父路径包名
     * @return PackageConfig 包名配置
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setXml("mapper")
                .setMapper("mapper")
                .setController("controller")
                .setService("service")
                .setEntity("model");
    }

    /**
     * 全局配置
     *
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig
                .setOpen(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setActiveRecord(false)
                .setAuthor("zhigang.peng")
                // 设置输出路径
                .setOutputDir(System.getProperty("user.dir") + "/" + "/src/main/java/")
//                .setSwagger2(true) 是否生成swagger
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            // 设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(false)
                // 从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的的表名，多个表名传数组
                .setTablePrefix("t_")
                .setInclude(tableNames);
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     */
    private DataSourceConfig getDataSourceConfig() {
        Properties properties = getProperties();
//        return new DataSourceConfig().setDbType(DbType.MYSQL)
//                .setUrl("jdbc:mysql://localhost:3306/saas?serverTimezone=Hongkong&nullCatalogMeansCurrent=true&characterEncoding=UTF-8&useSSL=false")
//                .setUsername("root")
//                .setPassword("Pzg131775")
//                .setDriverName("com.mysql.cj.jdbc.Driver");
        return new DataSourceConfig().setDbType(DbType.MYSQL)
                .setUrl(properties.getProperty("url"))
                .setUsername(properties.getProperty("username"))
                .setPassword(properties.getProperty("password"))
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        if (fieldType.toLowerCase().contains("tinyint")) {
                            return DbColumnType.INTEGER;
                        }
                        if (fieldType.toLowerCase().contains("datetime")) {
                            return DbColumnType.DATE;
                        }
                        if (fieldType.toLowerCase().contains("timestamp")) {
                            return DbColumnType.DATE;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }

                });
    }

    /**
     * @return
     */
    private Properties getProperties() {
        Resource resource = new ClassPathResource("conf/code.properties");
        Properties properties = new Properties();
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
