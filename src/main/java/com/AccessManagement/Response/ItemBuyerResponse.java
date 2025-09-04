package com.AccessManagement.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemBuyerResponse {

    private Integer itemId;

    private String itemName;

    private String itemCode;

}
