package com.mongodb;

import freemarker.ext.beans.HashAdapter;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by somebody on 1/18/2017.
 */
public class HelloWorldFreeMarkerStyle {

    public static void main(String[] args) {
        /**
         * create Configuration
         * set class for Template loading
         * create template
         * create StringWriter
         * Create Map
         * process template and pass (map, stringWriter)
         *
         */
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter stringWriter = new StringWriter();
            Map<String, Object> helloMap = new HashMap();
            helloMap.put("name", "Freemarker");
            helloTemplate.process(helloMap, stringWriter);
            System.out.println(stringWriter);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
