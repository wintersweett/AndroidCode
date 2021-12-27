package com.havefun.shortcode.design;

public class FilterInputStream extends InputStream {
    InputStream in;
    public FilterInputStream(InputStream inputStream) {
        in = inputStream;
    }

    @Override
    public int read() {
        return in.read();
    }
}
