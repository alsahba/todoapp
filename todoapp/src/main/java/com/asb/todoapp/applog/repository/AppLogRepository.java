package com.asb.todoapp.applog.repository;

import com.asb.todoapp.applog.entity.AppLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppLogRepository extends JpaRepository<AppLog, Long> {
}
