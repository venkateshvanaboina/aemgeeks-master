package com.aem.geeks.core.models.impl;


import com.aem.geeks.core.models.First;
import com.aem.geeks.core.models.Student;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = First.class,
        resourceType = "aemgeeks/components/first",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FirstImpl implements First {

    @Inject
    Resource resourcePage;


    @ValueMapValue
    String firstname;

    @ValueMapValue
    String file;

    @ValueMapValue
    String lastname;

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getFile() {
        return file;
    }


    @Override
    public String getTitle() {
        return resourcePage.getName();
    }
}
