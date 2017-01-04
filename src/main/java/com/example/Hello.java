package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


/**
 * Created by valdisnei on 02/01/17.
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Hello implements RequestHandler<DemoRequest,String> {


    @Autowired
    private HelloWorldService helloWorldService ;

    private DemoRequest demoRequest;

    private Context context;


    @Override
    public String handleRequest(DemoRequest demoRequest, Context context) {
        String args[] = new String[0];

        ConfigurableApplicationContext ctx = SpringApplication.run(Hello.class, args);
        Hello hello= ctx.getBean(Hello.class);
        hello.setDemoRequest(demoRequest);
        hello.setContext(context);
        try {
            hello.run(args);
            return demoRequest.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        helloWorldService.executaSomeThing(this.getDemoRequest(),this.getContext());

    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }


    public DemoRequest getDemoRequest() {
        return demoRequest;
    }

    public void setDemoRequest(DemoRequest demoRequest) {
        this.demoRequest = demoRequest;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
