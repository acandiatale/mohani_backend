package kr.co.mohani.mohani_server.repository;

import kr.co.mohani.mohani_server.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment findByAppointmentId(int appointment_id);

    List<Appointment> findAllByGroupIdAndPickedDateTimeBetween(String groupId, Date start, Date end);
    List<Appointment> findAllByGroupIdAndPickedDateTime(String groupId, Date pickedDateTime);

    Appointment findAppointmentByGroupIdAndWritedTime(String groupId, Timestamp writedTime);

}