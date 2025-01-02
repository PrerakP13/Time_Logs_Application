package com.timelogs.mytimelogs.data;

import com.timelogs.mytimelogs.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
