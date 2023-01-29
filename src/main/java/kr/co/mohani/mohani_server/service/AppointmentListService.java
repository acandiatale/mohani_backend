package kr.co.mohani.mohani_server.service;

import kr.co.mohani.mohani_server.entity.Appointment;
import kr.co.mohani.mohani_server.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentListService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getDayAppointmentList(String group_id, String date) {
        List<Appointment> appointment = appointmentRepository.findAllByGroupIdAndPickedDateTime(group_id, Date.valueOf(date));
        for(Appointment tmp : appointment) {
            log.info(tmp.getWritedTime().toString());
        }
        return appointment;
    }

    public List<Appointment> getAppointmentWithRange(String groupId, String start, String end) {
        log.info("AppointmentListService.getMonthAppointment = groupId : {}, month : {}", groupId, Date.valueOf(start).toString().substring(5, 7));
        return appointmentRepository.findAllByGroupIdAndPickedDateTimeBetween(groupId, Date.valueOf(start), Date.valueOf(end));
    }

    public ResponseEntity<?> addAppointment(Appointment appointment) {
        Appointment checkAppointment = appointmentRepository.findAppointmentByGroupIdAndWritedTime(appointment.getGroupId(), appointment.getWritedTime());
        if(checkAppointment == null) {
            Appointment saved = appointmentRepository.save(appointment);
            log.info(saved.getWritedTime().toString());
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("fail-message", "appointment already exist that time!!");
        return new ResponseEntity<>(headers, HttpStatus.IM_USED);
    }

}
