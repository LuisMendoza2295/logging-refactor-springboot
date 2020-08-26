package com.refactor.logger.persistence.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logger")
public class LoggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logger_id")
    private long loggerId;

    @Column(name = "level")
    private String level;

    @Column(name = "message")
    private String message;

    @Column(name = "created")
    private Date created;

    public long getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(long loggerId) {
        this.loggerId = loggerId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
