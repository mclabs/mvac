/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.server.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kay
 */
public class PackageScannerTest
{

    private String correctPackage = "org.openxdata.modules.workflows.server.resources";
    private String wrongPackage = "this.does.not.exist";

    public PackageScannerTest()
    {
    }


    /**
     * Test of listFiles method, of class PackageScanner.
     */
    @Test
    public void testListFiles_String_FilenameFilter()
    {
        System.out.println("listFiles");

        FilenameFilter filter = new FilenameFilter()
        {

            public boolean accept(File dir, String name)
            {
                return name.endsWith(".yawl");
            }
        };

        File[] result = PackageScanner.listFiles(correctPackage+".specs", filter);

        assertNotNull(result);

        for (File file : result) {
            assertTrue(file.getName().endsWith(".yawl"));
        }
    }

    /**
     * Test of fromPackageToFile method, of class PackageScanner.
     */
    @Test
    public void testFromPackageToFile()
    {
        System.out.println("fromPackageToFile");
       
        File expResult = null;
        try {
            PackageScanner.fromPackageToFile(wrongPackage);
            fail("Result is supposed to null");
        } catch (NullPointerException ex) {
        }

        URL url = fromPackageToUrl(correctPackage);
        expResult = new File(url.getPath());
        File result = PackageScanner.fromPackageToFile(correctPackage);
        assertEquals(expResult.getAbsolutePath(), result.getAbsolutePath());
    }

    private URL fromPackageToUrl(String packgName)
    {
        URL url = getClass().getResource("/" + packgName.replace('.', '/'));
        return url;
    }
}
