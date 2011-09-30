/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.server.export;

import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author jonny
 */
public interface DataExport {

    /**
     * Writes data, collected for a particular form version, to a stream in a CSV format.
     *
     * @param printWriter the stream to write the data.
     * @param formId the unique identifier of the form version whose data we are to export. This should never be null.
     * @param fromDate the data submission date from which start the export. Supply null to include all dates.
     * @param toDate the data submission date to which to end the export. Supply null to include all dates
     * @param userId the user who submitted the data. Supply null to export data for all users.
     */
    void export(PrintWriter printWriter, Integer formId, Date fromDate, Date toDate, Integer userId);

}
