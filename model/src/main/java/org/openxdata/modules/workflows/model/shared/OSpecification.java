package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The uniqueness of a specification is represented by name + version
 * 
 * @author kay
 * 
 */
public class OSpecification implements Serializable
{

  
    private String name;
    private String version;
    private String id;
    private ArrayList<OTask> tasks;
    private ArrayList<ODecomposition> decompositions;

    OSpecification()
    {
    }

    public OSpecification(String id, ArrayList<OTask> tasks,
	    ArrayList<ODecomposition> decompositions)
    {
	this.id = id;
	this.tasks = tasks;
	this.decompositions = decompositions;
    }

    public ArrayList<ODecomposition> getDecompositions()
    {
	return decompositions;
    }

    public void setDecompositions(ArrayList<ODecomposition> decompositions)
    {
	this.decompositions = decompositions;
    }

    public String getId()
    {
	return id;
    }

    public void setId(String id)
    {
	this.id = id;
    }

    public ArrayList<OTask> getTasks()
    {
	return tasks;
    }

    public void setTasks(ArrayList<OTask> tasks)
    {
	this.tasks = tasks;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getVersion()
    {
	return version;
    }

    public void setVersion(String version)
    {
	this.version = version;
    }

    @Override
    public String toString()
    {
	return name + version;
    }

    public String getUniqueName()
    {
	return toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSpecification other = (OSpecification) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.version == null) ? (other.version != null) : !this.version.equals(other.version)) {
            return false;
        }
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.version != null ? this.version.hashCode() : 0);
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    
}
