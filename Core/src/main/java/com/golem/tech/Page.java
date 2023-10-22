package com.golem.tech;

public class Page {
    private String page = "";
    public String getPage() {
        return page;
    }
    private void setPage (String page) {
        this.page = page;
    }
    public PageBuilder builder () {
        return new PageBuilder();
    }
    public static class PageBuilder {
        Page page;
        public PageBuilder () {
            page = new Page();
        }
        public Page build () {
            return page;
        }
        private PageBuilder doubleTag (String teg) {
            page.setPage(page.getPage());
            return this;
        }

        private PageBuilder singleTag (String tag) {
            page.setPage(page.getPage());
            return this;
        }

        public PageBuilder openTag (String tag) {
            page.setPage(page.getPage() + next(oTag(tag)));
            return this;
        }
        public PageBuilder closeTag (String tag) {
            page.setPage(page.getPage() + next(cTag(tag)));
            return this;
        }
        public PageBuilder text (String text) {
            page.setPage(page.getPage() + next(text));
            return this;
        }

        private String oTag (String tag) {
            return "<" + tag + ">";
        }

        private String cTag (String tag) {
            return "</" + tag + ">";
        }

        private String next (String text) {
            return text + "\n";
        }
    }
}
