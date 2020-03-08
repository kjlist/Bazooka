package com.laoli.bazooka.spi.impl;

import com.laoli.bazooka.spi.Weapon;

public class Gun implements Weapon {
    @Override
    public void use() {
        System.out.println("biu");
    }

}
