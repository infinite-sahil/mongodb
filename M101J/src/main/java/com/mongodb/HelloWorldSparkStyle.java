package com.mongodb;

import spark.Spark;

/**
 * Created by somebody on 1/17/2017.
 */
public class HelloWorldSparkStyle {

    public static void main(String[] args) {
        Spark.get("/", (req, res) -> "Hello World From Spark");
    }

}
