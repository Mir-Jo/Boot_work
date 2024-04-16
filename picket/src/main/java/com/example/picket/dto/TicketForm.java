package com.example.picket.dto;

import com.example.picket.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TicketForm {
    private String tNum;
    private String tDate;
    private String tTitle;
    private String id;

    public Ticket toEntity() { return new Ticket(tNum, tDate, tTitle, id);}
}
