package com.AccessManagement.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_Email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "email_generator")
    @SequenceGenerator(name = "email_generator", sequenceName = "Email_SEQUENCE", initialValue=1,allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "attempt_count")
    private Integer attemptCount;

    @Column(name = "SubOrganizationId")
    private Integer SubOrganizationId;

    @Column(name = "isSend")
    private Boolean  isSend;

    @Column(name = "sub_type")
    private Integer subType;

    @Column(name = "sub_type_name")
    private String subTypeName;

    @Column(name = "LoginUrl")
    private String loginUrl;

    @Column(name = "subject_line")
    private String subjectLine;

    @Column(name = "template_name")
    private String templateName;

    @Column(name = "to_user")
    private Integer toUser;

    @Column(name = "type")
    private String type;



}
