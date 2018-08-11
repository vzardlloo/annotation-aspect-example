package com.example.vzard.generator;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {


    public static void main(String[] args) {

        AutoGenerator generator = new AutoGenerator();

        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setAuthor("lucailei");
        globalConfig.setOutputDir("D:\\annotation-aspect-example\\src\\main\\java");
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false);
        globalConfig.setFileOverride(true);
        globalConfig.setIdType(IdType.ID_WORKER);


        generator.setGlobalConfig(globalConfig);


        TemplateConfig templateConfig = new TemplateConfig();

        generator.setTemplate(templateConfig);


        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("5432");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost/demo?useSSL=false&characterEncoding=utf8");

        generator.setDataSource(dataSourceConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);

        generator.setStrategy(strategyConfig);


        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.vzard");

        generator.setPackageInfo(packageConfig);

        generator.execute();


    }


}
