package com.example.ratedadeece.model;
import junit.framework.TestCase;

public class MenuLoaderTest extends TestCase {
    public void testLoadScript() {
        MenuLoader m = new MenuLoader();
        m.loadScript();

        assertTrue(!m.menuJavaScript.equals(""));
    }
}
