package com.laoli.bazooka.spi.impl;

import com.laoli.bazooka.spi.Weapon;

public class Tank implements Weapon {
    @Override
    public void use() {
        System.out.println("boom");
    }

}
