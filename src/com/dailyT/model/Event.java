package com.dailyT.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	private int eventId;
	private String eventName;
	private String eventStartDate;
	private String eventFinishDate;
	private String eventBanner;
	private String eventPreview;
	private String eventContent;
}
