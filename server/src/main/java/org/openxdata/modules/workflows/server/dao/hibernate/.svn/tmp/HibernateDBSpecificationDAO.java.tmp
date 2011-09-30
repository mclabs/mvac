package org.openxdata.modules.workflows.server.dao.hibernate;

import com.trg.search.Search;
import org.openxdata.modules.workflows.server.dao.DBSpecificationDAO;
import org.openxdata.modules.workflows.model.shared.DBSpecification;
import org.openxdata.server.dao.hibernate.BaseDAOImpl;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kay
 */
@Repository("specDAO")
public class HibernateDBSpecificationDAO extends BaseDAOImpl<DBSpecification>
        implements DBSpecificationDAO
{
    @Override
    public DBSpecification getDBSpecBySpecID(String specId)
    {
        return searchUniqueByPropertyEqual("specId", specId);
    }

    @Override
    public DBSpecification getDBSpecBySpecID(String specID, String version)
    {
       Search search = new Search();
       search.addFilterEqual("name", specID);
       search.addFilterEqual("version", version);
       return searchUnique(search);
    }
}
