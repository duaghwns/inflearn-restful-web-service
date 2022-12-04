package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
// @JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
@NoArgsConstructor
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;

    @Past
    @ApiModelProperty(notes = "등록일을 입력해 주세요.")
    private Date regDate;

    @ApiModelProperty(notes = "비밀번호를 입력해 주세요.")
    private String password;

    // @JsonIgnore // Response 데이터 제어를 위한 필터링
    @ApiModelProperty(notes = "주민번호를 입력해 주세요.")
    private String ssn;
}
