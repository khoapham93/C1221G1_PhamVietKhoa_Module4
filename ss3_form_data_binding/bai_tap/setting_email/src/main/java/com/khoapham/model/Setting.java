package com.khoapham.model;

public class Setting {
    private String language;
    private Integer pageSize;
    private Boolean spamFilter;
    private String signature;

    public Setting(String language, Integer pageSize, Boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public Setting() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(Boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", spamFilter=" + spamFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
