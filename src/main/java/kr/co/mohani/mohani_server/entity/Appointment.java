package kr.co.mohani.mohani_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "APPOINTMENT")
@SequenceGenerator(
        name = "APPOINTMENT_SEQ_GENERATOR",
        sequenceName = "APPOINTMENT_SEQ",
        initialValue = 1,
        allocationSize = 1
)
public class Appointment {

    @Column
    private String content;
    @Column(name = "GROUP_ID")
    private String groupId;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT_SEQ_GENERATOR")
    @Column(name = "APPOINTMENT_ID")
    private Long appointmentId;
    @Column(name = "PICKED_DATETIME")
    private Date pickedDatetime;
    @Column(name = "writed_time")
    private Timestamp writedTime;

}
