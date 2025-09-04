package com.AccessManagement.Response;

import com.AccessManagement.Model.Users;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<Users> usersList;
    private Integer pageCount;
    private Long recordCount;
}
