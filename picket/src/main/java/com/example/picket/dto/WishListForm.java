package com.example.picket.dto;

import com.example.picket.entity.WishList;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WishListForm {
    private String wTitle;
    private String wId;

    public WishList toEntity() { return new WishList(wTitle, wId);}
}
