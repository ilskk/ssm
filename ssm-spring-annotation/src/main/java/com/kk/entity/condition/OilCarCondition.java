package com.kk.entity.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OilCarCondition implements Condition {

    //如果当前环境是Oil,则加入OilCar
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取环境
        Environment environment=conditionContext.getEnvironment();
        String carType = environment.getProperty("car.type");//car.type="oil"

        return carType.contains("oil");
    }
}
