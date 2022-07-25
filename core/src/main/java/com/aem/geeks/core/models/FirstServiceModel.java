package com.aem.geeks.core.models;

import com.aem.geeks.core.services.MathematicsOperations;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


@Model(adaptables = Resource.class)
public class FirstServiceModel {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    MathematicsOperations mathematicsOperations;

    @Inject
    @ValueMapValue
    @Optional
    @Named("firstNumber")
    private int firstNumber;

    @Inject
    @ValueMapValue
    @Optional
    @Named("secondNumber")
    private int secondNumber;

    private boolean isTouch;

    private int sum;

    private int multiplication;

    @PostConstruct
    public void init() {
        logger.info("Iam info statement");
        logger.info("Iam warn statement");
        logger.info("Iam error statement");
        logger.info("Iam debug statement");
        sum = mathematicsOperations.additionsOperation(firstNumber, secondNumber);
        multiplication = mathematicsOperations.multiplicationOperation(firstNumber, secondNumber);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public boolean isTouch() {
        return isTouch;
    }

    public int getSum() {
        return sum;
    }

    public int getMultiplication() {
        return multiplication;
    }
}
