package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import org.springframework.stereotype.Component;

/**
 * Created by Valdisnei on 03/01/2017.
 */
@Component
public class HelloWorldService {


    public String executaSomeThing(DemoRequest demoRequest, Context context){
        return demoRequest.toString();
    }
}
