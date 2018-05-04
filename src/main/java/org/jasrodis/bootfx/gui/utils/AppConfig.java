package org.jasrodis.bootfx.gui.utils;

public class AppConfig extends AbstractAppConfig {

    public static AppConfig getInstance() {
        return AbstractAppConfig.getInstance();
    }

    /* ***************************************************************************************************/
    /* *********************************** Properties initialization ***********************************/
    /* ***************************************************************************************************/

    private CssConfig css = new CssConfig();


    public CssConfig getCss() {
        return css;
    }

    public void setCss(CssConfig cssConfig) {
        this.css = cssConfig;
    }

    /* ***************************************************************************************************/
    /* ************************************ Property Classes ************************************/
    /* ***************************************************************************************************/

    public static class CssConfig {

        private String mainCssLocation;

        public String getMainCssLocation() {
            return mainCssLocation;
        }

        public void setMainCssLocation(String mainCssLocation) {
            this.mainCssLocation = mainCssLocation;
        }

    }

}
