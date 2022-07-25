package com.aem.geeks.core.services.impl;

import com.aem.geeks.core.services.MathematicsOperations;
import org.osgi.service.component.annotations.Component;

@Component(service = MathematicsOperations.class, immediate = true)
public class MathematicsOperationsImpl implements MathematicsOperations{
    @Override
    public int additionsOperation(int a, int b) {
        return a+b;
    }

    @Override
    public int multiplicationOperation(int a, int b) {
        return a*b;
    }
}
