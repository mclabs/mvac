/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.export;

import java.util.List;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openxdata.server.admin.model.FormData;
import org.openxdata.server.export.rdbms.engine.DataBuilder;
import org.openxdata.server.export.rdbms.engine.DataQuery;
import org.openxdata.server.export.rdbms.engine.RdmsEngine;
import org.openxdata.server.export.rdbms.engine.TableQuery;
import org.openxdata.server.util.XmlUtil;

/**
 *
 * @author Jonny Heggheim
 */
@RunWith(ConcordionRunner.class)
public class ExportRdbmsAcceptanceTest {

    public String generateTables(String definition) throws Exception {
        StringBuilder result = new StringBuilder();
        List<TableQuery> queries = RdmsEngine.getStructureSql(definition, 0);
        for (TableQuery tableQuery : queries) {
            String sql = tableQuery.getSql();
            result.append(sql);
            result.append("\n");
        }

        return result.toString();
    }

    public String generateData(String definition, String data) throws Exception {
        definition = definition.trim();
        data = data.trim();

        return "INSERT INTO blah (asdasd) values (blah)";
    }
}
