package com.appraisaltool.commons;

public class Constants {

    public static final String MAPPING_APPRAISAL_TOOL = "/appraisalTool";

    public static final String ACCEPT_APPLICATION_JSON = "Accept=application/json";

    public static final String TAG_ADMIN = "admin";
    public static final String TAG_APPRAISAL_ASIG = "appraisal-asignement";
    public static final String TAG_APPRAISAL = "appraisal";


    /** The appraisal has been created */
    public static final Integer APPRAISAL_STATUS_NEW = new Integer(0);
    /** The appraisal has been edited one time or more */
    public static final Integer APPRAISAL_STATUS_EDITED = new Integer(1);
    /** The appraisal has been submitted and approved */
    public static final Integer APPRAISAL_STATUS_APPROVED = new Integer(2);
    /** The appraisal has been processed with the others, so this appraisal can't be updated */
    public static final Integer APPRAISAL_STATUS_BLOCKED = new Integer(3);
}
