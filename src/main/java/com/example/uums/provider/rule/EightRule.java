package com.example.uums.provider.rule;

import org.jeasy.rules.annotation.*;

/**
 * @author zhigang.peng
 * @date 2021/5/12
 */
@Rule(name = "被8整除")
public class EightRule {

    @Condition
    public boolean isEight(@Fact("number") int number) {
        return number % 8 == 0;
    }

    @Action
    public void eightAction(@Fact("number") int number) {
        System.out.print(number + " is eight");
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}
