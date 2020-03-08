package com.laoli.bazooka.spi;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ServiceLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiTest {


    @Test
    public void Example1() {
        Weapon weapon = getWeapon();
        Assert.assertNotNull(weapon);
    }

    private Weapon getWeapon() {
        ServiceLoader<Weapon> loader = ServiceLoader.load(Weapon.class);
        if (loader.iterator().hasNext()){
            return loader.iterator().next();
        }
        return null;
    }
}
