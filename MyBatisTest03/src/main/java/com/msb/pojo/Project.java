package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: dengjq
 * @Date: 2022/8/15
 * @Description: com.msb.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    private Integer pid;
    private String name;
    private Integer money;

    private List<ProjectRecord> projectRecords;
}
