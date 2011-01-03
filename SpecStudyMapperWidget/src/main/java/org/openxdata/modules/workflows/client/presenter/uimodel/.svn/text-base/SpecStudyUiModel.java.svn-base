package org.openxdata.modules.workflows.client.presenter.uimodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openxdata.modules.workflows.model.shared.OSpecification;
import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

public final class SpecStudyUiModel
{

    private List<SpecStudyMap> matches = new ArrayList<SpecStudyMap>();
    private HashMap<String, OSpecification> specs;
    private HashMap<String, StudyDef> studies;

    public SpecStudyUiModel()
    {
        specs = new HashMap<String, OSpecification>();
        studies = new HashMap<String, StudyDef>();
    }

    public SpecStudyUiModel(HashMap<String, OSpecification> specs,
                            HashMap<String, StudyDef> studies)
    {
        setSpecsAndStudies(specs, studies);
    }

    public SpecStudyMap getMapWithUniqueName(String matchString)
    {
        SpecStudyMap matchToRemove = null;
        for (SpecStudyMap match : this.matches) {
            if (match.toString().equals(matchString)) {
                matchToRemove = match;
                break;
            }
        }
        return matchToRemove;
    }

    public void setSpecsAndStudies(HashMap<String, OSpecification> specs,
                                   HashMap<String, StudyDef> studies)
    {
        matches.clear();
        this.specs = specs;
        this.studies = studies;
    }

    public ArrayList<OSpecification> getSpecsAsList()
    {
        return new ArrayList<OSpecification>(specs.values());
    }

    public List<StudyDef> getStudiesAsList()
    {
        return new ArrayList<StudyDef>(studies.values());
    }

    public List<SpecStudyMap> getMaps()
    {
        return new ArrayList<SpecStudyMap>(matches);
    }

    public SpecStudyMap addMatch(SpecStudyMap match)
    {
        if (!isValid(match)) {
            return null;
        }

        if (similarMapExists(match)) {
            return null;
        }

        specs.remove(match.getoSpecification().toString());
        studies.remove(match.getStudyDef().getName());

        matches.add(match);
        return match;
    }

    public SpecStudyMap match(String specName, String studyName)
    {
        if (specName == null || studyName == null) {
            return null;
        }

        OSpecification spec = specs.get(specName);
        StudyDef study = studies.get(studyName);

        if (spec == null || study == null) {
            return null;
        }

        SpecStudyMap match = new SpecStudyMap(spec, study);
        return addMatch(match);
    }

    public void addStudy(StudyDef study)
    {
        for (SpecStudyMap match : matches) {
            if (match.getStudyDef().getName().equals(study.getName())) {
                return;
            }
        }
        studies.put(study.getName(), study);
    }

    public void removeStudy(StudyDef study)
    {
        studies.remove(study.getName());
    }

    public void addSpec(OSpecification spec)
    {
        for (SpecStudyMap match : matches) {
            if (match.getoSpecification().getUniqueName().equals(spec.getUniqueName())) {
                return;
            }
        }
        specs.put(spec.toString(), spec);
    }

    public void removeSpec(OSpecification spec)
    {
        specs.remove(spec.getUniqueName());
    }

    private boolean isValid(SpecStudyMap match)
    {
        OSpecification spec = match.getoSpecification();
        StudyDef studyDef = match.getStudyDef();

        if (matches.contains(match)) {
            return true;
        }
        if (specs.containsValue(spec) && studies.containsValue(studyDef)) {
            return true;
        }

        return false;
    }

    public boolean hasStudy(StudyDef studyDef)
    {
        for (StudyDef study : studies.values()) {
            if (study.getName().equals(studyDef.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSpec(OSpecification spec)
    {
        for (OSpecification oSpec : specs.values()) {
            if (spec.getUniqueName().equals(oSpec.getUniqueName())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMatch(String mString)
    {
        for (SpecStudyMap match : this.matches) {
            if (match.toString().equals(mString)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMatch(SpecStudyMap match)
    {
        return hasMatch(match.toString());
    }

    public SpecStudyMap removeMatch(String matchString)
    {
        SpecStudyMap matchToRemove = getMapWithUniqueName(matchString);

        if (matchToRemove == null) {
            return null;
        }
        matches.remove(matchToRemove);
        addSpec(matchToRemove.getoSpecification());
        addStudy(matchToRemove.getStudyDef());
        return matchToRemove;
    }

    public boolean similarMapExists(SpecStudyMap match)
    {
        for (SpecStudyMap specStudyMap : matches) {
            if (specStudyMap.getUniqueName().equals(match.getUniqueName())) {
                return true;
            }
        }
        return false;
    }
}
