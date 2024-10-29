package com.maxlvshv.eventshare.repository;

import com.maxlvshv.eventshare.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}