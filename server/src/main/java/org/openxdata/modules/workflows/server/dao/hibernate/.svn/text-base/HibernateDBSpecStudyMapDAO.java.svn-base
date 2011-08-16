package org.openxdata.modules.workflows.server.dao.hibernate;

import com.trg.search.Search;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.SQLQuery;
import org.openxdata.modules.workflows.server.dao.DBSpecStudyMapDAO;
import org.openxdata.modules.workflows.model.shared.DBSpecStudyMap;
import org.openxdata.server.dao.hibernate.BaseDAOImpl;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kay
 */
@Repository("specStudyMapDAO")
public class HibernateDBSpecStudyMapDAO extends BaseDAOImpl<DBSpecStudyMap>
        implements DBSpecStudyMapDAO
{
    @Override
    public boolean save(DBSpecStudyMap entity)
    {
        if (entity.getId() == 0) {
            return saveAndReloadToSetXMLID(entity);
        } else {
            entity.setXml(replaceIdIfZero(entity.getId(), entity.getXml()));
            return super.save(entity);
        }
    }

    private boolean saveAndReloadToSetXMLID(DBSpecStudyMap map)
    {
        super.save(map);//Save
        //Reload to set the xml sql generated id
        Search srch = new Search(map.getClass());
        srch.addFilterEqual("specifications", map.getSpecifications());
        srch.addFilterEqual("study", map.getStudy());
        DBSpecStudyMap searchUnique = searchUnique(srch);//Reload
        String mapXml = searchUnique.getXml();
        searchUnique.setXml(replaceIdIfZero(searchUnique.getId(), mapXml));
        return super.save(searchUnique);//save again
    }

    public String replaceIdIfZero(int id, String xmlMap)
    {
        //Preferred not to use an xml parser to just simply and improve on speed
        int startTag = xmlMap.indexOf("<SpecStudyMap");
        int closeTag = xmlMap.indexOf(">", startTag);

        String mapTag = xmlMap.substring(startTag, closeTag);

        String regex = "Id[\\s]*=[\\s]*[\"|\']0[\"|\']";//id="0" or id='0'
        Matcher matcher = Pattern.compile(regex).matcher(mapTag);
        if (matcher.find()) {
            String newMapTag = mapTag.replace(matcher.group(0), "Id='" + id + "'");
            String newXmlMap = xmlMap.replace(mapTag, newMapTag);
            return newXmlMap;
        }
        return xmlMap;
    }

    @Override
    public DBSpecStudyMap getMap(String caseID, String taskID)
    {
            //TODO: Paranameters should probably change from case id and taskid to
            //specversion and specid
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT {map.*} FROM wf_spec_study_maps map         ");
        builder.append(" INNER JOIN wf_specifications                       ");
        builder.append("   ON (map.spec_id = wf_specifications.id)          ");
        builder.append(" INNER JOIN  wf_workitems                           ");
        builder.append("   ON (wf_workitems.SPECID = wf_specifications.name ");
        builder.append("   AND SPECVERSION = wf_specifications.version)     ");
        builder.append(" WHERE CASEID=:caseID AND TASKID=:taskID            ");

        SQLQuery query = getSession().createSQLQuery(builder.toString());
        query.addEntity("map", DBSpecStudyMap.class);
        query.setParameter("caseID", caseID);
        query.setParameter("taskID", taskID);
        return (DBSpecStudyMap) query.uniqueResult();
    }

}
