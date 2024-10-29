package com.maxlvshv.eventshare.dto;

import java.sql.Date;

/**
 * DTO for {@link com.maxlvshv.eventshare.entity.Event}
 */
public record EventScrollDto(String name, String location, Date date_start) {
}