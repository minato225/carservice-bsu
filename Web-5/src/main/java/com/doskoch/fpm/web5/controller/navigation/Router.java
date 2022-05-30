package com.doskoch.fpm.web5.controller.navigation;

import static com.doskoch.fpm.web5.controller.navigation.PageNavigation.DEFAULT;

public class Router {

    private String page = DEFAULT;
    private PageChangeType type = PageChangeType.FORWARD;

    public enum PageChangeType {FORWARD, REDIRECT}

    public Router() {
    }

    public Router(String page) {
        this.page = (page != null ? page : DEFAULT);
    }

    public Router(String page, PageChangeType type) {
        this.page = (page != null ? page : DEFAULT);
        this.type = (type != null ? type : PageChangeType.FORWARD);
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = (page != null ? page : DEFAULT);
    }

    public void setRedirect() {
        this.type = PageChangeType.REDIRECT;
    }

    public void setForward() {
        this.type = PageChangeType.FORWARD;
    }

    public PageChangeType getType() {
        return type;
    }
}
