package com.aem.geeks.core.models.impl;

import com.aem.geeks.core.models.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.Date;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Student.class,
        resourceType = "aemgeeks/components/student",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson" , extensions = "json")
public class StudentImpl implements Student{

    @Inject
    Resource resourcePage;


    @ValueMapValue
    String firstname;

    @ValueMapValue
    String lastname;

    @ValueMapValue
    Date dob;

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public Date getDoB() {
        return dob;
    }

    @JsonProperty(value = "Page Title")
    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return resourcePage.getName();
    }
}
