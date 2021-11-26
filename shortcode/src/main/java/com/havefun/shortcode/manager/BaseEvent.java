package com.havefun.shortcode.manager;

import java.util.Objects;

public class BaseEvent implements Comparable {
    public int flag;
    public String str;
    public String msg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEvent baseEvent = (BaseEvent) o;
        return flag == baseEvent.flag &&
                Objects.equals(str, baseEvent.str) &&
                Objects.equals(msg, baseEvent.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, str, msg);
    }

    @Override
    public int compareTo(Object o) {

        return this.equals(o) ? 0 : 1;
    }
}
