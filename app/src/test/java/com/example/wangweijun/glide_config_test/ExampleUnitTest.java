package com.example.wangweijun.glide_config_test;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        LinkedHashMap<String, String> cache = new LinkedHashMap<>(10, 0.75f, true);
        for(int i=0; i<20; i++) {
            cache.put(""+i, "i="+i);
        }
        System.out.print(cache.size());

    }
}