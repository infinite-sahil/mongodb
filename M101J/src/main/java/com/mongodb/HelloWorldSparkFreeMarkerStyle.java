package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by somebody on 1/17/2017.
 */
public class HelloWorldSparkFreeMarkerStyle {

    public static void main(String[] args) {
        /**
         * create Configuration
         * set class for Template loading
         * create StringWriter
         * create template
         * Create Map
         * process template and pass (map, stringWriter)
         *
         */
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");

        Spark.get("/", (req, res) -> {
            StringWriter stringWriter = new StringWriter();
            try {
                Template helloTemplate = configuration.getTemplate("hello.ftl");
                Map<String, Object> helloMap = new HashMap();
                helloMap.put("name", "Freemarker");
                helloTemplate.process(helloMap, stringWriter);
            } catch (IOException e) {
                halt(500);
                e.printStackTrace();
            } catch (TemplateException e) {
                halt(500);
                e.printStackTrace();
            }
            return stringWriter;
        });
    }

}
