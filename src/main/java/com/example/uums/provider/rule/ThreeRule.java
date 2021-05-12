package com.example.uums.provider.rule;

import org.jeasy.rules.annotation.*;

/**
 * @author zhigang.peng
 * @date 2021/5/12
 */
@Rule(name = "被3整除", description = "number如果被3整除，打印：number is three")
public class ThreeRule {

    @Condition
    public boolean isThree(@Fact("number") int number) {
        return number % 3 == 0;
    }

    @Action
    public void threeAction(@Fact("number") int number) {
        System.out.print(number + " is three");
    }

    @Priority
    public int getPriority() {
        return 1;
    }
}
