package com.havefun.androidstudy;

import java.util.Objects;

public class Bean {
    String name;
    int age;
    String sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return age == bean.age && name.equals(bean.name) && sex.equals(bean.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}
