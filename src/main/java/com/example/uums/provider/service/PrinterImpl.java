package com.example.uums.provider.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhigang.peng
 * @date 2021/5/11
 */
@Service
public class PrinterImpl implements Printer {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void print() {
        System.out.println("hello world");
    }
}
