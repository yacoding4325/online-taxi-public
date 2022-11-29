package com.yacoding.serviceorder.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-order?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root","yxym")
                .globalConfig(builder -> {
                    builder.author("cpf").fileOverride().outputDir("G:\\online-taxi-public\\service-order\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.yacoding.serviceorder").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "G:\\online-taxi-public\\service-order\\src\\main\\java\\com\\yacoding\\serviceorder\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("order_info");

                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
