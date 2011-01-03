package org.openxdata.modules.workflows.server.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;

public class PackageScanner
{

    public static File[] listFiles(String pckgname)
    {
        return (listFiles(pckgname, null));
    }

    public static File[] listFiles(String pckgname, FilenameFilter filter)
    {

        File directory = fromPackageToFile(pckgname);

        if (directory.exists()) {
            // Get the list of the files contained in the package
            if (filter == null)
                return directory.listFiles();
            else
                return directory.listFiles(filter);
        }
        return null;
    }

    /**
     * Converts a package to folder path.Only works if the class
     * are not wrapped in a jar file
     * @param packgName package name
     * @return Directory of the package
     * @throws  NullPointerException if the package name is invalid
     */
    public static File fromPackageToFile(String packgName)
    {
        if (!packgName.startsWith("/")) {
            packgName = "/" + packgName;
        }
        packgName = packgName.replace('.', '/');

        // Get a File object for the package
        URL url = PackageScanner.class.getResource(packgName);
        if (url == null)
            throw new NullPointerException("Package Name is Invalid");
        File directory = new File(url.getFile());
        return directory;
    }
}
