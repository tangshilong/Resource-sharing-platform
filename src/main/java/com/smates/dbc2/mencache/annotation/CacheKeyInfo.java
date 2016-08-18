package com.smates.dbc2.mencache.annotation;

/**
 * 解析带annotation cacheKey的方法时候的临时包装类,包括标注参数的值与index
 */
public class CacheKeyInfo implements Comparable<CacheKeyInfo> {
    private String value;
    private int index;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public CacheKeyInfo() {

    }

    public CacheKeyInfo(String value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(CacheKeyInfo o) {
        return this.getIndex() - o.getIndex();
    }

}
