package org.xiaojin.common.base;

import cn.hutool.core.util.ObjectUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * @author JayWatson
 * @version 1.0.0
 * @ClassName extendMap.java
 * @Description TODO
 * @createTime 2024年05月13日 15:20:00
 */
public class ExtendMap extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ExtendMap() {
    }

    public ExtendMap(Map<String, Object> map) {
        this.putAll(map);
    }

    public ExtendMap put(String key, Object value) {
        super.put(key, Optional.ofNullable(value).orElse(""));
        return this;
    }

    public ExtendMap add(String key, Object value) {
        super.put(key, Optional.ofNullable(value).orElse(""));
        return this;
    }

    public <T> T get(String key) {
        Object obj = super.get(key);
        return ObjectUtil.isNotEmpty(obj) ? (T) obj : null;
    }

    public Boolean getBoolean(String key) {
        Object obj = super.get(key);
        return ObjectUtil.isNotEmpty(obj) ? Boolean.valueOf(obj.toString()) : false;
    }

    public Long getLong(String key) {
        Object v = this.get(key);
        return ObjectUtil.isNotEmpty(v) ? Long.parseLong(v.toString()) : null;
    }

    public Long[] getLongs(String key) {
        Object v = this.get(key);
        return ObjectUtil.isNotEmpty(v) ? (Long[])((Long[])v) : null;
    }

    public List<Long> getListLong(String key) {
        List<String> list = (List)this.get(key);
        return ObjectUtil.isNotEmpty(list) ? (List)list.stream().map((e) -> {
            return Long.parseLong(e);
        }).collect(Collectors.toList()) : null;
    }

    public Long[] getLongIds(String key) {
        Object ids = this.get(key);
        return ObjectUtil.isNotEmpty(ids) ? (Long[])((Long[])ConvertUtils.convert(ids.toString().split(","), Long.class)) : null;
    }

    public Integer getInt(String key, Integer def) {
        Object v = this.get(key);
        return ObjectUtil.isNotEmpty(v) ? Integer.parseInt(v.toString()) : def;
    }

    public Integer getInt(String key) {
        Object v = this.get(key);
        return ObjectUtil.isNotEmpty(v) ? Integer.parseInt(v.toString()) : 0;
    }

    public BigDecimal getBigDecimal(String key) {
        Object v = this.get(key);
        return ObjectUtil.isNotEmpty(v) ? new BigDecimal(v.toString()) : new BigDecimal("0");
    }

    public <T> T get(String key, T def) {
        Object obj = super.get(key);
        return ObjectUtil.isEmpty(obj) ? def : (T) obj;
    }

    public static ExtendMap toBaseMap(Map<String, Object> obj) {
        ExtendMap map = new ExtendMap();
        map.putAll(obj);
        return map;
    }
}
