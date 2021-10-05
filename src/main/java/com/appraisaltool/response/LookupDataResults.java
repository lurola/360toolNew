package com.appraisaltool.response;

import java.util.List;
import lombok.Data;

@Data
public class LookupDataResults {

    private String lookupName;

    private List<LookupData> results;

}
