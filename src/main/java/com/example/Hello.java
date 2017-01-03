package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


/**
 * Created by valdisnei on 02/01/17.
 */
public class Hello implements RequestHandler<DemoRequest,String> {



    @Override
    public String handleRequest(DemoRequest demoRequest, Context context) {
        return demoRequest.toString();
    }


//
//    public String myHandler(Context context) {
//        return context.getIdentity().getIdentityPoolId();
//    }


//    @Override
//    public String handleRequest(String s, Context context) {
//        LambdaLogger logger = context.getLogger();
//        logger.log("identityId:"+context.getIdentity().getIdentityId());
//        logger.log(s);
//        return context.getIdentity().getIdentityId();
//    }

}
